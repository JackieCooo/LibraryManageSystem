package gui.user.window;

import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;

/**
 * 新书板块类
 * @author Jackie
 */
public class LatestBookPanel extends JPanel{

    /**
     * 初始化界面
     */
    public LatestBookPanel(){
        super();
        setupUI();
    }

    /**
     * 初始化界面
     */
    private void setupUI(){
        this.setLayout(new FormLayout("", ""));
    }

}
