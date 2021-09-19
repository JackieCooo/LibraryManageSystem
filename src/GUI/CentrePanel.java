package GUI;

import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CentrePanel {

    private JScrollPane recommendPage;
    private JScrollPane bookChartPage;
    private JScrollPane latestBookPage;
    private JTabbedPane centrePanel;

    private RecommendPanel recommendPanel;
    private BookChartPanel bookChartPanel;
    private LatestBookPanel latestBookPanel;

    {setupUI();}

    private void setupUI(){
        centrePanel = new JTabbedPane();
        centrePanel.setPreferredSize(new Dimension(900, 325));
        centrePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        recommendPage = new JScrollPane();
        centrePanel.addTab("推荐", recommendPage);
        recommendPanel = new RecommendPanel();
        recommendPage.setViewportView(recommendPanel.getRecommendPanel());
        bookChartPage = new JScrollPane();
        centrePanel.addTab("排行榜", bookChartPage);
        bookChartPanel = new BookChartPanel();
        bookChartPage.setViewportView(bookChartPanel.getBookChartPanel());
        latestBookPage = new JScrollPane();
        centrePanel.addTab("最新", latestBookPage);
        latestBookPanel = new LatestBookPanel();
        latestBookPage.setViewportView(latestBookPanel.getLatestBookPanel());
    }

    JTabbedPane getCentrePanel(){
        return centrePanel;
    }

}
