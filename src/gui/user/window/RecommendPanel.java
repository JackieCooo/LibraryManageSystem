package gui.user.window;

import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;

/**
 * 推荐板块类
 * @author Jackie
 */
public class RecommendPanel {

    private JPanel recommendPanel;

    /**
     * 初始化界面
     */
    public RecommendPanel(){
        recommendPanel = new JPanel();
        recommendPanel.setLayout(new FormLayout("", ""));
    }

    /**
     * 获取推荐板块部件
     * @return JPanel
     */
    public JPanel getRecommendPanel(){
        return recommendPanel;
    }

}
