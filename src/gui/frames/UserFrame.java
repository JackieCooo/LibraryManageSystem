package gui.frames;

import gui.user.window.MainWindow;
import gui.user.window.TopPanel;

import javax.swing.*;
import java.awt.*;

/**
 * 用户窗户类
 * @author Jackie
 */
public class UserFrame extends JFrame {

    MainWindow mainWindow;
    TopPanel topPanel;

    /**
     * 初始化界面
     */
    public UserFrame(){
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setBounds(100, 100, 900, 675);
        topPanel = new TopPanel();
        this.add(topPanel, BorderLayout.NORTH);
        mainWindow = new MainWindow();
        this.add(mainWindow);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setUndecorated(true);
        this.pack();
        this.setVisible(true);
    }

}
