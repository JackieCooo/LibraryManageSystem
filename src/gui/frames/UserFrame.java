package gui.frames;

import gui.user.window.MainWindow;
import gui.shared.TopPanel;

import javax.swing.*;
import java.awt.*;

/**
 * 用户窗户类
 * @author Jackie
 */
public class UserFrame extends JFrame {

    private MainWindow mainWindow;
    private TopPanel topPanel;

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
        this.setBounds(0, 0, 900, 675);
        topPanel = new TopPanel();
        topPanel.setParentPanel(this);
        this.add(topPanel, BorderLayout.NORTH);
        mainWindow = new MainWindow();
        this.add(mainWindow);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
