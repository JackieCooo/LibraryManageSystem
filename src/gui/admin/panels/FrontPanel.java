package gui.admin.panels;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;

/**
 * 首页板块类
 * @author Jackie
 */
public class FrontPanel extends JPanel {

    private InfoCardPanel infoCardPanel;

    /**
     * 初始化界面
     */
    public FrontPanel(){
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(750, 600));
        this.setLayout(new FormLayout("center:d:grow", "center:d:noGrow,center:d:noGrow"));
        CellConstraints cc = new CellConstraints();
        this.setOpaque(true);
        this.setBackground(Color.WHITE);

        infoCardPanel = new InfoCardPanel();
        this.add(infoCardPanel, cc.xy(1, 1));
    }

}
