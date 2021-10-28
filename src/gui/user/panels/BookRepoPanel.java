package gui.user.panels;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.components.BookRepoOpTable;
import gui.shared.components.CustomScrollPane;
import gui.shared.components.SearchPanel;

import javax.swing.*;
import java.awt.*;

/**
 * 图书库窗口类
 * @author Jackie
 */
public class BookRepoPanel extends JPanel {

    private SearchPanel searchPanel;
    private CustomScrollPane scrollPane;
    private BookRepoOpTable table;

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
        this.setLayout(new FormLayout("center:d:noGrow", "center:d:grow,center:d:grow"));
        CellConstraints cc = new CellConstraints();
        this.setOpaque(true);
        this.setBackground(Color.WHITE);

        searchPanel = new SearchPanel();
        this.add(searchPanel, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.CENTER));

        scrollPane = new CustomScrollPane(CustomScrollPane.VERTICAL, 880, 530);
        table = new BookRepoOpTable();
        scrollPane.setViewportView(table);
        this.add(scrollPane, cc.xy(1, 2, CellConstraints.CENTER, CellConstraints.CENTER));
    }

}
