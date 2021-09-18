package GUI;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class StudentLoginPanel {
    JPanel studentLoginPanel = new JPanel();
    JLabel loginLabel = new JLabel();
    JTextField studentNumField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    BtnSetPanel studentSignInBtnSet = new BtnSetPanel("登录", "注册");
    JButton switch2AdminBtn = new JButton();
    JLabel loginMessage = new JLabel();
    
    StudentLoginPanel(){
        studentLoginPanel.setLayout(new FormLayout("fill:d:grow", "center:max(d;4px):noGrow,fill:20px:noGrow,center:43px:noGrow,fill:10px:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:d:grow,top:4dlu:noGrow,center:max(d;4px):noGrow"));
        studentLoginPanel.setPreferredSize(new Dimension(400, 300));
        studentLoginPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        loginLabel.setHorizontalAlignment(10);
        loginLabel.setHorizontalTextPosition(11);
        loginLabel.setText("登录");
        loginLabel.setFont(new Font("黑体", Font.BOLD, 24));
        CellConstraints cc = new CellConstraints();
        studentLoginPanel.add(loginLabel, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        studentNumField.setMargin(new Insets(2, 6, 2, 6));
        studentNumField.setPreferredSize(new Dimension(250, 30));
        studentLoginPanel.add(studentNumField, cc.xy(1, 3, CellConstraints.CENTER, CellConstraints.DEFAULT));
        passwordField.setMargin(new Insets(2, 6, 2, 6));
        passwordField.setPreferredSize(new Dimension(250, 30));
        studentLoginPanel.add(passwordField, cc.xy(1, 5, CellConstraints.CENTER, CellConstraints.DEFAULT));

        // 处理转到学生注册页面的按钮事件
        studentSignInBtnSet.rightBtn.addActionListener(e -> {
            Container p = studentLoginPanel.getParent();
            p.getComponent(0).setVisible(false);
            p.getComponent(2).setVisible(true);
        });
        studentLoginPanel.add(studentSignInBtnSet.getBtnSet(), cc.xy(1, 9, CellConstraints.CENTER, CellConstraints.TOP));

        switch2AdminBtn.setPreferredSize(new Dimension(180, 45));
        switch2AdminBtn.setText("管理员登录");
        studentLoginPanel.add(switch2AdminBtn, cc.xy(1, 11, CellConstraints.DEFAULT, CellConstraints.CENTER));
        loginMessage.setHorizontalAlignment(0);
        loginMessage.setHorizontalTextPosition(0);
        loginMessage.setPreferredSize(new Dimension(300, 25));
        loginMessage.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        loginMessage.setText("test");
        studentLoginPanel.add(loginMessage, cc.xy(1, 7, CellConstraints.CENTER, CellConstraints.DEFAULT));
    }

    JPanel getStudentLoginPanel() {
        return studentLoginPanel;
    }
}
