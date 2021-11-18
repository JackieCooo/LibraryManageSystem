package gui.admin.panels;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;

/**
 * 书本信息面板类
 * @author Jackie
 */
public class BookInfoPanel extends JPanel {

    private TextFieldPanel bookNo;
    private TextFieldPanel bookName;
    private TextFieldPanel bookWriter;
    private TextFieldPanel bookPublisher;

    /**
     * 初始化界面
     */
    public BookInfoPanel(){
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(new Dimension(230, 450)));
        this.setOpaque(false);
        this.setLayout(new FormLayout("center:d:grow", "bottom:d:grow,center:10px:noGrow,center:d:noGrow,center:10px:noGrow,center:d:noGrow,center:10px:noGrow,top:d:grow"));
        CellConstraints cc = new CellConstraints();

        bookNo = new TextFieldPanel("编号:");
        this.add(bookNo, cc.xy(1, 1));

        bookName = new TextFieldPanel("书名:");
        this.add(bookName, cc.xy(1, 3));

        bookWriter = new TextFieldPanel("作者:");
        this.add(bookWriter, cc.xy(1, 5));

        bookPublisher = new TextFieldPanel("出版商:");
        this.add(bookPublisher, cc.xy(1, 7));
    }

}
