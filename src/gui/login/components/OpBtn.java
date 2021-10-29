package gui.login.components;

import gui.shared.LayoutColors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OpBtn extends JButton {

    private final int WIDTH = 100;
    private final int HEIGHT = 40;

    public OpBtn(String text){
        super(text);
        setupUI();
        setupListener();
    }

    private void setupListener(){
        this.addMouseListener(new MouseAdapter() {

            /**
             * 鼠标进入改变指针样式
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            /**
             * 鼠标退出改变指针样式
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });
    }

    private void setupUI(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        this.setForeground(Color.WHITE);
        this.setBorderPainted(false);

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
