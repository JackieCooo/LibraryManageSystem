package gui.login.window;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * 学生登录页面
 * @author Jackie
 */
public class StudentLoginPanel extends JPanel{

    private JLabel loginLabel;
    private JTextField studentNumField;
    private JPasswordField passwordField;
    private BtnSetPanel studentSignInBtnSet;
    private JButton switch2AdminBtn;
    private MessageArea loginMessage;

    /**
     * 初始化页面
     */
    public StudentLoginPanel(){
        this.setLayout(new FormLayout("fill:d:grow", "center:max(d;4px):noGrow,fill:20px:noGrow,center:43px:noGrow,fill:10px:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:d:grow,top:4dlu:noGrow,center:max(d;4px):noGrow"));
        this.setPreferredSize(new Dimension(400, 300));
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        loginLabel = new JLabel();
        loginLabel.setHorizontalAlignment(10);
        loginLabel.setHorizontalTextPosition(11);
        loginLabel.setText("登录");
        loginLabel.setFont(new Font("黑体", Font.BOLD, 24));
        CellConstraints cc = new CellConstraints();
        this.add(loginLabel, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        studentNumField = new JTextField();
        studentNumField.setMargin(new Insets(2, 6, 2, 6));
        studentNumField.setPreferredSize(new Dimension(250, 30));
        this.add(studentNumField, cc.xy(1, 3, CellConstraints.CENTER, CellConstraints.DEFAULT));
        passwordField = new JPasswordField();
        passwordField.setMargin(new Insets(2, 6, 2, 6));
        passwordField.setPreferredSize(new Dimension(250, 30));
        this.add(passwordField, cc.xy(1, 5, CellConstraints.CENTER, CellConstraints.DEFAULT));

        studentSignInBtnSet = new BtnSetPanel("登录", "注册");
        // 处理转到学生注册页面的按钮事件
        studentSignInBtnSet.getRightBtn().addActionListener(e -> {
            Container p = this.getParent();
            p.getComponent(0).setVisible(false);
            p.getComponent(2).setVisible(true);
        });
        this.add(studentSignInBtnSet.getBtnSet(), cc.xy(1, 9, CellConstraints.CENTER, CellConstraints.TOP));

        switch2AdminBtn = new JButton();
        switch2AdminBtn.setPreferredSize(new Dimension(180, 45));
        switch2AdminBtn.setText("管理员登录");

        // 处理转到管理员登录界面的按钮事件
        switch2AdminBtn.addActionListener(e -> {
            Container p = this.getParent();
            p.getComponent(0).setVisible(false);
            p.getComponent(1).setVisible(true);
        });

        this.add(switch2AdminBtn, cc.xy(1, 11, CellConstraints.DEFAULT, CellConstraints.CENTER));

        loginMessage = new MessageArea();
        this.add(loginMessage, cc.xy(1, 7, CellConstraints.CENTER, CellConstraints.DEFAULT));
    }

}
