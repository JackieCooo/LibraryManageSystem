package gui.admin.panels;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.admin.components.DialogCloseBtn;
import gui.frames.LoginFrame;

import javax.swing.*;
import java.awt.*;

/**
 * 书本信息添加顶部面板类
 * @author Jackie
 */
public class DialogTopPanel extends JPanel {

    private LoginFrame parent;
    private DialogCloseBtn closeBtn;

    /**
     * 初始化界面
     */
    public DialogTopPanel(){
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(400, 30));
        this.setLayout(new FormLayout("right:d:grow,center:5px:noGrow", "center:d:grow"));
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
        CellConstraints cc = new CellConstraints();

        closeBtn = new DialogCloseBtn();
        this.add(closeBtn, cc.xy(1, 1));
    }
}
