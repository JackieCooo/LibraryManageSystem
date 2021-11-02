package gui.shared.components;

import javax.swing.*;
import java.awt.*;

/**
 * 自定义最小化按钮类
 * @author Jackie
 */
public class CustomizedMinimizedBtn extends JButton {

    private final int WIDTH = 20;
    private final int HEIGHT = 20;

    /**
     * 初始化按钮
     */
    public CustomizedMinimizedBtn() {
        super();
        setupUI();
        setupListener();
    }

    /**
     * 初始化监听器
     */
    public void setupListener(){
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
            g2d.setColor(new Color(70, 203, 177));
            g2d.fillOval(0, 0, WIDTH, HEIGHT);
        });
        btnDefaults.put("Button[MouseOver].backgroundPainter", (Painter<JComponent>)(g2d, c, w, h) -> {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(new Color(70, 203, 177));
            g2d.fillOval(0, 0, WIDTH, HEIGHT);
            g2d.setColor(Color.WHITE);
            g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2d.drawLine(6, 10, 14, 10);
        });
        this.putClientProperty("Nimbus.Overrides", btnDefaults);
        this.putClientProperty("Nimbus.Overrides.InheritDefaults", false);
    }

}
