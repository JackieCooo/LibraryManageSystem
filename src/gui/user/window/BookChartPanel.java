package gui.user.window;

import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;

/**
 * 排行榜板块类
 * @author Jackie
 */
public class BookChartPanel {

    private JPanel bookChartPanel;

    /**
     * 初始化页面
     */
    public BookChartPanel(){
        bookChartPanel = new JPanel();
        bookChartPanel.setLayout(new FormLayout("", ""));
    }

    /**
     * 获取排行榜板块部件
     * @return JPanel
     */
    public JPanel getBookChartPanel(){
        return bookChartPanel;
    }

}
