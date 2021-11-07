package gui.admin.panels;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.admin.components.InfoCard;

import javax.swing.*;
import java.awt.*;

/**
 * 信息卡片面板类
 * @author Jackie
 */
public class InfoCardPanel extends JPanel {

    private InfoCard peopleCard;
    private InfoCard booksCard;
    private InfoCard borrowCard;

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
        this.setPreferredSize(new Dimension(750, 150));
        this.setLayout(new FormLayout("right:d:grow,center:30px:noGrow,center:d:noGrow,center:30px:noGrow,left:d:grow", "center:d:grow"));
        this.setOpaque(false);
        CellConstraints cc = new CellConstraints();

        peopleCard = new InfoCard("icons/People_30px.png", "访问量");
        this.add(peopleCard, cc.xy(1, 1));

        booksCard = new InfoCard("icons/Books_30px.png", "图书总数");
        this.add(booksCard, cc.xy(3, 1));

        borrowCard = new InfoCard("icons/Borrow_30px.png", "借阅量");
        this.add(borrowCard, cc.xy(5, 1));
    }

}
