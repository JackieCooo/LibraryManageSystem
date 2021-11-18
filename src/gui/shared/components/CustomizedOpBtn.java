package gui.login.components;

import gui.shared.LayoutColors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 操作按钮类
 * @author Jackie
 */
public class OpBtn extends JButton {

    private int WIDTH = 0;
    private int HEIGHT = 0;

    /**
     * 初始化界面
     * @param text 显示文本
     * @param width 宽度
     * @param height 高度
     */
    public OpBtn(String text, int width, int height){
        super(text);
        WIDTH = width;
        HEIGHT = height;
        setupUI();
        setupListener();
    }

    /**
     * 初始化监听器
     */
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

    /**
     * 初始化界面属性
     */
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
