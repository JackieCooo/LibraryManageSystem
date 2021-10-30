package gui.login.panels;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class StudentSignUpPanel extends JPanel{

    private JButton signUpBtn;
    private JLabel signUpLabel;
    private JButton signUp2Login;

    private MessageArea signUpMessage;
    private SignUpStudentNumPanel studentNumPanel;
    private SignUpPasswordPanel passwordPanel;
    private SignUpPasswordConfirmPanel passwordConfirmPanel;
    
    public StudentSignUpPanel(){
        CellConstraints cc = new CellConstraints();
        this.setLayout(new FormLayout("fill:d:grow", "center:38px:noGrow,fill:20px:noGrow,center:d:noGrow,fill:10px:noGrow,center:d:noGrow,fill:10px:noGrow,center:d:noGrow,fill:10px:noGrow,center:d:noGrow,fill:10px:noGrow,center:d:grow,fill:10px:noGrow,center:d:noGrow"));
        this.setPreferredSize(new Dimension(400, 300));
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        signUpBtn = new JButton();
        signUpBtn.setPreferredSize(new Dimension(250, 40));
        signUpBtn.setText("注册");
        this.add(signUpBtn, cc.xy(1, 11, CellConstraints.CENTER, CellConstraints.TOP));
        signUpLabel = new JLabel();
        signUpLabel.setAlignmentX(0.0f);
        signUpLabel.setHorizontalAlignment(0);
        signUpLabel.setHorizontalTextPosition(0);
        signUpLabel.setFont(new Font("黑体", Font.BOLD, 24));
        signUpLabel.setText("注册");
        this.add(signUpLabel, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        signUp2Login = new JButton();
        signUp2Login.setPreferredSize(new Dimension(250, 40));
        signUp2Login.setText("学生登录页面");

        signUp2Login.addActionListener(e -> {
            Container p = this.getParent();
            p.getComponent(2).setVisible(false);
            p.getComponent(0).setVisible(true);
        });

        this.add(signUp2Login, cc.xy(1, 13, CellConstraints.CENTER, CellConstraints.BOTTOM));
        signUpMessage = new MessageArea();
        this.add(signUpMessage, cc.xy(1, 9, CellConstraints.CENTER, CellConstraints.DEFAULT));

        studentNumPanel = new SignUpStudentNumPanel();
        this.add(studentNumPanel.getSignUpStudentNumPanel(), cc.xy(1, 3, CellConstraints.CENTER, CellConstraints.DEFAULT));

        passwordPanel = new SignUpPasswordPanel();
        this.add(passwordPanel, cc.xy(1, 5, CellConstraints.CENTER, CellConstraints.DEFAULT));

        passwordConfirmPanel = new SignUpPasswordConfirmPanel();
        this.add(passwordConfirmPanel.getSignUpPasswordConfirmPanel(), cc.xy(1, 7, CellConstraints.CENTER, CellConstraints.DEFAULT));
    }
    
}
