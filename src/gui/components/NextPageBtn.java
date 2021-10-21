package gui.components;

import gui.shared.GlobalConstants;
import gui.shared.LayoutColors;
import gui.shared.ParentAvailable;
import gui.shared.components.TopPanel;
import gui.user.window.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 下一页按钮类
 * @author Jackie
 */
public class NextPageBtn extends JButton implements ParentAvailable<TopPanel> {

    private TopPanel parent;
    private final int WIDTH = 30;
    private final int HEIGHT = 30;

    /**
     * 设置父级
     * @param obj 父级对象
     */
    @Override
    public void setParentPanel(TopPanel obj) {
        parent = obj;
    }

    /**
     * 获取父级
     * @return 返回父级对象
     */
    @Override
    public TopPanel getParentPanel() {
        return parent;
    }

    /**
     * 初始化按钮
     */
    public NextPageBtn() {
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
             * 设置鼠标点击后的图标
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!GlobalConstants.nexPage.empty()) {
                    MainPanel p = getParentPanel().getParentPanel().getMainWindow();
                    p.getComponent(GlobalConstants.curPage).setVisible(false);
                    p.getComponent(GlobalConstants.nexPage.peek()).setVisible(true);
                    GlobalConstants.prePage.push(GlobalConstants.curPage);
                    GlobalConstants.curPage = GlobalConstants.nexPage.peek();
                    GlobalConstants.nexPage.pop();
                    if (GlobalConstants.nexPage.empty()) {
                        setEnabled(false);
                    }
                }
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
        this.setEnabled(false);

        UIDefaults btnDefaults = new UIDefaults();
        btnDefaults.put("Button.backgroundPainter", (Painter<JComponent>)(g2d, c, w, h) -> {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(LayoutColors.DARKEST_BLUE);
            g2d.fillOval(0, 0, WIDTH, HEIGHT);
            g2d.setColor(Color.WHITE);
            g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2d.drawLine(12, 8, 19, 15);
            g2d.drawLine(12, 22, 19, 15);
        });
        btnDefaults.put("Button[Disabled].backgroundPainter", (Painter<JComponent>)(g2d, c, w, h) -> {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(LayoutColors.DARKEST_BLUE);
            g2d.fillOval(0, 0, WIDTH, HEIGHT);
            g2d.setColor(LayoutColors.LIGHT_GRAY);
            g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2d.drawLine(12, 8, 19, 15);
            g2d.drawLine(12, 22, 19, 15);
        });
        this.putClientProperty("Nimbus.Overrides", btnDefaults);
        this.putClientProperty("Nimbus.Overrides.InheritDefaults", false);
    }

}
