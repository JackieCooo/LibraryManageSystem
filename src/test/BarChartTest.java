package test;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarPainter;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.chart.urls.StandardCategoryURLGenerator;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RectangularShape;

public class BarChartTest {

    public static void main(String[] args) {

        for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(laf.getName())) {
                try {
                    UIManager.setLookAndFeel(laf.getClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        class Chart extends ChartPanel {

            private static DefaultCategoryDataset dataset;
            private static JFreeChart chart;

            static {
                setupData();
                setupChart();
            }

            public Chart(Object[][] data) {
                super(chart);
                this.setupUI();
                this.setData(data);
            }

            public void setData(Object[][] data){
                for(Object[] i : data){
                    dataset.addValue((Integer)i[0], (String)i[1], (String)i[2]);
                }
            }

            private void setupUI() {
                this.setPreferredSize(new Dimension(730, 200));
            }

            private static void setupData() {
                dataset = new DefaultCategoryDataset();
            }

            private static void setupChart() {
                CategoryAxis categoryAxis = new CategoryAxis();
                categoryAxis.setTickLabelFont(new Font("????????????", Font.PLAIN, 14));

                ValueAxis valueAxis = new NumberAxis();
                valueAxis.setTickLabelFont(new Font("????????????", Font.PLAIN, 14));

                BarRenderer renderer = new BarRenderer();
                renderer.setSeriesPaint(0, Color.BLUE);
                renderer.setDrawBarOutline(false);
                renderer.setShadowVisible(false);

                // ???????????????????????????
                class MyBarPainter implements BarPainter {

                    /**
                     * ????????????
                     * @param g2d ????????????
                     * @param renderer ???????????????
                     * @param row ???
                     * @param column ???
                     * @param shape ????????????
                     * @param edge ??????????????????
                     */
                    @Override
                    public void paintBar(Graphics2D g2d, BarRenderer renderer, int row, int column, RectangularShape shape, RectangleEdge edge) {
                        Color barColor = (Color)renderer.getItemPaint(row, column);
                        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        g2d.setColor(barColor);
                        Rectangle rect = shape.getBounds();
                        g2d.fillRoundRect(rect.x, rect.y, rect.width, rect.height, 15, 15);
                    }

                    /**
                     * ?????????????????????
                     * @param g2d ????????????
                     * @param renderer ???????????????
                     * @param row ???
                     * @param column ???
                     * @param shape ????????????
                     * @param edge ??????????????????
                     * @param pegShadow ????????????
                     */
                    @Override
                    public void paintBarShadow(Graphics2D g2d, BarRenderer renderer, int row, int column, RectangularShape shape, RectangleEdge edge, boolean pegShadow) {
                    }
                }
                renderer.setBarPainter(new MyBarPainter());

                CategoryPlot plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer);
                plot.setOrientation(PlotOrientation.VERTICAL);
                plot.setBackgroundPaint(Color.WHITE);
                plot.setOutlineVisible(false);
                plot.setDomainGridlinesVisible(false);
                plot.setRangeGridlinesVisible(false);

                chart = new JFreeChart("????????????", new Font("??????", Font.BOLD, 20), plot, false);
                chart.setBackgroundPaint(Color.WHITE);
            }
        }

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 800, 600);
        Object[][] data = {
                {51, "", "????????????"},
                {76, "", "????????????"},
                {77, "", "??????"},
                {53, "", "?????????"},
                {27, "", "????????????"},
                {99, "", "????????????"},
                {80, "", "????????????"},
        };
        Chart c = new Chart(data);
        JPanel panel = new JPanel();
        panel.add(c);
        frame.add(panel);
        frame.setVisible(true);
    }

}
