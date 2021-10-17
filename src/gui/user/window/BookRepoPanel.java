package gui.user.window;

import gui.shared.components.SearchPanel;

import javax.swing.*;
import java.awt.*;

/**
 * 图书库窗口类
 * @author Jackie
 */
public class BookRepoPanel extends JPanel {

    SearchPanel searchPanel;
    OperateTable resultTable;

    /**
     * 初始化界面
     */
    public BookRepoPanel(){
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(900, 600));
        searchPanel = new SearchPanel();
        searchPanel.setPreferredSize(new Dimension(900, 50));
        this.add(searchPanel, BorderLayout.NORTH);
        resultTable = new OperateTable();
        this.add(resultTable);
    }

}
