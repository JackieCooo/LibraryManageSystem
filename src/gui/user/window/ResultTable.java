package gui.user.window;

import javax.swing.*;
import java.awt.*;

/**
 * 结果表格类
 * @author Jackie
 */
public class ResultTable extends JScrollPane {

    private JTable table;

    /**
     * 初始化界面
     */
    public ResultTable(){
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(880, 530));
        table = new JTable();
        table.setPreferredSize(new Dimension(880, 530));
        table.setPreferredScrollableViewportSize(new Dimension(880, 530));
        this.add(table);
    }
}
