package GUI;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;

public class SignUpPasswordPanel {

    JPanel signUpPasswordPanel = new JPanel();
    JLabel signUpPasswordLabel = new JLabel();
    JPasswordField signUpPasswordField = new JPasswordField();

    SignUpPasswordPanel(){
        CellConstraints cc = new CellConstraints();
        signUpPasswordPanel.setLayout(new FormLayout("fill:32px:noGrow,fill:10px:noGrow,fill:d:grow", "center:d:grow,center:d:noGrow"));
        signUpPasswordLabel.setHorizontalAlignment(0);
        signUpPasswordLabel.setHorizontalTextPosition(0);
        signUpPasswordLabel.setText("密码");
        signUpPasswordPanel.add(signUpPasswordLabel, cc.xy(1, 2, CellConstraints.CENTER, CellConstraints.DEFAULT));
        signUpPasswordField.setPreferredSize(new Dimension(250, 30));
        signUpPasswordPanel.add(signUpPasswordField, cc.xy(3, 2, CellConstraints.CENTER, CellConstraints.DEFAULT));
    }

    JPanel getSignUpPasswordPanel(){
        return signUpPasswordPanel;
    }

}
