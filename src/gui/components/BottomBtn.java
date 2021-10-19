package gui.components;

import gui.shared.LayoutColors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 底部面板按钮类
 * @author Jackie
 */
public class BottomBtn extends JButton {

    /**
     * 初始化界面
     */
    public BottomBtn(){
        super();
        setupUI();
        setupListener();
    }

    /**
     * 初始化界面
     * @param label 要在按钮上显示的文字
     */
    public BottomBtn(String label){
        super(label);
        setupUI();
    }

    /**
     * 初始化监听器
     */
    private void setupListener(){
        this.addMouseListener(new MouseAdapter() {

            /**
             * 鼠标点击执行搜索操作
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

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
     * 初始化属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(150, 200));
        this.setFont(new Font("微软雅黑", Font.BOLD, 14));

        UIDefaults btnDefaults = new UIDefaults();
        btnDefaults.put("Button.backgroundPainter", (Painter<JComponent>)(g2d, c, w, h) -> {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(LayoutColors.BLUE);
            g2d.fillRoundRect(0, 0, 150, 200, 20, 20);
        });
        this.putClientProperty("Nimbus.Overrides", btnDefaults);
        this.putClientProperty("Nimbus.Overrides.InheritDefaults", false);

    }

}
