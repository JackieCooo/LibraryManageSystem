package gui.admin.components;

import gui.shared.LayoutColors;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarPainter;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.awt.geom.RectangularShape;

/**
 * 图书借阅分布图表类
 * @author Jackie
 */
public class BorrowCountChart extends ChartPanel {

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
    public BorrowCountChart(Object[][] data) {
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
    }

    /**
     * 初始化图标
     */
    private static void setupChart() {
        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setTickLabelFont(new Font("微软雅黑", Font.PLAIN, 14));

        ValueAxis valueAxis = new NumberAxis();
        valueAxis.setTickLabelFont(new Font("微软雅黑", Font.PLAIN, 14));

        BarRenderer renderer = new BarRenderer();
        renderer.setSeriesPaint(0, LayoutColors.DARK_BLUE);
        renderer.setDrawBarOutline(false);
        renderer.setShadowVisible(false);

        // 定制柱形的绘制模式
        class MyBarPainter implements BarPainter {

            /**
             * 绘制柱形
             * @param g2d 画笔对象
             * @param renderer 渲染器对象
             * @param row 行
             * @param column 列
             * @param shape 形状对象
             * @param edge 正方形边对象
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
             * 不绘制柱形阴影
             * @param g2d 画笔对象
             * @param renderer 渲染器对象
             * @param row 行
             * @param column 列
             * @param shape 形状对象
             * @param edge 正方形边对象
             * @param pegShadow 未知作用
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

        chart = new JFreeChart("借阅分布", new Font("黑体", Font.BOLD, 20), plot, false);
        chart.setBackgroundPaint(Color.WHITE);
    }
}
