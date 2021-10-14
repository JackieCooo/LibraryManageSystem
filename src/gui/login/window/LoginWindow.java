package gui.login.window;

import javax.swing.*;
import java.awt.*;

/**
 * @brief 登录窗口类
 * @author Jackie
 */
public class LoginWindow extends JPanel{

    private AdminLoginPanel adminLoginPage;
    private StudentLoginPanel studentLoginPage;
    private StudentSignUpPanel studentSignUpPage;

    /**
     * 初始化页面
     */
    public LoginWindow(){

        this.setLayout(new CardLayout(0, 0));
        this.setPreferredSize(new Dimension(400, 300));
        this.setVisible(true);

        studentLoginPage = new StudentLoginPanel();
        this.add(studentLoginPage, "studentLoginPage");

        adminLoginPage = new AdminLoginPanel();
        this.add(adminLoginPage, "adminLoginPage");

        studentSignUpPage = new StudentSignUpPanel();
        this.add(studentSignUpPage, "studentSignUpPage");

    }
}
