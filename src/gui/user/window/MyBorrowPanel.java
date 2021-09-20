package gui.user.window;

import javax.swing.*;
import java.awt.*;

/**
 * 我的借阅窗口类
 * @author Jackie
 */
public class MyBorrowPanel extends JPanel {
    
    /**
     * 初始化界面
     */
    public MyBorrowPanel(){
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
