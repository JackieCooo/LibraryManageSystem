package GUI;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;

public class SignUpStudentNumPanel {

    JPanel signUpStudentNumPanel = new JPanel();
    JTextField studentNumField = new JTextField();
    JLabel studentNumLabel = new JLabel();

    SignUpStudentNumPanel(){
        CellConstraints cc = new CellConstraints();
        signUpStudentNumPanel.setLayout(new FormLayout("fill:max(d;4px):noGrow,fill:10px:noGrow,fill:max(d;4px):noGrow", "center:max(d;4px):noGrow"));
        studentNumField.setPreferredSize(new Dimension(250, 30));
        signUpStudentNumPanel.add(studentNumField, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        studentNumLabel.setHorizontalAlignment(4);
        studentNumLabel.setHorizontalTextPosition(4);
        studentNumLabel.setPreferredSize(new Dimension(60, 30));
        studentNumLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        studentNumLabel.setText("学号");
        signUpStudentNumPanel.add(studentNumLabel, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
    }

    JPanel getSignUpStudentNumPanel(){
        return signUpStudentNumPanel;
    }

}
