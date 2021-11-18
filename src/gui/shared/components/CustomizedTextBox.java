package gui.shared.components;

import gui.shared.LayoutColors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * 文本输入框类
 * @author Jackie
 */
public class CustomizedTextBox extends JTextField {

    private int WIDTH = 250;
    private int HEIGHT = 30;
    private String tipText = null;

    /**
     * 初始化界面
     * @param tipText 提示文本
     */
    public CustomizedTextBox(String tipText){
        super();
        this.tipText = tipText;
        setupUI();
    }

    /**
     * 初始化界面
     * @param width 宽
     * @param height 高
     */
    public CustomizedTextBox(int width, int height){
        super();
        this.tipText = null;
        this.WIDTH = width;
        this.HEIGHT = height;
        setupUI();
    }

    /**
     * 是否有提示文本
     * @return true 有提示文本
     *         false 无提示文本
     */
    public boolean hasTipText(){
        return tipText != null;
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        if (hasTipText()) {
            this.setForeground(LayoutColors.GRAY);
            this.setText(tipText);
            this.addFocusListener(new FocusListener() {

                /**
                 * 聚焦时清除提示文本
                 * @param e 聚焦事件对象
                 */
                @Override
                public void focusGained(FocusEvent e) {
                    if (getText().equals(tipText)) {
                        setText(null);
                        setForeground(Color.BLACK);
                    }
                }

                /**
                 * 失焦时设置提示文本
                 * @param e 聚焦事件对象
                 */
                @Override
                public void focusLost(FocusEvent e) {
                    if (getText().equals("")) {
                        setForeground(LayoutColors.GRAY);
                        setText(tipText);
                    }
                }
            });
        }

        UIDefaults textBoxDefaults = new UIDefaults();
        textBoxDefaults.put("TextField.contentMargins", new Insets(6, 10, 6, 10));
        textBoxDefaults.put("TextField.backgroundPainter", (Painter<JComponent>) (g2d, c, w, h) -> {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(LayoutColors.LIGHTEST_GRAY);
            g2d.fillRoundRect(0, 0, w, h, 10, 10);
        });
        this.putClientProperty("Nimbus.Overrides", textBoxDefaults);
        this.putClientProperty("Nimbus.Overrides.InheritDefaults", false);
    }

}
