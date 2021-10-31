package gui.admin.components;

import gui.admin.panels.LeftSidePanel;
import gui.shared.LayoutColors;
import gui.shared.ParentAvailable;

import javax.swing.*;
import java.awt.*;

/**
 * 左侧按钮类
 * @author Jackie
 */
public class LeftSideBtn extends JButton implements ParentAvailable<LeftSidePanel> {

    private LeftSidePanel parent;
    private boolean isSet = false;

    /**
     * 初始化界面
     */
    public LeftSideBtn(String label){
        super(label);
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(150, 40));
        this.setForeground(Color.WHITE);
        this.setFont(new Font("微软雅黑", Font.BOLD, 14));

        UIDefaults btnDefaults = new UIDefaults();
        btnDefaults.put("Button.backgroundPainter", (Painter<JComponent>)(g2d, c, w, h) -> {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (isSet){
                g2d.setColor(LayoutColors.DARKEST_BLUE);
            }
            else {
                g2d.setColor(LayoutColors.DARK_BLUE);
            }
            g2d.fillRoundRect(0, 0, w, h, 10, 10);
        });
        btnDefaults.put("Button[MouseOver].backgroundPainter", (Painter<JComponent>)(g2d, c, w, h) -> {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(LayoutColors.DARKEST_BLUE);
            g2d.fillRoundRect(0, 0, w, h, 10, 10);
        });
        this.putClientProperty("Nimbus.Overrides", btnDefaults);
        this.putClientProperty("Nimbus.Overrides.InheritDefaults", false);
    }

    /**
     * 设置父级
     * @param obj 父级对象
     */
    @Override
    public void setParentPanel(LeftSidePanel obj) {
        parent = obj;
    }

    /**
     * 获取父级
     * @return 返回父级对象
     */
    @Override
    public LeftSidePanel getParentPanel() {
        return parent;
    }
}
