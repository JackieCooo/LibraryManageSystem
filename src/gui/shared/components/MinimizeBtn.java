package gui.shared.components;

import gui.shared.ParentAvailable;
import gui.shared.panels.TopPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 最小化按钮类
 * @author Jackie
 */
public class MinimizeBtn extends JButton implements ParentAvailable<TopPanel> {

    private TopPanel parent;
    private final int WIDTH = 20;
    private final int HEIGHT = 20;

    /**
     * 初始化按钮
     */
    public MinimizeBtn() {
        super();
        setupUI();
        setupListener();
    }

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
                getParentPanel().getParentPanel().setState(Frame.ICONIFIED);
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

    /**
     * 设置父级
     * @param obj 父级对象
     */
    @Override
    public void setParentPanel(TopPanel obj) {
        this.parent = obj;
    }

    /**
     * 获取父级
     * @return 返回父级对象
     */
    @Override
    public TopPanel getParentPanel() {
        return this.parent;
    }
}
