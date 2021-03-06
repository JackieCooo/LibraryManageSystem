package test;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class LineChartTest {

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
/*
                dataset.addValue(140, "", "1月");
                dataset.addValue(57, "", "2月");
                dataset.addValue(95, "", "3月");
                dataset.addValue(333, "", "4月");
                dataset.addValue(293, "", "5月");
                dataset.addValue(285, "", "6月");
                dataset.addValue(519, "", "7月");
                dataset.addValue(109, "", "8月");
                dataset.addValue(167, "", "9月");
                dataset.addValue(576, "", "10月");
                dataset.addValue(363, "", "11月");
                dataset.addValue(551, "", "12月");
*/
            }

            private static void setupChart() {
                CategoryAxis categoryAxis = new CategoryAxis();
                categoryAxis.setTickLabelFont(new Font("微软雅黑", Font.PLAIN, 14));

                ValueAxis valueAxis = new NumberAxis();
                valueAxis.setTickLabelFont(new Font("微软雅黑", Font.PLAIN, 14));

/*
                LineAndShapeRenderer renderer = new LineAndShapeRenderer(true, false);
                renderer.setSeriesPaint(0, Color.BLUE);
                renderer.setSeriesStroke(0, new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
*/
                class MyRenderer extends LineAndShapeRenderer {

                    public MyRenderer() {
                        super(true, false);
                        this.setSeriesPaint(0, Color.BLUE);
                        this.setSeriesStroke(0, new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                    }
                }
                MyRenderer renderer = new MyRenderer();

                CategoryPlot plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer);
                plot.setBackgroundPaint(Color.WHITE);
                plot.setOutlineVisible(false);
                plot.setDomainGridlinesVisible(false);
                plot.setRangeGridlinesVisible(false);
                plot.setOrientation(PlotOrientation.VERTICAL);

                chart = new JFreeChart("访问量", new Font("黑体", Font.BOLD, 20), plot, false);
                chart.setBackgroundPaint(Color.WHITE);
            }
        }

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 800, 600);
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
        Chart c = new Chart(data);
        JPanel panel = new JPanel();
        panel.add(c);
        frame.add(panel);
        frame.setVisible(true);
    }

}
