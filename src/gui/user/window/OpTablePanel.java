package gui.user.window;

import gui.components.BookRepoOpTable;
import gui.shared.components.CustomScrollPane;

import javax.swing.*;
import java.awt.*;

/**
 * 结果表格类
 * @author Jackie
 */
public class OpTablePanel extends JPanel {

    private final int WIDTH = 880;
    private final int HEIGHT = 530;

    private CustomScrollPane scrollPane;
    private BookRepoOpTable table;

    /**
     * 初始化界面
     */
    public OpTablePanel(){
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        scrollPane = new CustomScrollPane(CustomScrollPane.VERTICAL, WIDTH, HEIGHT);
        table = new BookRepoOpTable();
        scrollPane.setViewportView(table);

        this.add(scrollPane);
    }
}
