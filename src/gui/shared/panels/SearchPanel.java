package gui.shared.panels;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.user.components.SearchBox;
import gui.user.components.SearchBtn;

import javax.swing.*;
import java.awt.*;

/**
 * 搜索区域类
 * @author Jackie
 */
public class SearchPanel extends JPanel {

    private SearchBox searchBox;
    private SearchBtn searchBtn;

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
        this.setPreferredSize(new Dimension(900, 50));
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
        this.setLayout(new FormLayout("center:d:Grow,center:d:Grow", "center:d:Grow"));
        CellConstraints cc = new CellConstraints();

        searchBox = new SearchBox();
        this.add(searchBox, cc.xy(1, 1, CellConstraints.RIGHT, CellConstraints.CENTER));

        searchBtn = new SearchBtn();
        this.add(searchBtn, cc.xy(2, 1, CellConstraints.LEFT, CellConstraints.CENTER));
    }

}
