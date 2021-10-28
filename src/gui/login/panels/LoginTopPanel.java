package gui.login.panels;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.components.CloseBtn;
import gui.components.MinimizeBtn;

import javax.swing.*;
import java.awt.*;

public class LoginTopPanel extends JPanel {

    private CloseBtn closeBtn;
    private MinimizeBtn minimizeBtn;

    public LoginTopPanel(){
        super();
        setupUI();
    }

    private void setupUI(){
        this.setPreferredSize(new Dimension(400, 30));
        this.setLayout(new FormLayout("center:d:grow,center:d:noGrow,center:10px:noGrow,center:d:noGrow,center:5px:noGrow", "center:d:grow"));
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
        CellConstraints cc = new CellConstraints();

        closeBtn = new CloseBtn();
        this.add(closeBtn, cc.xy(4, 1, CellConstraints.CENTER, CellConstraints.CENTER));

        minimizeBtn = new MinimizeBtn();
        this.add(minimizeBtn, cc.xy(2, 1, CellConstraints.CENTER, CellConstraints.CENTER));
    }

}
