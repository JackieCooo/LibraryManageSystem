package GUI;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;

public class BtnSetPanel {

    JPanel btnSet = new JPanel();
    JButton leftBtn = new JButton();
    JButton rightBtn = new JButton();

    BtnSetPanel(String leftBtnName, String rightBtnName){
        CellConstraints cc = new CellConstraints();
        btnSet.setLayout(new FormLayout("fill:103px:grow,left:50px:noGrow,fill:d:grow", "center:d:grow"));
        leftBtn.setHorizontalTextPosition(0);
        leftBtn.setPreferredSize(new Dimension(100, 40));
        leftBtn.setText(leftBtnName);
        btnSet.add(leftBtn, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        rightBtn.setHorizontalTextPosition(0);
        rightBtn.setPreferredSize(new Dimension(100, 40));
        rightBtn.setText(rightBtnName);
        btnSet.add(rightBtn, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
    }

    JPanel getBtnSet(){
        return btnSet;
    }
}
