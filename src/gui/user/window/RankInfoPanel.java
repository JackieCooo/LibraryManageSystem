package gui.user.window;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;

/**
 * 书本排名信息框类
 * @author Jackie
 */
public class RankInfoPanel extends JPanel {

    private JLabel rankNum;
    private JLabel rankChangeIcon;
    private JLabel rankChangeNum;

    /**
     * 初始化界面
     * @param rank 排名
     * @param change 排名变化（正数为上升，负数为下降）
     */
    public RankInfoPanel(int rank, int change){
        super();
        setupUI();
        setRankInfo(rank, change);
    }

    /**
     * 初始化界面
     */
    public RankInfoPanel(){
        super();
        setupUI();
    }

    /**
     * 设置部件属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(50, 200));
        this.setLayout(new FormLayout("center:d:noGrow", "center:d:noGrow,center:10px:noGrow,center:d:noGrow,center:d:noGrow"));
        CellConstraints cc = new CellConstraints();
        rankNum = new JLabel();
        rankNum.setPreferredSize(new Dimension(40, 40));
        rankNum.setText("1");
        this.add(rankNum, cc.xy(1, 1));
        rankChangeIcon = new JLabel();
        rankChangeIcon.setPreferredSize(new Dimension(40, 40));
        rankChangeIcon.setText("2");
        this.add(rankChangeIcon, cc.xy(1, 3));
        rankChangeNum = new JLabel();
        rankChangeNum.setPreferredSize(new Dimension(40, 20));
        rankChangeNum.setText("3");
        this.add(rankChangeNum, cc.xy(1, 4));
    }

    /**
     * 函数说明
     *
     * @param rank 排名
     * @param rankChange 排名变化（正数为上升，负数为下降）
     */
    public void setRankInfo(int rank, int rankChange){

    }

}
