package gui.user.window;

import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;

/**
 * 新书板块类
 * @author Jackie
 */
public class LatestBookPanel {
    
    private JPanel latestBookPanel;

    /**
     * 初始化界面
     */
    public LatestBookPanel(){
        latestBookPanel = new JPanel();
        latestBookPanel.setLayout(new FormLayout("", ""));
    }

    /**
     * 获取新书板块部件
     * @return JPanel
     */
    public JPanel getLatestBookPanel(){
        return latestBookPanel;
    }

}
