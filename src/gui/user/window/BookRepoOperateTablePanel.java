package gui.user.window;

import javax.swing.*;
import java.awt.*;

/**
 * 书库操作表格面板类
 * @author Jackie
 */
public class BookRepoOperateTablePanel extends JPanel {

    /**
     * 初始化界面
     */
    public BookRepoOperateTablePanel(){
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(880, 530));

        TableScrollPane myScrollPane = new TableScrollPane();
        this.add(myScrollPane);
    }

}
