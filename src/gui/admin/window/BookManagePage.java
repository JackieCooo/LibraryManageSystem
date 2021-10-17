package gui.admin.window;

import gui.shared.components.SearchPanel;

import javax.swing.*;
import java.awt.*;

/**
 * 图书管理板块类
 * @author Jackie
 */
public class BookManagePage extends JPanel {

    private SearchPanel searchPanel;
    private OperateTable operateTable;

    /**
     * 初始化界面
     */
    public BookManagePage(){
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(700, 600));
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        searchPanel = new SearchPanel();
        searchPanel.setPreferredSize(new Dimension(700, 50));
        this.add(searchPanel, BorderLayout.NORTH);
        operateTable = new OperateTable();
        this.add(operateTable);
    }

}
