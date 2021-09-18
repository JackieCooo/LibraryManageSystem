package GUI;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;

public class SignUpPasswordConfirmPanel {

    JPanel signUpPasswordConfirmPanel = new JPanel();
    JLabel passwordConfirmLabel = new JLabel();
    JPasswordField passwordConfirmField = new JPasswordField();

    SignUpPasswordConfirmPanel(){
        CellConstraints cc = new CellConstraints();
        signUpPasswordConfirmPanel.setLayout(new FormLayout("fill:61px:noGrow,fill:10px:noGrow,fill:max(d;4px):noGrow", "center:max(d;4px):noGrow"));
        passwordConfirmLabel.setHorizontalAlignment(4);
        passwordConfirmLabel.setHorizontalTextPosition(4);
        passwordConfirmLabel.setPreferredSize(new Dimension(60, 30));
        passwordConfirmLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        passwordConfirmLabel.setText("确认密码");
        signUpPasswordConfirmPanel.add(passwordConfirmLabel, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        passwordConfirmField.setPreferredSize(new Dimension(250, 30));
        signUpPasswordConfirmPanel.add(passwordConfirmField, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
    }

    JPanel getSignUpPasswordConfirmPanel(){
        return signUpPasswordConfirmPanel;
    }

}
