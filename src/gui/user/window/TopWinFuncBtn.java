package gui.user.window;

import javax.swing.*;
import java.awt.*;

/**
 * 窗口控制按钮类
 * @author Jackie
 */
public class TopWinFuncBtn extends JButton {

    /**
     * 按钮初始化
     */
    public TopWinFuncBtn(){
        super();
        setupUI();
    }

    /**
     * 按钮属性初始化
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(20, 20));
    }

}
