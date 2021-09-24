package gui.user.window;

import javax.swing.*;
import java.awt.*;

/**
 * 我的借阅窗口类
 * @author Jackie
 */
public class MyBorrowPanel extends JScrollPane {

    private JTable table;

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
        table = new JTable();
        table.setPreferredSize(new Dimension(900, 600));
        table.setPreferredScrollableViewportSize(new Dimension(900, 600));
        this.add(table);
    }

}
