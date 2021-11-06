package gui.admin.panels;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;

/**
 * 信息卡片面板类
 * @author Jackie
 */
public class InfoCardPanel extends JPanel {

    /**
     * 初始化界面
     */
    public InfoCardPanel(){
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(400, 200));
        this.setLayout(new FormLayout("", ""));
        CellConstraints cc = new CellConstraints();
    }

}
