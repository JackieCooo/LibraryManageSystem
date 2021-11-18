package gui.frames;

import gui.admin.panels.BookPanel;
import gui.admin.panels.BottomPanel;
import gui.admin.panels.CentralPanel;

import javax.swing.*;
import java.awt.*;

/**
 * 书本窗口类
 * @author Jackie
 */
public class BookFrame extends JDialog {

    private CentralPanel centralPanel;

    /**
     * 初始化界面
     * @param owner 窗口的父级
     * @param model 窗口模式
     */
    public BookFrame(JFrame owner, boolean model){
        super(owner, model);
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setBounds(0, 0, 500, 400);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setVisible(false);

        centralPanel = new CentralPanel();
        centralPanel.setParentPanel(this);
        this.add(centralPanel);
    }

}
