package GUI;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;

public class SignUpStudentNumPanel {

    JPanel signUpStudentNumPanel = new JPanel();
    JTextField signUpStudentNumField = new JTextField();
    JLabel signUpStudentNumLabel = new JLabel();

    SignUpStudentNumPanel(){
        CellConstraints cc = new CellConstraints();
        signUpStudentNumPanel.setLayout(new FormLayout("fill:max(d;4px):noGrow,fill:10px:noGrow,fill:max(d;4px):noGrow", "center:max(d;4px):noGrow"));
        signUpStudentNumField.setPreferredSize(new Dimension(250, 30));
        signUpStudentNumPanel.add(signUpStudentNumField, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        signUpStudentNumLabel.setHorizontalAlignment(0);
        signUpStudentNumLabel.setHorizontalTextPosition(0);
        signUpStudentNumLabel.setText("学号");
        signUpStudentNumPanel.add(signUpStudentNumLabel, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
    }

    JPanel getSignUpStudentNumPanel(){
        return signUpStudentNumPanel;
    }

}
