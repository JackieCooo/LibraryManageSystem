package gui.shared.components;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;

/**
 * 搜索区域类
 * @author Jackie
 */
public class SearchPanel extends JPanel {

    private JTextField searchBox;
    private JButton searchBtn;

    /**
     * 初始化界面
     */
    public SearchPanel(){
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setLayout(new FormLayout("center:d:Grow,center:d:Grow", "center:d:noGrow"));
        CellConstraints cc = new CellConstraints();
        searchBox = new JTextField();
        searchBox.setPreferredSize(new Dimension(400, 40));
        this.add(searchBox, cc.xy(1, 1, CellConstraints.RIGHT, CellConstraints.CENTER));
        searchBtn = new JButton();
        searchBtn.setPreferredSize(new Dimension(40, 40));
        this.add(searchBtn, cc.xy(2, 1, CellConstraints.LEFT, CellConstraints.CENTER));
    }

}
