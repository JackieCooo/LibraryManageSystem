package gui.user.panels;

import javax.swing.*;
import java.awt.*;

/**
 * 我的空间窗口类
 * @author Jackie
 */
public class MySpacePanel extends JPanel {

    /**
     * 初始化界面
     */
    public MySpacePanel(){
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(900, 600));
    }

}
