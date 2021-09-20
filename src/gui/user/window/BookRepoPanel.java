package gui.user.window;

import javax.swing.*;
import java.awt.*;

/**
 * 图书库窗口类
 * @author Jackie
 */
public class BookRepoPanel extends JPanel {

    SearchPanel searchPanel;
    ResultTable resultTable;

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
        this.add(searchPanel, BorderLayout.NORTH);
        resultTable = new ResultTable();
        this.add(resultTable);
    }

}
