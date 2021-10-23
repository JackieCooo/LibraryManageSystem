package gui.user.window;

import gui.shared.components.CustomScrollPane;

import javax.swing.*;
import java.awt.*;

/**
 * 我的借阅窗口类
 * @author Jackie
 */
public class MyBorrowPanel extends CustomScrollPane {

    private JPanel panel;

    /**
     * 初始化界面
     */
    public MyBorrowPanel(){
        super(CustomScrollPane.VERTICAL, 900, 600);
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        panel = new JPanel();
        panel.setOpaque(true);
        panel.setBackground(Color.WHITE);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 30));
        this.setViewportView(panel);
    }

}
