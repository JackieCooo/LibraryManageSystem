package gui.frames;

import gui.user.window.StudentMainWindow;

import javax.swing.*;

/**
 * 用户窗户类
 * @author Jackie
 */
public class UserFrame extends JFrame {

    StudentMainWindow studentMainWindow;

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
        studentMainWindow = new StudentMainWindow();
        this.add(studentMainWindow);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

}
