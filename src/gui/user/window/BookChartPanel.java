package gui.user.window;

import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;

/**
 * 排行榜板块类
 * @author Jackie
 */
public class BookChartPanel extends JPanel{

    /**
     * 初始化页面
     */
    public BookChartPanel(){
        super();
        setupUI();
    }

    /**
     * 设置界面属性
     */
    private void setupUI(){
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 45));
        for (int i = 0; i < 10; i++) {
            BookChartDisplay b = new BookChartDisplay();
            this.add(b);
        }
    }

}
