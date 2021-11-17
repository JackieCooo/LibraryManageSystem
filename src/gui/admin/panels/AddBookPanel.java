package gui.admin.panels;

import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;

public class AddBookPanel extends JPanel {

    public AddBookPanel(){
        super();
        setupUI();
    }

    private void setupUI(){
        this.setPreferredSize(new Dimension(400, 270));
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
        this.setLayout(new FormLayout("center:d:grow,center:10px:noGrow,center:d:grow", ""));
    }

}
