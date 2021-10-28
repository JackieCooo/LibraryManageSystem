package gui.frames;

import gui.user.panels.MainPanel;
import gui.shared.components.TopPanel;

import javax.swing.*;
import java.awt.*;

/**
 * 用户窗户类
 * @author Jackie
 */
public class UserFrame extends JFrame {

    private MainPanel mainPanel;
    private TopPanel topPanel;

    /**
     * 初始化界面
     */
    public UserFrame(){
        super();
        setupUI();
    }

    /**
     * 获取主窗口
     * @return 返回主窗口
     */
    public MainPanel getMainWindow() {
        return mainPanel;
    }

    /**
     * 获取顶部面板
     * @return 返回顶部面板
     */
    public TopPanel getTopPanel() {
        return topPanel;
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setBounds(0, 0, 900, 675);

        topPanel = new TopPanel();
        topPanel.setParentPanel(this);
        this.add(topPanel, BorderLayout.NORTH);

        mainPanel = new MainPanel();
        mainPanel.setParentPanel(this);
        this.add(mainPanel);

        this.setResizable(false);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
