package gui.login.panels;

import javax.swing.*;
import java.awt.*;

/**
 * @brief 登录窗口类
 * @author Jackie
 */
public class MainPanel extends JPanel{

    private AdminLoginPanel adminLoginPage;
    private UserLoginPanel userLoginPage;
    private UserSignUpPanel userSignUpPage;

    /**
     * 初始化页面
     */
    public MainPanel(){
        this.setLayout(new CardLayout(0, 0));
        this.setPreferredSize(new Dimension(400, 270));
        this.setOpaque(true);
        this.setBackground(Color.WHITE);

        userLoginPage = new UserLoginPanel();
        this.add(userLoginPage, "studentLoginPage");  // 0

        adminLoginPage = new AdminLoginPanel();
        this.add(adminLoginPage, "adminLoginPage");  // 1

        userSignUpPage = new UserSignUpPanel();
        this.add(userSignUpPage, "studentSignUpPage");  // 2

    }
}
