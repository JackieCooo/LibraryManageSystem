package gui.frames;

import gui.admin.panels.LeftSidePanel;
import gui.admin.panels.MainPanel;
import gui.admin.panels.TopPanel;

import javax.swing.*;
import java.awt.*;

/**
 * 管理窗口类
 * @author Jackie
 */
public class AdminFrame extends JFrame{

    private MainPanel mainPanel;
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
        this.setBounds(0, 0, 900, 675);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);

        topPanel = new TopPanel();
        topPanel.setParentPanel(this);
        this.add(topPanel, BorderLayout.NORTH);

        leftSidePanel = new LeftSidePanel();
        leftSidePanel.setParentPanel(this);
        this.add(leftSidePanel, BorderLayout.WEST);

        mainPanel = new MainPanel();
        this.add(mainPanel, BorderLayout.EAST);

        this.setVisible(true);
    }

    public MainPanel getMainWindow(){
        return mainPanel;
    }

}
