package gui.frames;

import gui.login.panels.LoginTopPanel;
import gui.login.panels.MainPanel;

import javax.swing.*;
import java.awt.*;

/**
 * 登录主窗口类
 * @author Jackie
 */
public class LoginFrame extends JFrame {

    private MainPanel mainPanel;
    private LoginTopPanel topPanel;

    public LoginFrame(){
        super();
        setupUI();
    }

    private void setupUI(){
        this.setBounds(100, 100, 400, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setUndecorated(true);

        topPanel = new LoginTopPanel();
        this.add(topPanel, BorderLayout.NORTH);

        mainPanel = new MainPanel();
        this.add(mainPanel);

        this.setVisible(true);
    }

}
