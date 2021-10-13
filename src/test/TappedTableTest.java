package test;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;

public class TappedTableTest {

    public static void main(String[] args) {

        class CentrePanel extends JTabbedPane{

            private JPanel recommendPage;
            private JPanel bookChartPage;
            private JPanel latestBookPage;

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
                recommendPage = new JPanel();
                recommendPage.add(new JLabel("label1"));
                this.addTab("推荐", recommendPage);
                bookChartPage = new JPanel();
                bookChartPage.add(new JLabel("label2"));
                this.addTab("排行榜", bookChartPage);
                latestBookPage = new JPanel();
                latestBookPage.add(new JLabel("label3"));
                this.addTab("最新", latestBookPage);

                UIDefaults tappedPaneDefaults = new UIDefaults();
                tappedPaneDefaults.put("TabbedPane:TabbedPaneTab.backgroundPainter", (Painter<JComponent>)(g2d, c, w, h) ->{
                    g2d.setColor(Color.BLUE);
                    g2d.fillRect(0, 0, w, h);
                });
                this.putClientProperty("Nimbus.Overrides", tappedPaneDefaults);
                this.putClientProperty("Nimbus.Overrides.InheritDefaults", false);
            }

        }

        for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(laf.getName())) {
                try {
                    UIManager.setLookAndFeel(laf.getClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 900, 675);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        CentrePanel centrePanel = new CentrePanel();
        panel.add(centrePanel);
        frame.add(panel);
        frame.setVisible(true);
    }

}
