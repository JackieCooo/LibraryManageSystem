package test;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.shared.LayoutColors;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AccountPanelTest {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 400, 300);

        // 定制弹出菜单
        class AccountOpPopupMenu extends JPopupMenu{

            private JMenuItem checkoutBtn;

            /**
             * 初始化界面
             */
            public AccountOpPopupMenu(){
                super();
                setupUI();
            }

            /**
             * 初始化界面属性
             */
            private void setupUI(){
                this.setPreferredSize(new Dimension(100, 40));
                this.setOpaque(true);
                this.setBorderPainted(false);
                this.setBackground(Color.WHITE);
                checkoutBtn = new JMenuItem("登出");
                checkoutBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
                checkoutBtn.setHorizontalAlignment(SwingConstants.CENTER);
                checkoutBtn.setHorizontalTextPosition(SwingConstants.CENTER);
                checkoutBtn.addMouseListener(new MouseAdapter() {

                    /**
                     * 设置鼠标点击后退回登录界面
                     * @param e 鼠标事件对象
                     */
                    @Override
                    public void mouseClicked(MouseEvent e) {

                    }

                    /**
                     * 设置鼠标悬停指针样式
                     * @param e 鼠标事件对象
                     */
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    }

                    /**
                     * 设置鼠标非悬停指针样式
                     * @param e 鼠标事件对象
                     */
                    @Override
                    public void mouseExited(MouseEvent e) {
                        setCursor(Cursor.getDefaultCursor());
                    }

                });
                this.add(checkoutBtn);
            }

        }

        // 定制用户头像
        class AccountPic extends JLabel {

            private BufferedImage userPic;

            /**
             * 初始化界面
             */
            public AccountPic(String path){
                super();
                setupIcon(path);
                setupUI();
            }

            /**
             * 设置头像
             * @param path 图片路径
             */
            public void setUserPic(String path) {
                setupIcon(path);
            }

            /**
             * 绘制头像
             * @param g 画笔对象
             */
            @Override
            public void paint(Graphics g) {
                Graphics2D g2d = (Graphics2D)g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g2d.drawImage(userPic, 0, 0, null);
            }

            /**
             * 初始化头像
             * @param path 图片
             */
            private void setupIcon(String path){
                try {
                    BufferedImage srcImage = ImageIO.read(new File(path));
                    BufferedImage dstImage = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
                    Graphics2D gs = dstImage.createGraphics();
                    gs.setComposite(AlphaComposite.Src);
                    gs.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    gs.setColor(Color.WHITE);
                    gs.fillOval(0, 0, 50, 50);
                    gs.setComposite(AlphaComposite.SrcAtop);
                    gs.drawImage(srcImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH), 0, 0, null);
                    gs.dispose();
                    userPic = dstImage;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            /**
             * 初始化界面
             */
            private void setupUI(){
                this.setPreferredSize(new Dimension(50, 50));
            }

        }

        // 定制账号操作按钮
        class AccountOpBtn extends JButton {

            private AccountOpPopupMenu popupMenu = new AccountOpPopupMenu();

            /**
             * 初始化界面
             */
            public AccountOpBtn(String userName){
                super();
                setupUI();
                setupText(userName);
                setupListener();
            }

            /**
             * 初始化监听器
             */
            private void setupListener(){
                this.addMouseListener(new MouseAdapter() {

                    /**
                     * 设置鼠标点击弹出菜单
                     * @param e 鼠标事件对象
                     */
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        popupMenu.setInvoker(e.getComponent());
                        popupMenu.setLocation(e.getX(), e.getY());
                        popupMenu.setVisible(true);
                    }

                    /**
                     * 设置鼠标悬停指针样式
                     * @param e 鼠标事件对象
                     */
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        setForeground(LayoutColors.LIGHT_GRAY);
                    }

                    /**
                     * 设置鼠标非悬停指针样式
                     * @param e 鼠标事件对象
                     */
                    @Override
                    public void mouseExited(MouseEvent e) {
                        setCursor(Cursor.getDefaultCursor());
                        setForeground(Color.WHITE);
                    }
                });
            }

            /**
             * 初始化显示用户名
             * @param userName 用户名
             */
            private void setupText(String userName){
                String dstText = userName;
                // 用户名长于9位，后面加省略号
                if (userName.length() >= 9) {
                    dstText = userName.substring(0, 8) + "...";
                }
                this.setText(dstText);
            }

            /**
             * 初始化界面
             */
            private void setupUI(){
                this.setPreferredSize(new Dimension(150, 50));
                this.setFont(new Font("微软雅黑", Font.PLAIN, 14));
                this.setForeground(Color.WHITE);
                this.setBorderPainted(false);
                this.setHorizontalTextPosition(SwingConstants.LEFT);
                this.setHorizontalAlignment(SwingConstants.LEFT);
                this.setFocusPainted(false);
                this.setComponentPopupMenu(popupMenu);

                UIDefaults btnDefaults = new UIDefaults();
                btnDefaults.put("Button.backgroundPainter", (Painter<JComponent>)(g2d, c, width, height) -> {

                });

                this.putClientProperty("Nimbus.Overrides", btnDefaults);
                this.putClientProperty("Nimbus.Overrides.InheritDefaults", false);

            }

        }

        // 定制账号信息板块
        class AccountPanel extends JPanel{

            private AccountPic accountPic;
            private AccountOpBtn accountOpBtn;

            /**
             * 初始化界面
             */
            public AccountPanel(){
                super();
                setupUI();
            }

            /**
             * 初始化界面属性
             */
            private void setupUI(){

                for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(laf.getName())) {
                        try {
                            UIManager.setLookAndFeel(laf.getClassName());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                CellConstraints cc = new CellConstraints();
                this.setLayout(new FormLayout("center:d:noGrow,center:d:noGrow", "center:d:noGrow"));
                this.setPreferredSize(new Dimension(200, 50));
                accountPic = new AccountPic("pics/user.jpg");
                this.add(accountPic, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
                accountOpBtn = new AccountOpBtn("马浩同学");
                this.add(accountOpBtn, cc.xy(2, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
            }

        }

        AccountPanel accountPanel = new AccountPanel();
        JPanel panel = new JPanel();
        panel.add(accountPanel);
        frame.add(panel);

        frame.setVisible(true);
    }

}
