package test;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import gui.shared.LayoutColors;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class buttonTest {

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 900, 675);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(900, 75));

        // 定制消息框关闭按钮
        class MessageCloseBtn extends JButton {

            private boolean isFocus = false;

            public MessageCloseBtn(){
                super();
                setupUI();
            }

            private void setupUI(){
                this.setPreferredSize(new Dimension(20, 20));
                this.setText(null);
                this.setBorderPainted(false);
                this.setContentAreaFilled(false);
                this.setOpaque(true);

                this.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        toggleState();
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        setCursor(Cursor.getDefaultCursor());
                        toggleState();
                    }
                });
            }

            @Override
            public void paint(Graphics g) {
                Graphics2D g2d = (Graphics2D)g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                if (isFocus) {
                    g2d.setColor(Color.WHITE);
                    g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                    g2d.drawLine(6, 6, 13, 13);
                    g2d.drawLine(6, 13, 13, 6);
                }
                else{
                    g2d.setColor(LayoutColors.LIGHT_BLUE);
                    g2d.fillRect(0, 0, 20, 20);
                }
            }

            /**
             * 改变按钮状态并重绘
             */
            public void toggleState(){
                isFocus = !isFocus;
                repaint();
            }

        }

        // 定制消息内容框
        class MessageContent extends JTextArea {

            public MessageContent(String mes){
                super();
                setupUI(mes);
            }

            private void setupUI(String displayText){
                this.setPreferredSize(new Dimension(220, 100));
                this.setFont(new Font("微软雅黑", Font.PLAIN, 12));
                this.setText(displayText);
                this.setEditable(false);
                this.setOpaque(true);
                this.setBorder(null);
                UIDefaults messageContentDefault = new UIDefaults();
                messageContentDefault.put("TextArea.contentMargins", new Insets(10, 10, 10, 10));
                messageContentDefault.put("TextArea[Enabled].backgroundPainter", (Painter<JComponent>)(g2d, c, width, height) -> {
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2d.setColor(LayoutColors.BLUE);
                    g2d.fillRoundRect(0, 0, width, height, 10, 10);
                });
                this.putClientProperty("Nimbus.Overrides", messageContentDefault);
                this.putClientProperty("Nimbus.Overrides.InheritDefaults", false);
            }

        }

        // 定制消息框
        class MessageBox extends JPanel {

            private MessageCloseBtn closeBtn;
            private MessageContent messageContent;

            public MessageBox(){
                super();
                setupUI();
            }

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D)g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(getBackground());
                g2d.fillRoundRect(0, 0, 250, 150, 15, 15);
            }

            private void setupUI(){
                this.setPreferredSize(new Dimension(250, 150));
                this.setOpaque(true);
                this.setBackground(LayoutColors.LIGHT_BLUE);
                this.setLayout(new FormLayout("center:5px:noGrow,center:d:grow,center:5px:noGrow", "center:5px:noGrow,center:d:noGrow,center:10px:noGrow,center:d:noGrow,center:10px:noGrow"));
                CellConstraints cc = new CellConstraints();

                for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(laf.getName())) {
                        try {
                            UIManager.setLookAndFeel(laf.getClassName());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                closeBtn = new MessageCloseBtn();
                this.add(closeBtn, cc.xy(2, 2, CellConstraints.RIGHT, CellConstraints.DEFAULT));
                messageContent = new MessageContent("这是消息");
                this.add(messageContent, cc.xy(2, 4, CellConstraints.CENTER, CellConstraints.DEFAULT));
            }
        }

        // 定制滚动面板内面板
        class MyPanel extends JPanel {

            private LinkedList<MessageBox> mesList;  // 信息列表，存放每个消息框对象
            private FormLayout formLayout;  // 信息界面布局

            public MyPanel(){
                super();
                setupUI();
            }

            private void setupUI(){
                mesList = new LinkedList<>();
                formLayout = new FormLayout("center:10px:noGrow,center:d:grow,center:10px:noGrow", "center:20px:noGrow");
                this.setOpaque(true);
                this.setBackground(Color.WHITE);
                this.setLayout(formLayout);
                CellConstraints cc = new CellConstraints();
                for (int i = 0, j = 2; i < 20; i++, j += 2) {
                    MessageBox b = new MessageBox();
                    mesList.add(b);  // 加入列表
                    formLayout.appendRow(RowSpec.decode("center:d:noGrow"));
                    this.add(b, cc.xy(2, j, CellConstraints.CENTER, CellConstraints.DEFAULT));
                    formLayout.appendRow(RowSpec.decode("center:20px:noGrow"));
                }
            }
        }

        // 定制滚动面板
        class MyScrollPane extends JScrollPane {

            private MyPanel panel;

            /**
             * 滚动条UI类
             * @author Jackie
             */
            class MyScrollBarUI extends BasicScrollBarUI {

                /**
                 * 滚动条监听器类
                 * @author Jackie
                 */
                class MyScrollBarListener extends TrackListener {

                    /**
                     * 处理鼠标释放事件
                     * @param e 鼠标事件对象
                     */
                    @Override
                    public void mouseReleased(MouseEvent e) {
//                System.out.println("鼠标释放");
                        super.mouseReleased(e);
                        Rectangle r = getThumbBounds();
                        // 如果鼠标释放时，鼠标在滑块内，视为鼠标悬停；否则，视为鼠标未进入窗口
                        if (getThumbBounds().contains(e.getPoint())){
                            thumbColor = Color.GRAY;
                        }
                        else {
                            thumbColor = Color.LIGHT_GRAY;
                        }
                        scrollbar.repaint(r);
                    }

                    /**
                     * 处理鼠标按下事件
                     * @param e 鼠标事件对象
                     */
                    @Override
                    public void mousePressed(MouseEvent e) {
//                System.out.println("鼠标按下");
                        thumbColor = Color.DARK_GRAY;
                        super.mousePressed(e);
                    }

                    /**
                     * 处理鼠标进入事件
                     * @param e 鼠标事件对象
                     */
                    @Override
                    public void mouseEntered(MouseEvent e) {
//                System.out.println("鼠标进入");
                        Rectangle r = getThumbBounds();
                        // 如果鼠标进入时不在滑块范围内，不变色
                        if (getThumbBounds().contains(e.getPoint())){
                            thumbColor = Color.GRAY;
                            scrollbar.repaint(r);
                        }
                    }

                    /**
                     * 处理鼠标退出事件
                     * @param e 鼠标事件对象
                     */
                    @Override
                    public void mouseExited(MouseEvent e) {
//                System.out.println("鼠标退出");
                        super.mouseExited(e);
                        if (isDragging) return;  // 鼠标拖动时移出窗口不变颜色
                        Rectangle r = getThumbBounds();
                        thumbColor = Color.LIGHT_GRAY;
                        scrollbar.repaint(r);
                    }
                }

                /**
                 * 初始化控件颜色
                 */
                @Override
                protected void configureScrollBarColors() {
                    super.configureScrollBarColors();
                    trackColor = Color.WHITE;
                    thumbColor = Color.LIGHT_GRAY;
                    thumbHighlightColor = Color.WHITE;
                    thumbLightShadowColor = Color.WHITE;
                    thumbDarkShadowColor = Color.WHITE;
                }

                /**
                 * 重绘滑块
                 * @param g 图形类对象
                 * @param c 控件类对象
                 * @param thumbBounds 滑块矩形类
                 */
                @Override
                protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
                    if(thumbBounds.isEmpty() || !scrollbar.isEnabled()) {
                        return;
                    }

                    Graphics2D g2d = (Graphics2D)g;

                    int w = thumbBounds.width;
                    int h = thumbBounds.height;

                    g2d.translate(thumbBounds.x, thumbBounds.y);

                    g2d.setColor(thumbColor);
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2d.fillRoundRect(0, 0, w - 1, h - 1, 10, 10);

                    g2d.translate(-thumbBounds.x, -thumbBounds.y);
                }

                /**
                 * 初始化UI
                 * @param c 控件类
                 */
                @Override
                public void installUI(JComponent c) {
                    super.installUI(c);

                    // 去掉按钮
                    scrollbar.remove(decrButton);
                    scrollbar.remove(incrButton);
                    scrollbar.setOpaque(true);
                    scrollbar.setBackground(Color.WHITE);
                    scrollbar.repaint();
                }

                /**
                 * 初始化基本属性
                 */
                @Override
                protected void installDefaults() {
                    super.installDefaults();

                    scrollBarWidth = 10;
                }

                /**
                 * 创建滑轨监听器
                 * @return 返回滑轨监听器对象
                 */
                @Override
                protected TrackListener createTrackListener() {
                    return new MyScrollBarListener();
                }
            }

            public MyScrollPane(){
                super();
                setupUI();
            }

            private void setupUI(){
                this.setPreferredSize(new Dimension(300, 600));
                this.setOpaque(true);
                this.setBackground(Color.WHITE);
                this.setBorder(null);
                panel = new MyPanel();
                this.setViewportView(panel);
                this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                this.getVerticalScrollBar().setUI(new MyScrollBarUI());
            }
        }

        // 定制侧边框
        class MyPopupMenu extends JPopupMenu {

            private MyScrollPane myScrollPane;

            public MyPopupMenu(){
                super();
                setupUI();
            }

            private void setupUI(){
                this.setPopupSize(new Dimension(300, 600));
                this.setOpaque(true);
                this.setBackground(Color.WHITE);
                this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
                myScrollPane = new MyScrollPane();
                this.add(myScrollPane);
            }
        }

        class MyButton extends JButton {

            private MyPopupMenu popupMenu;
            private BufferedImage normalIcon;
            private BufferedImage focusIcon;
            private final int WIDTH = 30;
            private final int HEIGHT = 30;
            private boolean isFocus = false;

            /**
             * 初始化按钮
             */
            public MyButton() throws IOException {
                super();
                setupIcon();
                setupPopupMenu();
                setupUI();
            }

            private void setupIcon() throws IOException {
                normalIcon = ImageIO.read(new File("icons/MessageBtnNormal.png"));
                focusIcon = ImageIO.read(new File("icons/MessageBtnFocus.png"));
            }

            /**
             * 重绘按钮样式
             * @param g 画图对象
             */
            @Override
            public void paint(Graphics g) {
                Graphics2D g2d = (Graphics2D)g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                if (isFocus) {
                    g2d.drawImage(focusIcon, null, 0, 0);
                }
                else {
                    g2d.drawImage(normalIcon, null, 0, 0);
                }
            }

            /**
             * 改变按钮状态并重绘
             */
            public void toggleState(){
                isFocus = !isFocus;
                this.repaint();
            }

            private void setupPopupMenu(){
                popupMenu = new MyPopupMenu();
            }

            private MyButton getThis(){
                return this;
            }

            /**
             * 初始化按钮属性
             */
            private void setupUI(){
                this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
                this.setText(null);
                this.setBorderPainted(false);
                this.setContentAreaFilled(false);

                this.addMouseListener(new MouseAdapter() {

                    /**
                     * 设置鼠标进入事件
                     * @param e 鼠标事件
                     */
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        toggleState();
                    }

                    /**
                     * 设置鼠标退出事件
                     * @param e 鼠标事件
                     */
                    @Override
                    public void mouseExited(MouseEvent e) {
                        setCursor(Cursor.getDefaultCursor());
                        toggleState();
                    }

                    /**
                     * 设置鼠标点击事件
                     * @param e 鼠标事件对象
                     */
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        popupMenu.setInvoker(getThis());
                        popupMenu.setVisible(true);
                        popupMenu.setLocation(600, 75);
                    }
                });
            }
        }

        MyButton btn = new MyButton();

        panel.add(btn);
        frame.add(panel);

        frame.setVisible(true);
    }

}
