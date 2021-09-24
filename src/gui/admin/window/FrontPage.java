package gui.admin.window;

import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;

/**
 * 首页板块类
 * @author Jackie
 */
public class FrontPage extends JPanel {

    /**
     * 初始化界面
     */
    public FrontPage(){
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(700, 600));
        this.setLayout(new FormLayout("", ""));
    }

}
