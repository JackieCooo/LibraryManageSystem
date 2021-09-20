package gui.user.window;

import javax.swing.*;
import java.awt.*;

/**
 * 顶部功能按钮类
 * @author Jackie
 */
public class TopFuncBtn extends JButton {

    /**
     * 初始化按钮
     */
    public TopFuncBtn(){
        super();
        setupUI();
    }

    /**
     * 初始化按钮属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(30, 30));
    }

}
