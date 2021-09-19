package GUI;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class BottomPanel {

    private JPanel bottomPanel;
    private FuncBtn bookRepoBtn;
    private FuncBtn myCollectBtn;
    private FuncBtn myBorrowBtn;
    private FuncBtn mySpaceBtn;

    {setupUI();}

    private void setupUI(){
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FormLayout("fill:d:grow,left:10px:noGrow,fill:d:grow,left:10px:noGrow,fill:d:grow,left:10px:noGrow,fill:d:grow", "center:d:grow"));
        bottomPanel.setPreferredSize(new Dimension(900, 275));
        bottomPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        CellConstraints cc = new CellConstraints();
        bookRepoBtn = new FuncBtn("书库");
        bottomPanel.add(bookRepoBtn, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));

        myCollectBtn = new FuncBtn("我的收藏");
        bottomPanel.add(myCollectBtn, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));

        myBorrowBtn = new FuncBtn("我的借阅");
        bottomPanel.add(myBorrowBtn, cc.xy(5, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));

        mySpaceBtn = new FuncBtn("我的空间");
        bottomPanel.add(mySpaceBtn, cc.xy(7, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
    }

    JPanel getBottomPanel(){
        return bottomPanel;
    }

}
