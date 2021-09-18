package GUI;

import javax.swing.*;
import java.awt.*;

public class LoginWindow {

    JFrame frame = new JFrame();
    JPanel loginWindow = new JPanel();
    AdminLoginPanel adminLoginPage = new AdminLoginPanel();
    StudentLoginPanel studentLoginPage = new StudentLoginPanel();
    StudentSignUpPanel studentSignUpPage = new StudentSignUpPanel();

    public void init(){  // 初始化界面
        frame.setBounds(100, 100, 400, 300);

        loginWindow.setLayout(new CardLayout(0, 0));
        loginWindow.setPreferredSize(new Dimension(400, 300));
        loginWindow.setVisible(true);

        loginWindow.add(studentLoginPage.getStudentLoginPanel(), "studentLoginPage");
        loginWindow.add(adminLoginPage.getAdminLoginPanel(), "adminLoginPage");
        loginWindow.add(studentSignUpPage.getSignUpPanel(), "studentSignUpPage");

        frame.add(loginWindow);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
