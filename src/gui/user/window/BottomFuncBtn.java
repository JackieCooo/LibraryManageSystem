package gui.user.window;

import javax.swing.*;
import java.awt.*;

/**
 * 自定义功能按钮类
 * @author Jackie
 */
public class BottomFuncBtn extends JButton {

    /**
     * 初始化界面
     */
    public BottomFuncBtn(){
        super();
        setupUI();
    }

    /**
     * 初始化界面
     * @param label 要在按钮上显示的文字
     */
    public BottomFuncBtn(String label){
        super(label);
        setupUI();
    }

    /**
     * 初始化属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(150, 200));
    }

}
