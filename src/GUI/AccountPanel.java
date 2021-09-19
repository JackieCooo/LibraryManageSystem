package GUI;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class AccountPanel {

    private JPanel accountPanel;
    private JLabel userPic;
    private JButton userName;

    {setupUI();}

    private void setupUI(){
        CellConstraints cc = new CellConstraints();
        accountPanel = new JPanel();
        accountPanel.setLayout(new FormLayout("fill:d:noGrow,left:10dlu:noGrow,fill:d:noGrow", "center:max(d;4px):noGrow"));
        accountPanel.setPreferredSize(new Dimension(200, 50));
        accountPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        userPic = new JLabel();
        userPic.setHorizontalAlignment(0);
        userPic.setHorizontalTextPosition(0);
        userPic.setPreferredSize(new Dimension(50, 50));
        userPic.setText("Label");
        accountPanel.add(userPic, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        userName = new JButton();
        userName.setPreferredSize(new Dimension(100, 30));
        userName.setText("Button");
        accountPanel.add(userName, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
    }

    public JPanel getAccountPanel(){
        return accountPanel;
    }
}
