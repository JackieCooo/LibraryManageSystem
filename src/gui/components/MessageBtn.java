package gui.components;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import gui.shared.LayoutColors;
import gui.shared.ParentAvailable;
import gui.shared.components.CustomScrollPane;
import gui.shared.components.TopPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicPanelUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

/**
 * 消息框关闭按钮类
 * @author Jackie
 */
class MessageCloseBtn extends JButton implements ParentAvailable<MessageBox>{

    private MessageBox parent;

    /**
     * 初始化界面
     */
    public MessageCloseBtn(){
        super();
        setupUI();
        setupListener();
    }

    /**
     * 初始化界面
     * @param parent 父级对象
     */
    public MessageCloseBtn(MessageBox parent){
        this();
        setParentPanel(parent);
    }

    /**
     * 设置父级
     * @param obj 父级对象
     */
    @Override
    public void setParentPanel(MessageBox obj) {
        parent = obj;
    }

    /**
     * 获取父级
     * @return 返回父级对象
     */
    @Override
    public MessageBox getParentPanel() {
        return parent;
    }

    /**
     * 初始化监听器
     */
    private void setupListener(){
        this.addMouseListener(new MouseAdapter() {

            /**
             * 点击按钮删除消息框
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                getParentPanel().getParentPanel().deleteMessage(getParentPanel());
            }

            /**
             * 鼠标进入改变指针样式
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            /**
             * 鼠标退出恢复指针样式
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(20, 20));
        this.setText(null);
        this.setBorderPainted(false);

        UIDefaults btnDefaults = new UIDefaults();
        btnDefaults.put("Button.backgroundPainter", (Painter<JComponent>)(g2d, c, w, h) -> {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(LayoutColors.LIGHT_BLUE);
            g2d.fillRect(0, 0, 20, 20);
        });
        btnDefaults.put("Button[MouseOver].backgroundPainter", (Painter<JComponent>)(g2d, c, w, h) -> {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(Color.WHITE);
            g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2d.drawLine(6, 6, 13, 13);
            g2d.drawLine(6, 13, 13, 6);
        });
        this.putClientProperty("Nimbus.Overrides", btnDefaults);
        this.putClientProperty("Nimbus.Overrides.InheritDefaults", false);
    }

}

/**
 * 消息框内容框类
 * @author Jackie
 */
class MessageContent extends JTextArea {

    /**
     * 初始化界面
     */
    public MessageContent(String mes){
        super();
        setupUI(mes);
    }

    /**
     * 初始化界面属性
     */
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

/**
 * 消息框面板类
 * @author Jackie
 */
class MessageBox extends JPanel implements ParentAvailable<MessagePanel>{

    private MessagePanel parent;
    private MessageCloseBtn closeBtn;
    private MessageContent messageContent;

    /**
     * 获取消息关闭按钮对象
     * @return 返回消息关闭按钮对象
     */
    public MessageCloseBtn getCloseBtn() {
        return closeBtn;
    }

    /**
     * 初始化界面
     * @param mes 显示消息内容
     */
    public MessageBox(String mes){
        super();
        setupUI(mes);
    }

    /**
     * 初始化界面
     * @param mes 显示消息内容
     * @param parent 父级对象
     */
    public MessageBox(MessagePanel parent, String mes){
        this(mes);
        setParentPanel(parent);
    }

    /**
     * 设置父级
     * @param obj 父级对象
     */
    @Override
    public void setParentPanel(MessagePanel obj) {
        parent = obj;
    }

    /**
     * 获取父级
     * @return 返回父级对象
     */
    @Override
    public MessagePanel getParentPanel() {
        return parent;
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(String mes){
        this.setPreferredSize(new Dimension(250, 150));
        this.setOpaque(false);

        // 定制面板样式
        class PanelUI extends BasicPanelUI {

            /**
             * 函数说明
             * @param g 画笔对象
             * @param c 组件对象
             */
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2d = (Graphics2D)g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(LayoutColors.LIGHT_BLUE);
                g2d.fillRoundRect(0, 0, 250, 150, 15, 15);
            }
        }
        PanelUI ui = new PanelUI();
        this.setUI(ui);

        this.setLayout(new FormLayout("center:5px:noGrow,center:d:grow,center:5px:noGrow", "center:5px:noGrow,center:d:noGrow,center:10px:noGrow,center:d:noGrow,center:10px:noGrow"));
        CellConstraints cc = new CellConstraints();
        closeBtn = new MessageCloseBtn(this);
        this.add(closeBtn, cc.xy(2, 2, CellConstraints.RIGHT, CellConstraints.DEFAULT));
        messageContent = new MessageContent(mes);
        this.add(messageContent, cc.xy(2, 4, CellConstraints.CENTER, CellConstraints.DEFAULT));
    }
}

/**
 * 滚动面板内面板类
 * @author Jackie
 */
class MessagePanel extends JPanel {

    private LinkedList<MessageBox> mesList = new LinkedList<>();  // 信息列表，存放每个消息框对象
    private FormLayout formLayout;  // 信息界面布局

    /**
     * 初始化界面
     */
    public MessagePanel(){
        super();
        setupUI();
    }

    /**
     * 删除消息框并重绘
     * @param obj 消息框对象
     */
    public void deleteMessage(MessageBox obj){
        mesList.removeIf(i -> i.equals(obj));
        removeAll();  // 移除所有消息框
        displayMessage();
        repaint();  // 重绘窗口
    }

    /**
     * 追加消息框
     * @param mes 显示的消息
     */
    public void appendMessage(String mes){
        CellConstraints cc = new CellConstraints();
        MessageBox box = new MessageBox(this, mes);
        mesList.add(box);  // 加入列表
        formLayout.appendRow(RowSpec.decode("center:d:noGrow"));
        this.add(box, cc.xy(2, mesList.size()*2, CellConstraints.CENTER, CellConstraints.DEFAULT));
        formLayout.appendRow(RowSpec.decode("center:20px:noGrow"));
    }

    /**
     * 显示消息
     */
    private void displayMessage(){
        formLayout = new FormLayout("center:10px:noGrow,center:d:grow,center:10px:noGrow", "center:20px:noGrow");
        CellConstraints cc = new CellConstraints();
        for (int i = 0, j = 2; i < mesList.size(); i++, j += 2) {
            formLayout.appendRow(RowSpec.decode("center:d:noGrow"));
            this.add(mesList.get(i), cc.xy(2, j, CellConstraints.CENTER, CellConstraints.DEFAULT));
            formLayout.appendRow(RowSpec.decode("center:20px:noGrow"));
        }
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        formLayout = new FormLayout("center:10px:noGrow,center:d:grow,center:10px:noGrow", "center:20px:noGrow");
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
        this.setBorder(null);
        this.setLayout(formLayout);
        CellConstraints cc = new CellConstraints();

        // 测试消息面板
        for (int i = 0, j = 2; i < 5; i++, j += 2) {
            MessageBox b = new MessageBox(this, "消息" + i);
            mesList.add(b);  // 加入列表
            formLayout.appendRow(RowSpec.decode("center:d:noGrow"));
            this.add(b, cc.xy(2, j, CellConstraints.CENTER, CellConstraints.DEFAULT));
            formLayout.appendRow(RowSpec.decode("center:20px:noGrow"));
        }
    }
}

/**
 * 滚动面板类
 * @author Jackie
 */
class MyScrollPane extends CustomScrollPane {

    private MessagePanel messagePanel;

    /**
     * 初始化界面
     */
    public MyScrollPane(){
        super(CustomScrollPane.VERTICAL, 300, 600);
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        messagePanel = new MessagePanel();
        this.setViewportView(messagePanel);
    }

}

/**
 * 弹出窗口类
 * @author Jackie
 */
class MyPopupMenu extends JPopupMenu {

    private MyScrollPane myScrollPane;

    /**
     * 初始化界面
     */
    public MyPopupMenu(){
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setPopupSize(new Dimension(300, 600));
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        myScrollPane = new MyScrollPane();
        this.add(myScrollPane);
    }
}

/**
 * 消息按钮类
 * @author Jackie
 */
public class MessageBtn extends JButton implements ParentAvailable<TopPanel> {

    private MyPopupMenu popupMenu = new MyPopupMenu();
    private BufferedImage normalIcon;
    private BufferedImage focusIcon;
    private final int WIDTH = 30;
    private final int HEIGHT = 30;
    private TopPanel parent;

    /**
     * 初始化按钮
     */
    public MessageBtn(){
        super();
        setupIcon();
        setupUI();
        setupListener();
    }

    private void setupIcon(){
        try {
            normalIcon = ImageIO.read(new File("icons/MessageBtnNormal.png"));
            focusIcon = ImageIO.read(new File("icons/MessageBtnFocus.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置父级
     * @param obj 父级对象
     */
    @Override
    public void setParentPanel(TopPanel obj) {
        parent = obj;
    }

    /**
     * 获取父级
     * @return 返回父级对象
     */
    @Override
    public TopPanel getParentPanel() {
        return parent;
    }

    /**
     * 初始化监听器
     */
    private void setupListener(){
        this.addMouseListener(new MouseAdapter() {

            /**
             * 设置鼠标进入事件
             * @param e 鼠标事件
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            /**
             * 设置鼠标退出事件
             * @param e 鼠标事件
             */
            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }

            /**
             * 设置鼠标点击事件
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                Point p = getParentPanel().getLocationOnScreen();
                popupMenu.setInvoker(e.getComponent());
                popupMenu.setLocation(p.x + 600, p.y + 75);
                popupMenu.setVisible(true);
            }
        });
    }

    /**
     * 初始化按钮属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setText(null);
        this.setBorderPainted(false);

        UIDefaults btnDefaults = new UIDefaults();
        btnDefaults.put("Button.backgroundPainter", (Painter<JComponent>)(g2d, c, w, h) -> {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.drawImage(normalIcon, 0, 0, null);
        });
        btnDefaults.put("Button[MouseOver].backgroundPainter", (Painter<JComponent>)(g2d, c, w, h) -> {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.drawImage(focusIcon, 0, 0, null);
        });
        this.putClientProperty("Nimbus.Overrides", btnDefaults);
        this.putClientProperty("Nimbus.Overrides.InheritDefaults", false);

    }
}
