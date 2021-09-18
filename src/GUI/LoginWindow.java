package GUI;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class LoginWindow {

    JFrame frame;
    JPanel loginWindow;
    JPanel adminLoginPage;
    JPasswordField adminPasswordField;
    JLabel adminLoginLabel;
    JTextField adminNumField;
    JPanel signUpPage;
    JTextField signUpStudentNumField;
    JPasswordField signUpPasswordField;
    JPasswordField signUpPasswordConfirmField;
    JButton signUpBtn;
    JLabel signUpLabel;
    JLabel signUpStudentNumLabel;
    JLabel signUpPasswordLabel;
    JLabel signUpPasswordConfirmLabel;
    JButton signUp2Login;
    JLabel adminLoginMessage;
    JLabel signUpMessage;
    JPanel signUpStudentNumPanel;
    JPanel signUpPasswordPanel;
    JPanel signUpPasswordConfirmPanel;

    BtnSetPanel adminSignInBtnSet;
    StudentLoginPanel studentLoginPage;

    public void init(){  // 初始化界面

        frame = new JFrame();
        frame.setBounds(100, 100, 400, 300);

        CellConstraints cc = new CellConstraints();

        loginWindow = new JPanel();
        loginWindow.setLayout(new CardLayout(0, 0));
        loginWindow.setPreferredSize(new Dimension(400, 300));
        loginWindow.setVisible(true);

        studentLoginPage = new StudentLoginPanel();
        loginWindow.add(studentLoginPage.getStudentLoginPanel(), "studentLoginPage");

        adminLoginPage = new JPanel();
        adminLoginPage.setLayout(new FormLayout("fill:d:grow", "center:34px:noGrow,fill:20px:noGrow,center:43px:noGrow,fill:10px:noGrow,center:43px:noGrow,fill:10px:noGrow,center:18px:noGrow,fill:10px:noGrow,center:d:grow"));
        adminLoginPage.setPreferredSize(new Dimension(400, 300));
        adminLoginPage.setVisible(false);
        loginWindow.add(adminLoginPage, "adminLoginPage");
        adminLoginPage.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        adminLoginLabel = new JLabel();
        adminLoginLabel.setText("管理员登录");
        adminLoginPage.add(adminLoginLabel, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        adminNumField = new JTextField();
        adminNumField.setMargin(new Insets(2, 6, 2, 6));
        adminNumField.setPreferredSize(new Dimension(250, 30));
        adminLoginPage.add(adminNumField, cc.xy(1, 3, CellConstraints.CENTER, CellConstraints.DEFAULT));
        adminPasswordField = new JPasswordField();
        adminPasswordField.setPreferredSize(new Dimension(250, 30));
        adminLoginPage.add(adminPasswordField, cc.xy(1, 5, CellConstraints.CENTER, CellConstraints.DEFAULT));

        adminSignInBtnSet = new BtnSetPanel("登录", "学生登录");
        adminSignInBtnSet.rightBtn.addActionListener(e -> {
            loginWindow.getComponent(1).setVisible(false);
            loginWindow.getComponent(0).setVisible(true);
        });
        adminLoginPage.add(adminSignInBtnSet.getBtnSet(), cc.xy(1, 9, CellConstraints.CENTER, CellConstraints.TOP));

        adminLoginMessage = new JLabel();
        adminLoginMessage.setHorizontalAlignment(0);
        adminLoginMessage.setHorizontalTextPosition(0);
        adminLoginMessage.setPreferredSize(new Dimension(250, 25));
        adminLoginMessage.setText("test");
        adminLoginPage.add(adminLoginMessage, cc.xy(1, 7, CellConstraints.CENTER, CellConstraints.DEFAULT));
        signUpPage = new JPanel();
        signUpPage.setLayout(new FormLayout("fill:d:grow", "center:38px:noGrow,fill:20px:noGrow,center:d:noGrow,fill:10px:noGrow,center:d:noGrow,fill:10px:noGrow,center:d:noGrow,fill:10px:noGrow,center:d:noGrow,fill:10px:noGrow,center:d:grow,fill:10px:noGrow,center:d:noGrow"));
        signUpPage.setPreferredSize(new Dimension(400, 300));
        loginWindow.add(signUpPage, "signUpPage");
        signUpPage.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        signUpBtn = new JButton();
        signUpBtn.setPreferredSize(new Dimension(250, 40));
        signUpBtn.setText("注册");
        signUpPage.add(signUpBtn, cc.xy(1, 11, CellConstraints.CENTER, CellConstraints.TOP));
        signUpLabel = new JLabel();
        signUpLabel.setAlignmentX(0.0f);
        signUpLabel.setHorizontalAlignment(0);
        signUpLabel.setHorizontalTextPosition(0);
        signUpLabel.setText("注册");
        signUpPage.add(signUpLabel, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        signUp2Login = new JButton();
        signUp2Login.setPreferredSize(new Dimension(250, 40));
        signUp2Login.setText("学生登录页面");
        signUpPage.add(signUp2Login, cc.xy(1, 13, CellConstraints.CENTER, CellConstraints.BOTTOM));
        signUpMessage = new JLabel();
        signUpMessage.setHorizontalAlignment(0);
        signUpMessage.setHorizontalTextPosition(0);
        signUpMessage.setPreferredSize(new Dimension(250, 25));
        signUpMessage.setText("test");
        signUpPage.add(signUpMessage, cc.xy(1, 9, CellConstraints.CENTER, CellConstraints.DEFAULT));
        signUpStudentNumPanel = new JPanel();
        signUpStudentNumPanel.setLayout(new FormLayout("fill:max(d;4px):noGrow,fill:10px:noGrow,fill:max(d;4px):noGrow", "center:max(d;4px):noGrow"));
        signUpPage.add(signUpStudentNumPanel, cc.xy(1, 3, CellConstraints.CENTER, CellConstraints.DEFAULT));
        signUpStudentNumField = new JTextField();
        signUpStudentNumField.setPreferredSize(new Dimension(250, 30));
        signUpStudentNumPanel.add(signUpStudentNumField, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        signUpStudentNumLabel = new JLabel();
        signUpStudentNumLabel.setHorizontalAlignment(0);
        signUpStudentNumLabel.setHorizontalTextPosition(0);
        signUpStudentNumLabel.setText("学号");
        signUpStudentNumPanel.add(signUpStudentNumLabel, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        signUpPasswordPanel = new JPanel();
        signUpPasswordPanel.setLayout(new FormLayout("fill:32px:noGrow,fill:10px:noGrow,fill:d:grow", "center:d:grow,center:d:noGrow"));
        signUpPage.add(signUpPasswordPanel, cc.xy(1, 5, CellConstraints.CENTER, CellConstraints.DEFAULT));
        signUpPasswordLabel = new JLabel();
        signUpPasswordLabel.setHorizontalAlignment(0);
        signUpPasswordLabel.setHorizontalTextPosition(0);
        signUpPasswordLabel.setText("密码");
        signUpPasswordPanel.add(signUpPasswordLabel, cc.xy(1, 2, CellConstraints.CENTER, CellConstraints.DEFAULT));
        signUpPasswordField = new JPasswordField();
        signUpPasswordField.setPreferredSize(new Dimension(250, 30));
        signUpPasswordPanel.add(signUpPasswordField, cc.xy(3, 2, CellConstraints.CENTER, CellConstraints.DEFAULT));
        signUpPasswordConfirmPanel = new JPanel();
        signUpPasswordConfirmPanel.setLayout(new FormLayout("fill:61px:noGrow,fill:10px:noGrow,fill:max(d;4px):noGrow", "center:max(d;4px):noGrow"));
        signUpPage.add(signUpPasswordConfirmPanel, new CellConstraints(1, 7, 1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT, new Insets(0, 0, 0, 25)));
        signUpPasswordConfirmLabel = new JLabel();
        signUpPasswordConfirmLabel.setHorizontalAlignment(0);
        signUpPasswordConfirmLabel.setHorizontalTextPosition(0);
        signUpPasswordConfirmLabel.setText("确认密码");
        signUpPasswordConfirmPanel.add(signUpPasswordConfirmLabel, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        signUpPasswordConfirmField = new JPasswordField();
        signUpPasswordConfirmField.setPreferredSize(new Dimension(250, 30));
        signUpPasswordConfirmPanel.add(signUpPasswordConfirmField, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));

        frame.add(loginWindow);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
