package gui.login.components;

import javax.swing.*;
import java.awt.*;

/**
 * 底部按钮类
 * @author Jackie
 */
public class BottomBtn extends JLabel {

    private int WIDTH = 0;
    private int HEIGHT = 0;

    /**
     * 初始化界面
     * @param text 显示文本
     * @param width 宽度
     * @param height 高度
     */
    public BottomBtn(String text, int width, int height){
        super(text);
        WIDTH = width;
        HEIGHT = height;
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setFont(new Font("微软雅黑", Font.BOLD, 18));
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
    }

}
