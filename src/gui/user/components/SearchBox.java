package gui.user.components;

import gui.shared.LayoutColors;

import javax.swing.*;
import java.awt.*;

/**
 * 搜索框类
 * @author Jackie
 */
public class SearchBox extends JTextField {

    /**
     * 初始化界面
     */
    public SearchBox(){
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(400, 40));
        this.setFont(new Font("微软雅黑", Font.PLAIN, 14));

        UIDefaults searchBoxDefaults = new UIDefaults();
        searchBoxDefaults.put("TextField.contentMargins", new Insets(6, 10, 6, 10));
        searchBoxDefaults.put("TextField.backgroundPainter", (Painter<JComponent>) (g2d, c, width, height) -> {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(LayoutColors.LIGHT_BLUE);
            g2d.fillRoundRect(0, 0, width, height, 20, 20);
            g2d.fillRect(width-10, 0, width, height);
        });
        this.putClientProperty("Nimbus.Overrides", searchBoxDefaults);
        this.putClientProperty("Nimbus.Overrides.InheritDefaults", false);
    }

}
