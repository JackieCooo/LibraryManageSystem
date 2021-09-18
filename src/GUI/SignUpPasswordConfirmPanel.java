package GUI;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;

public class SignUpPasswordConfirmPanel {

    JPanel signUpPasswordConfirmPanel = new JPanel();
    JLabel signUpPasswordConfirmLabel = new JLabel();
    JPasswordField signUpPasswordConfirmField = new JPasswordField();

    SignUpPasswordConfirmPanel(){
        CellConstraints cc = new CellConstraints();
        signUpPasswordConfirmPanel.setLayout(new FormLayout("fill:61px:noGrow,fill:10px:noGrow,fill:max(d;4px):noGrow", "center:max(d;4px):noGrow"));
        signUpPasswordConfirmLabel.setHorizontalAlignment(0);
        signUpPasswordConfirmLabel.setHorizontalTextPosition(0);
        signUpPasswordConfirmLabel.setText("确认密码");
        signUpPasswordConfirmPanel.add(signUpPasswordConfirmLabel, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        signUpPasswordConfirmField.setPreferredSize(new Dimension(250, 30));
        signUpPasswordConfirmPanel.add(signUpPasswordConfirmField, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
    }

    JPanel getSignUpPasswordConfirmPanel(){
        return signUpPasswordConfirmPanel;
    }

}
