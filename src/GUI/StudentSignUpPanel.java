package GUI;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class StudentSignUpPanel {
    
    JPanel signUpPanel = new JPanel();
    JButton signUpBtn = new JButton();
    JLabel signUpLabel = new JLabel();
    JButton signUp2Login = new JButton();
    JLabel signUpMessage = new JLabel();
    
    SignUpStudentNumPanel studentNumPanel = new SignUpStudentNumPanel();
    SignUpPasswordPanel passwordPanel = new SignUpPasswordPanel();
    SignUpPasswordConfirmPanel passwordConfirmPanel = new SignUpPasswordConfirmPanel();
    
    StudentSignUpPanel(){
        CellConstraints cc = new CellConstraints();
        signUpPanel.setLayout(new FormLayout("fill:d:grow", "center:38px:noGrow,fill:20px:noGrow,center:d:noGrow,fill:10px:noGrow,center:d:noGrow,fill:10px:noGrow,center:d:noGrow,fill:10px:noGrow,center:d:noGrow,fill:10px:noGrow,center:d:grow,fill:10px:noGrow,center:d:noGrow"));
        signUpPanel.setPreferredSize(new Dimension(400, 300));
        signUpPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        signUpBtn.setPreferredSize(new Dimension(250, 40));
        signUpBtn.setText("注册");
        signUpPanel.add(signUpBtn, cc.xy(1, 11, CellConstraints.CENTER, CellConstraints.TOP));
        signUpLabel.setAlignmentX(0.0f);
        signUpLabel.setHorizontalAlignment(0);
        signUpLabel.setHorizontalTextPosition(0);
        signUpLabel.setText("注册");
        signUpPanel.add(signUpLabel, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        signUp2Login.setPreferredSize(new Dimension(250, 40));
        signUp2Login.setText("学生登录页面");
        signUpPanel.add(signUp2Login, cc.xy(1, 13, CellConstraints.CENTER, CellConstraints.BOTTOM));
        signUpMessage.setHorizontalAlignment(0);
        signUpMessage.setHorizontalTextPosition(0);
        signUpMessage.setPreferredSize(new Dimension(250, 25));
        signUpMessage.setText("test");
        signUpPanel.add(signUpMessage, cc.xy(1, 9, CellConstraints.CENTER, CellConstraints.DEFAULT));
        
        signUpPanel.add(studentNumPanel.getSignUpStudentNumPanel(), cc.xy(1, 3, CellConstraints.CENTER, CellConstraints.DEFAULT));
        signUpPanel.add(passwordPanel.getSignUpPasswordPanel(), cc.xy(1, 5, CellConstraints.CENTER, CellConstraints.DEFAULT));
        signUpPanel.add(passwordConfirmPanel.getSignUpPasswordConfirmPanel(), new CellConstraints(1, 7, 1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT, new Insets(0, 0, 0, 25)));
    }
    
    JPanel getSignUpPanel(){
        return signUpPanel;
    }
    
}
