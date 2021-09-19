package gui.login.window;

import javax.swing.*;
import java.awt.*;

/**
 * @brief 登录窗口类
 * @author Jackie
 */
public class LoginWindow {

    private JFrame frame;
    private JPanel loginWindow;

    private AdminLoginPanel adminLoginPage;
    private StudentLoginPanel studentLoginPage;
    private StudentSignUpPanel studentSignUpPage;

    /**
     * 初始化页面
     */
    public LoginWindow(){  // 初始化界面
        frame = new JFrame();
        frame.setBounds(100, 100, 400, 300);

        loginWindow = new JPanel();
        loginWindow.setLayout(new CardLayout(0, 0));
        loginWindow.setPreferredSize(new Dimension(400, 300));
        loginWindow.setVisible(true);

        studentLoginPage = new StudentLoginPanel();
        loginWindow.add(studentLoginPage.getStudentLoginPanel(), "studentLoginPage");

        adminLoginPage = new AdminLoginPanel();
        loginWindow.add(adminLoginPage.getAdminLoginPanel(), "adminLoginPage");

        studentSignUpPage = new StudentSignUpPanel();
        loginWindow.add(studentSignUpPage.getSignUpPanel(), "studentSignUpPage");

        frame.add(loginWindow);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
