package gui.frames;

import gui.login.window.LoginWindow;

import javax.swing.*;
import java.awt.*;

/**
 * 登录主窗口类
 * @author Jackie
 */
public class LoginFrame extends JFrame {

    private LoginWindow loginWindow;

    public LoginFrame(){
        super();
        setupUI();
    }

    private void setupUI(){
        this.setBounds(100, 100, 400, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new CardLayout(0, 0));

        loginWindow = new LoginWindow();
        this.add(loginWindow);
        this.setVisible(true);
    }

}
