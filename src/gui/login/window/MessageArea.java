package gui.login.window;

import javax.swing.*;
import java.awt.*;

/**
 * 反馈信息区域类
 * @author Jackie
 */
public class MessageArea extends JLabel {

    /**
     * 初始化类
     */
    MessageArea(){
        super();
        setupUI();
    }

    /**
     * 初始化属性
     */
    private void setupUI(){
        this.setHorizontalAlignment(0);
        this.setHorizontalTextPosition(0);
        this.setPreferredSize(new Dimension(300, 25));
        this.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        this.setText("test");
    }

    /**
     * 显示反馈信息
     * @param mes 需要显示的反馈信息
     */
    public void displayMes(String mes){
        this.setText(mes);
    }
    
}
