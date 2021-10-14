package test;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.shared.LayoutColors;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PasswordFieldTest {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBackground(Color.WHITE);

        // 定制密码输入框
        class PasswordBox extends JPasswordField {

            public PasswordBox(){
                super();
                setupUI();
            }

            private void setupUI(){
                this.setPreferredSize(new Dimension(220, 30));
                this.setOpaque(true);

                UIDefaults boxDefaults = new UIDefaults();
                boxDefaults.put("PasswordField.backgroundPainter", (Painter<JComponent>)(g2d, c, w, h) -> {
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2d.setColor(LayoutColors.LIGHT_BLUE);
                    g2d.fillRoundRect(0, 0, w, h, 10, 10);
                    g2d.fillRect(w - 10, 0, 10, 30);
                });
                this.putClientProperty("Nimbus.Overrides", boxDefaults);
                this.putClientProperty("Nimbus.Overrides.InheritDefaults", false);

            }

        }

        // 定制密码可见按钮
        class PasswordBtn extends JButton {

            public PasswordBtn(){
                super();
                setupUI();
            }

            private void setupUI(){
                this.setPreferredSize(new Dimension(30, 30));
                this.setText(null);
                this.setBorderPainted(false);
                this.setOpaque(true);

                try {
                    BufferedImage visibleNormalIcon = ImageIO.read(new File("icons/PasswordSeenNormal.png"));
                    BufferedImage visibleFocusIcon = ImageIO.read(new File("icons/PasswordSeenFocus.png"));
                    BufferedImage invisibleNormalIcon = ImageIO.read(new File("icons/PasswordUnseenNormal.png"));
                    BufferedImage invisibleFocusIcon = ImageIO.read(new File("icons/PasswordUnseenFocus.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
                UIDefaults btnDefaults = new UIDefaults();
                btnDefaults.put("Button.backgroundPainter", (Painter<JComponent>)(g2d, c, w, h) -> {
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2d.setColor(LayoutColors.LIGHT_BLUE);
                    g2d.fillRoundRect(0, 0, w, h, 10, 10);
                    g2d.fillRect(0, 0, 10, 30);

                });
                this.putClientProperty("Nimbus.Overrides", btnDefaults);
                this.putClientProperty("Nimbus.Overrides.InheritDefaults", false);
            }

        }

        // 定制输入区域
        class SignUpPasswordPanel extends JPanel{

            private PasswordBox passwordBox;
            private PasswordBtn passwordBtn;

            public SignUpPasswordPanel(){
                this.setPreferredSize(new Dimension(250, 30));
                this.setLayout(new FormLayout("center:d:noGrow,center:d:noGrow", "center:d:noGrow"));
                CellConstraints cc = new CellConstraints();
                passwordBox = new PasswordBox();
                this.add(passwordBox, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
                passwordBtn = new PasswordBtn();
                this.add(passwordBtn, cc.xy(2, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
            }

        }

        for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(laf.getName())) {
                try {
                    UIManager.setLookAndFeel(laf.getClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        JPanel panel = new JPanel();
        SignUpPasswordPanel signUpPasswordPanel = new SignUpPasswordPanel();
        panel.add(signUpPasswordPanel);
        frame.add(panel);
        frame.setVisible(true);

    }

}
