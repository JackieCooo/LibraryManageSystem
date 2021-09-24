package gui.frames;

import gui.admin.window.LeftSidePanel;
import gui.admin.window.MainWindow;
import gui.shared.TopPanel;

import javax.swing.*;
import java.awt.*;

/**
 * 管理窗口类
 * @author Jackie
 */
public class AdminFrame extends JFrame{

    private MainWindow mainWindow;
    private TopPanel topPanel;
    private LeftSidePanel leftSidePanel;

    /**
     * 初始化界面
     */
    public AdminFrame(){
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
        leftSidePanel = new LeftSidePanel();
        this.add(leftSidePanel, BorderLayout.WEST);
        leftSidePanel.setParentPanel(this);
        mainWindow = new MainWindow();
        this.add(mainWindow, BorderLayout.EAST);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setUndecorated(true);
        this.pack();
        this.setVisible(true);
    }

    public JPanel getMainWindow(){
        return mainWindow;
    }

}
