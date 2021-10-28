package gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 关闭按钮类
 * @author Jackie
 */
public class CloseBtn extends JButton {

    private final int WIDTH = 20;
    private final int HEIGHT = 20;

    /**
     * 初始化按钮
     */
    public CloseBtn() {
        super();
        setupUI();
        setupListener();
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
                System.exit(0);
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
            g2d.setColor(new Color(254, 140, 130));
            g2d.fillOval(0, 0, WIDTH, HEIGHT);
        });
        btnDefaults.put("Button[MouseOver].backgroundPainter", (Painter<JComponent>)(g2d, c, w, h) -> {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(new Color(254, 140, 130));
            g2d.fillOval(0, 0, WIDTH, HEIGHT);
            g2d.setColor(Color.WHITE);
            g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2d.drawLine(6, 6, 13, 13);
            g2d.drawLine(6, 13, 13, 6);
        });
        this.putClientProperty("Nimbus.Overrides", btnDefaults);
        this.putClientProperty("Nimbus.Overrides.InheritDefaults", false);
    }
}
