package gui.login.panels;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.shared.LayoutColors;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 密码框类
 * @author Jackie
 */
class PasswordBox extends JPasswordField {

    private String tipText = null;

    /**
     * 初始化界面
     */
    public PasswordBox(String tipText) {
        super();
        this.tipText = tipText;
        setupUI();
    }

    public boolean hasTipText(){
        return tipText != null;
    }

    /**
     * 初始化界面属性
     */
    private void setupUI() {
        this.setPreferredSize(new Dimension(220, 30));
        this.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        this.setOpaque(false);

        if (hasTipText()) {
            this.setForeground(LayoutColors.GRAY);
            this.setText(tipText);
            this.setEchoChar('\0');
            this.addFocusListener(new FocusListener() {

                @Override
                public void focusGained(FocusEvent e) {
                    String tmp = new String(getPassword());
                    if (tmp.equals(tipText)) {
                        setText(null);
                        setEchoChar('·');
                        setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    String tmp = new String(getPassword());
                    if (tmp.equals("")) {
                        setEchoChar('\0');
                        setForeground(LayoutColors.GRAY);
                        setText(tipText);
                    }
                }
            });
        }

        UIDefaults boxDefaults = new UIDefaults();
        boxDefaults.put("PasswordField.backgroundPainter", (Painter<JComponent>) (g2d, c, w, h) -> {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(LayoutColors.LIGHTEST_GRAY);
            g2d.fillRoundRect(0, 0, w, h, 10, 10);
            g2d.fillRect(w - 10, 0, 10, 30);
        });
        boxDefaults.put("PasswordField.contentMargins", new Insets(6, 10, 6, 10));
        this.putClientProperty("Nimbus.Overrides", boxDefaults);
        this.putClientProperty("Nimbus.Overrides.InheritDefaults", false);

    }

}

/**
 * 密码可见按钮类
 * @author Jackie
 */
class PasswordBtn extends JButton {

    private BufferedImage visibleFocusIcon;
    private BufferedImage invisibleNormalIcon;
    private BufferedImage invisibleFocusIcon;
    private PasswordBox invoker;

    /**
     * 初始化界面
     */
    public PasswordBtn(PasswordBox invoker) {
        super();
        this.invoker = invoker;
        setupUI();
        setupListener();
    }

    /**
     * 初始化监听器
     */
    private void setupListener() {
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                invoker.setEchoChar('\0');
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                invoker.setEchoChar('·');
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });
    }

    /**
     * 初始化界面
     */
    private void setupUI() {
        this.setPreferredSize(new Dimension(30, 30));
        this.setText(null);
        this.setBorderPainted(false);
        this.setOpaque(false);

        try {
            visibleFocusIcon = ImageIO.read(new File("icons/PasswordSeenFocus.png"));
            invisibleNormalIcon = ImageIO.read(new File("icons/PasswordUnseenNormal.png"));
            invisibleFocusIcon = ImageIO.read(new File("icons/PasswordUnseenFocus.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        UIDefaults btnDefaults = new UIDefaults();
        btnDefaults.put("Button.backgroundPainter", (Painter<JComponent>) (g2d, c, w, h) -> {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setColor(LayoutColors.LIGHTEST_GRAY);
            g2d.fillRoundRect(0, 0, w, h, 10, 10);
            g2d.fillRect(0, 0, 10, 30);
            g2d.drawImage(invisibleNormalIcon, 0, 5, null);
        });
        btnDefaults.put("Button[MouseOver].backgroundPainter", (Painter<JComponent>) (g2d, c, w, h) -> {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setColor(LayoutColors.LIGHTEST_GRAY);
            g2d.fillRoundRect(0, 0, w, h, 10, 10);
            g2d.fillRect(0, 0, 10, 30);
            g2d.drawImage(invisibleFocusIcon, 0, 5, null);
        });
        btnDefaults.put("Button[Pressed].backgroundPainter", (Painter<JComponent>) (g2d, c, w, h) -> {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setColor(LayoutColors.LIGHTEST_GRAY);
            g2d.fillRoundRect(0, 0, w, h, 10, 10);
            g2d.fillRect(0, 0, 10, 30);
            g2d.drawImage(visibleFocusIcon, 0, 5, null);
        });
        this.putClientProperty("Nimbus.Overrides", btnDefaults);
        this.putClientProperty("Nimbus.Overrides.InheritDefaults", false);
    }

}

/**
 * 密码输入面板类
 * @author Jackie
 */
public class PasswordPanel extends JPanel {


    private PasswordBox passwordBox;
    private PasswordBtn passwordBtn;

    /**
     * 初始化界面
     */
    public PasswordPanel() {
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI() {
        this.setPreferredSize(new Dimension(250, 30));
        this.setLayout(new FormLayout("center:d:noGrow,center:d:noGrow", "center:d:noGrow"));
        this.setOpaque(false);
        CellConstraints cc = new CellConstraints();

        passwordBox = new PasswordBox("密码");
        this.add(passwordBox, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));

        passwordBtn = new PasswordBtn(passwordBox);
        this.add(passwordBtn, cc.xy(2, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
    }
}
