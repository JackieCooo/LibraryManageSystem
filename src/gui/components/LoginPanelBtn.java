package gui.components;

import gui.shared.LayoutColors;

import javax.swing.*;
import java.awt.*;

public class LoginPanelBtn extends JButton {

    private int WIDTH = 0;
    private int HEIGHT = 0;

    public LoginPanelBtn(){
        this(100, 40, "button");
    }

    public LoginPanelBtn(int width, int height, String text){
        super(text);
        setupUI(width, height);
    }

    private void setupUI(int width, int height){
        WIDTH = width;
        HEIGHT = height;
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        this.setForeground(Color.WHITE);

        UIDefaults btnDefaults = new UIDefaults();
        btnDefaults.put("Button.backgroundPainter", (Painter<JComponent>)(g2d, c, w, h) -> {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(LayoutColors.DARK_BLUE);
            g2d.fillRoundRect(0, 0, w, h, 10, 10);
        });
        this.putClientProperty("Nimbus.Overrides", btnDefaults);
        this.putClientProperty("Nimbus.Overrides.InheritDefaults", false);
    }

}
