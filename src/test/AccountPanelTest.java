package test;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AccountPanelTest {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 400, 300);

        // 定制用户头像
        class AccountPic extends JLabel {

            private BufferedImage userPic;

            public AccountPic(String path){
                super();
                setupIcon(path);
                setupUI();
            }

            public void setUserPic(String path) {
                setupIcon(path);
            }

            @Override
            public void paint(Graphics g) {
                Graphics2D g2d = (Graphics2D)g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g2d.drawImage(userPic, 0, 0, null);
            }

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

            private void setupUI(){
                this.setPreferredSize(new Dimension(50, 50));
            }

        }

        // 定制账号操作按钮
        class AccountOpBtn extends JButton {

            public AccountOpBtn(String userName){
                super();
                setupUI();
                setupText(userName);
            }

            private void setupText(String userName){
                String dstText = userName;
                if (userName.length() >= 10) {
                    dstText = userName.substring(0, 9) + "...";
                }
                this.setText(dstText);
            }

            private void setupUI(){
                this.setPreferredSize(new Dimension(150, 50));
                this.setFont(new Font("微软雅黑", Font.PLAIN, 14));
                this.setBorderPainted(false);
                this.setContentAreaFilled(false);
                this.setHorizontalTextPosition(SwingConstants.LEFT);
                this.setHorizontalAlignment(SwingConstants.LEFT);
                this.setFocusPainted(false);
                this.setOpaque(true);

//                UIDefaults btnDefaults = new UIDefaults();
//                btnDefaults.put("Button[Enabled].backgroundPainter", (Painter<JComponent>)(g2d, c, width, height) -> {
//                    g2d.setColor(Color.BLUE);
//                    g2d.fillRect(0, 0, 10, 10);
//                });
//
//                this.putClientProperty("Nimbus.Overrides", btnDefaults);
//                this.putClientProperty("Nimbus.Overrides.InheritDefaults", false);

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

            private void setupUI(){

//                for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
//                    if ("Nimbus".equals(laf.getName())) {
//                        try {
//                            UIManager.setLookAndFeel(laf.getClassName());
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }

                CellConstraints cc = new CellConstraints();
                this.setLayout(new FormLayout("center:d:noGrow,center:d:noGrow", "center:d:noGrow"));
                this.setPreferredSize(new Dimension(200, 50));
                accountPic = new AccountPic("pics/user.jpg");
                this.add(accountPic, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
                accountOpBtn = new AccountOpBtn("测试");
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
