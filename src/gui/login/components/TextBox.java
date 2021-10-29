package gui.login.components;

import gui.shared.LayoutColors;

import javax.swing.*;
import java.awt.*;

public class TextBox extends JTextField {

    private final int WIDTH = 250;
    private final int HEIGHT = 30;
    private String tipText = null;

    public TextBox(String tipText){
        super();
        this.tipText = tipText;
        setupUI();
    }

    public boolean hasTipText(){
        return tipText != null;
    }

    private void setupUI(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        this.setForeground(LayoutColors.GRAY);

        UIDefaults textBoxDefaults = new UIDefaults();
        textBoxDefaults.put("TextField.contentMargins", new Insets(6, 10, 6, 10));
        textBoxDefaults.put("TextField.backgroundPainter", (Painter<JComponent>) (g2d, c, w, h) -> {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(LayoutColors.LIGHTEST_GRAY);
            g2d.fillRoundRect(0, 0, w, h, 10, 10);
            if (hasTipText()) {
                g2d.drawString(tipText, 0, 0);
            }
        });
        textBoxDefaults.put("TextField[Focused].backgroundPainter", (Painter<JComponent>) (g2d, c, w, h) -> {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(LayoutColors.LIGHTEST_GRAY);
            g2d.fillRoundRect(0, 0, w, h, 10, 10);
        });
        this.putClientProperty("Nimbus.Overrides", textBoxDefaults);
        this.putClientProperty("Nimbus.Overrides.InheritDefaults", false);
    }

}
