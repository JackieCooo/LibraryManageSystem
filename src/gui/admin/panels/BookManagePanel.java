package gui.admin.panels;

import gui.admin.components.OperateTable;
import gui.frames.AddBookFrame;
import gui.shared.panels.CustomScrollPane;
import gui.shared.panels.SearchPanel;

import javax.swing.*;
import java.awt.*;

/**
 * 图书管理板块类
 * @author Jackie
 */
public class BookManagePanel extends JPanel {

    private SearchPanel searchPanel;
    private OperateTable operateTable;
    private CustomScrollPane scrollPane;
    private AddBookFrame addBookFrame;

    /**
     * 初始化界面
     */
    public BookManagePanel(){
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(750, 600));
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.setOpaque(false);

        searchPanel = new SearchPanel();
        searchPanel.setPreferredSize(new Dimension(750, 50));
        this.add(searchPanel, BorderLayout.NORTH);

        scrollPane = new CustomScrollPane(CustomScrollPane.VERTICAL, 730, 520);
        operateTable = new OperateTable();
        scrollPane.setViewportView(operateTable);
        this.add(scrollPane);
    }

}
