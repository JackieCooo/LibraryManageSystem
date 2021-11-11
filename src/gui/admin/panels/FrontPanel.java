package gui.admin.panels;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.admin.components.VisitorCountChart;

import javax.swing.*;
import java.awt.*;

/**
 * 首页板块类
 * @author Jackie
 */
public class FrontPanel extends JPanel {

    private InfoCardPanel infoCardPanel;
    private VisitorCountChart chart1;

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
        this.setLayout(new FormLayout("center:d:grow", "center:d:noGrow,center:d:noGrow,center:d:noGrow"));
        CellConstraints cc = new CellConstraints();
        this.setOpaque(true);
        this.setBackground(Color.WHITE);

        infoCardPanel = new InfoCardPanel();
        this.add(infoCardPanel, cc.xy(1, 1));

        Object[][] data = {
                {140, "", "1月"},
                {57, "", "2月"},
                {95, "", "3月"},
                {333, "", "4月"},
                {293, "", "5月"},
                {285, "", "6月"},
                {519, "", "7月"},
                {109, "", "8月"},
                {167, "", "9月"},
                {576, "", "10月"},
                {363, "", "11月"},
                {551, "", "12月"}
        };
        chart1 = new VisitorCountChart(data);
        this.add(chart1, cc.xy(1, 2));
    }

}
