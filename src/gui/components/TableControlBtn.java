package gui.components;

import javax.swing.*;
import java.awt.*;

public class TableControlBtn extends JButton {


    private boolean hasBeenSet = false;  // 按钮是否被按下
    private ImageIcon setIcon;
    private ImageIcon unsetIcon;

    /**
     * 初始化按钮
     * @param unsetIconUrl 未被按下按钮的图标路径
     * @param setIconUrl 被按下按钮的图标路径
     */
    public TableControlBtn(String unsetIconUrl, String setIconUrl){
        super();
        setupIcons(unsetIconUrl, setIconUrl);
        setupUI();
    }

    /**
     * 初始化图标
     */
    private void setupIcons(String unsetIconUrl, String setIconUrl){
        if (setIconUrl != null) this.setIcon = new ImageIcon(setIconUrl);
        if (unsetIconUrl != null) this.unsetIcon = new ImageIcon(unsetIconUrl);
    }

    /**
     * 重绘按钮
     */
    @Override
    public void repaint() {
        if (hasBeenSet) {
            this.setIcon(setIcon);
        }
        else{
            this.setIcon(unsetIcon);
        }
    }

    /**
     * 初始化按钮属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(30, 30));
        this.setText(null);
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);

        if (hasBeenSet) {
            this.setIcon(setIcon);
        }
        else{
            this.setIcon(unsetIcon);
        }
    }

    /**
     * 获取按钮状态
     * @return true 被按下
     *         false 未被按下
     */
    public boolean isHasBeenSet() {
        return hasBeenSet;
    }

    /**
     * 反转按钮状态并重绘
     */
    public void toggleStatus() {
        this.hasBeenSet = !this.hasBeenSet;
        repaint();
    }
}
