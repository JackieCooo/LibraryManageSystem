package gui.admin.window;

import javax.swing.*;
import java.awt.*;

/**
 * 图书管理表格类
 * @author Jackie
 */
public class OperateTable extends JScrollPane {

    private JTable table;

    /**
     * 初始化界面
     */
    public OperateTable(){
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(680, 520));
        table = new JTable();
        table.setPreferredSize(new Dimension(680, 520));
        table.setPreferredScrollableViewportSize(new Dimension(680, 520));
        this.add(table);
    }

}
