package gui.admin.panels;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.admin.components.BookPic;

import javax.swing.*;
import java.awt.*;

public class AddBookPanel extends JPanel {

    private BookPic bookPic;

    public AddBookPanel(){
        super();
        setupUI();
    }

    private void setupUI(){
        this.setPreferredSize(new Dimension(400, 270));
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
        this.setLayout(new FormLayout("center:d:grow,center:10px:noGrow,center:d:grow", "center:d:grow"));
        CellConstraints cc = new CellConstraints();

        bookPic = new BookPic();
        this.add(bookPic, cc.xy(1, 1));
    }

}
