package gui.login.panels;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;

public class SignUpPasswordConfirmPanel {

    private JPanel signUpPasswordConfirmPanel;
    private JLabel passwordConfirmLabel;
    private JPasswordField passwordConfirmField;

    public SignUpPasswordConfirmPanel(){
        signUpPasswordConfirmPanel = new JPanel();
        CellConstraints cc = new CellConstraints();
        signUpPasswordConfirmPanel.setLayout(new FormLayout("fill:61px:noGrow,fill:10px:noGrow,fill:max(d;4px):noGrow", "center:max(d;4px):noGrow"));
        passwordConfirmLabel = new JLabel();
        passwordConfirmLabel.setHorizontalAlignment(4);
        passwordConfirmLabel.setHorizontalTextPosition(4);
        passwordConfirmLabel.setPreferredSize(new Dimension(60, 30));
        passwordConfirmLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        passwordConfirmLabel.setText("确认密码");
        signUpPasswordConfirmPanel.add(passwordConfirmLabel, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        passwordConfirmField = new JPasswordField();
        passwordConfirmField.setPreferredSize(new Dimension(250, 30));
        signUpPasswordConfirmPanel.add(passwordConfirmField, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
    }

    public JPanel getSignUpPasswordConfirmPanel(){
        return signUpPasswordConfirmPanel;
    }

}
