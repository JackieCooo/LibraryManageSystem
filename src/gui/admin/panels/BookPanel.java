package gui.admin.panels;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.admin.components.BookPic;

import javax.swing.*;
import java.awt.*;

/**
 * 书本面板类
 * @author Jackie
 */
public class BookPanel extends JPanel {

    private BookPic bookPic;
    private BookInfoPanel bookInfoPanel;

    /**
     * 初始化界面
     */
    public BookPanel(){
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(400, 270));
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
        this.setLayout(new FormLayout("right:d:grow,center:50px:noGrow,left:d:grow", "center:d:grow"));
        CellConstraints cc = new CellConstraints();

        bookPic = new BookPic();
        this.add(bookPic, cc.xy(1, 1));

        bookInfoPanel = new BookInfoPanel();
        this.add(bookInfoPanel, cc.xy(3, 1));
    }

}
