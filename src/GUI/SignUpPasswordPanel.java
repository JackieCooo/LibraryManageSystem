package GUI;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;

public class SignUpPasswordPanel {

    JPanel signUpPasswordPanel = new JPanel();
    JLabel passwordLabel = new JLabel();
    JPasswordField passwordField = new JPasswordField();

    SignUpPasswordPanel(){
        CellConstraints cc = new CellConstraints();
        signUpPasswordPanel.setLayout(new FormLayout("fill:d:noGrow,fill:10px:noGrow,fill:d:grow", "center:d:grow,center:d:noGrow"));
        passwordLabel.setHorizontalAlignment(4);
        passwordLabel.setHorizontalTextPosition(4);
        passwordLabel.setPreferredSize(new Dimension(60, 30));
        passwordLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        passwordLabel.setText("密码");
        signUpPasswordPanel.add(passwordLabel, cc.xy(1, 2, CellConstraints.CENTER, CellConstraints.DEFAULT));
        passwordField.setPreferredSize(new Dimension(250, 30));
        signUpPasswordPanel.add(passwordField, cc.xy(3, 2, CellConstraints.CENTER, CellConstraints.DEFAULT));
    }

    JPanel getSignUpPasswordPanel(){
        return signUpPasswordPanel;
    }

}
