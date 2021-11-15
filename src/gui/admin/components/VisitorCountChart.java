package gui.admin.components;

import gui.shared.LayoutColors;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;

/**
 * 访问量图表类
 * @author Jackie
 */
public class VisitorCountChart extends ChartPanel {

    private static DefaultCategoryDataset dataset;
    private static JFreeChart chart;

    static {
        setupData();
        setupChart();
    }

    /**
     * 初始化界面
     * @param data 图表数据
     */
    public VisitorCountChart(Object[][] data) {
        super(chart);
        this.setupUI();
        this.setData(data);
    }

    /**
     * 设置图表数据
     * @param data 图表数据
     */
    public void setData(Object[][] data){
        for(Object[] i : data){
            dataset.addValue((Integer)i[0], (String)i[1], (String)i[2]);
        }
    }

    /**
     * 初始化界面属性
     */
    private void setupUI() {
        this.setPreferredSize(new Dimension(730, 200));
    }

    /**
     * 初始化图表数据
     */
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

    /**
     * 初始化图标
     */
    private static void setupChart() {
        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setTickLabelFont(new Font("微软雅黑", Font.PLAIN, 14));

        ValueAxis valueAxis = new NumberAxis();
        valueAxis.setTickLabelFont(new Font("微软雅黑", Font.PLAIN, 14));

        LineAndShapeRenderer renderer = new LineAndShapeRenderer(true, false);
        renderer.setSeriesPaint(0, LayoutColors.DARK_BLUE);
        renderer.setSeriesStroke(0, new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

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
