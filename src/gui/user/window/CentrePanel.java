package gui.user.window;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * 中间板块类
 * @author Jackie
 */
public class CentrePanel extends JTabbedPane{

    private JScrollPane recommendPage;
    private JScrollPane bookChartPage;
    private JScrollPane latestBookPage;

    private RecommendPanel recommendPanel;
    private BookChartPanel bookChartPanel;
    private LatestBookPanel latestBookPanel;

    /**
     * 初始化界面
     */
    public CentrePanel(){
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(900, 325));
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        recommendPage = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.addTab("推荐", recommendPage);
        recommendPanel = new RecommendPanel();
        recommendPage.setViewportView(recommendPanel);
        bookChartPage = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.addTab("排行榜", bookChartPage);
        bookChartPanel = new BookChartPanel();
        bookChartPage.setViewportView(bookChartPanel);
        latestBookPage = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.addTab("最新", latestBookPage);
        latestBookPanel = new LatestBookPanel();
        latestBookPage.setViewportView(latestBookPanel);
    }

}
