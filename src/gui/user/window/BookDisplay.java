package gui.user.window;

import javax.swing.*;
import java.awt.*;

/**
 * 书本展示框类
 * @author Jackie
 */
public class BookDisplay extends JButton {

    /**
     * 初始化界面
     */
    public BookDisplay(){
        super();
        setupUI();
    }

    /**
     * 初始化界面并设置标签（用于测试）
     * @param label 要在框上显示的文字
     */
    public BookDisplay(String label){
        super(label);
        setupUI();
    }

    /**
     * 设置部件的属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(150, 200));
    }

}
