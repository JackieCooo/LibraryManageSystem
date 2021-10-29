package gui.login.components;

import gui.shared.LayoutColors;

import javax.swing.*;
import java.awt.*;

public class PasswordBox extends JPasswordField {

    private final int WIDTH = 250;
    private final int HEIGHT = 30;

    public PasswordBox(){
        super();
        setupUI();
    }

    private void setupUI(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        UIDefaults passwordBoxDefaults = new UIDefaults();
        passwordBoxDefaults.put("PasswordField.contentMargins", new Insets(6, 10, 6, 10));
        passwordBoxDefaults.put("PasswordField.backgroundPainter", (Painter<JComponent>) (g2d, c, w, h) -> {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(LayoutColors.LIGHTEST_GRAY);
            g2d.fillRoundRect(0, 0, w, h, 20, 20);
        });
        this.putClientProperty("Nimbus.Overrides", passwordBoxDefaults);
        this.putClientProperty("Nimbus.Overrides.InheritDefaults", false);

    }

}
