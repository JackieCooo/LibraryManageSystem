package gui.user.window;

import javax.swing.*;
import java.awt.*;

/**
 * 结果表格类
 * @author Jackie
 */
public class OperateTable extends JPanel {

    private final int WIDTH = 880;
    private final int HEIGHT = 530;

    private JScrollPane scrollPane;
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
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        table = new JTable();
        table.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        table.setPreferredScrollableViewportSize(new Dimension(WIDTH, HEIGHT));

        scrollPane.add(table);

        this.add(scrollPane);
    }
}
