package gui.user.window;

import gui.shared.LayoutColors;
import gui.shared.components.CustomScrollPane;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;

/**
 * 中间面板类
 * @author Jackie
 */
public class CentrePanel extends JTabbedPane {

    /**
     * 滚动面板内面板类
     * @author Jackie
     */
    class InsidePanel extends JPanel {

        public InsidePanel(){
            super();
            setupUI();
        }

        private void setupUI(){
            this.setOpaque(true);
            this.setBackground(Color.WHITE);
            this.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 30));
        }

    }


    private CustomScrollPane recommendPanel;
    private CustomScrollPane chartPanel;
    private CustomScrollPane latestPanel;
    private InsidePanel recommendPage;
    private InsidePanel chartPage;
    private InsidePanel latestPage;

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
        this.setOpaque(true);
        this.setBackground(Color.WHITE);

        recommendPanel = new CustomScrollPane(CustomScrollPane.HORIZONTAL, 900, 250);
        recommendPage = new InsidePanel();
        recommendPanel.setViewportView(recommendPage);
        for (int i = 0; i < 10; i++) {
            BookDisplay b = new BookDisplay(Integer.toString(i));
            recommendPage.add(b);
        }
        this.add(recommendPanel, "推荐");

        chartPanel = new CustomScrollPane(CustomScrollPane.HORIZONTAL, 900, 250);
        chartPage = new InsidePanel();
        chartPanel.setViewportView(chartPage);
        this.add(chartPanel, "排行榜");

        latestPanel = new CustomScrollPane(CustomScrollPane.HORIZONTAL, 900, 250);
        latestPage = new InsidePanel();
        latestPanel.setViewportView(latestPage);
        this.add(latestPanel, "最新");


        // 定制选项卡窗口UI样式
        class TabbedPaneUI extends BasicTabbedPaneUI {

            /**
             * 选项卡宽度为100px
             * @param tabPlacement 选项卡排列方式
             * @param tabIndex 选项卡下标
             * @param metrics 文字矩阵
             * @return 选项卡宽度
             */
            @Override
            protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
                return 100;
            }

            /**
             * 选项卡高度为50px
             * @param tabPlacement 选项卡排列方式
             * @param tabIndex 选项卡下标
             * @param fontHeight 文字高度
             * @return 选项卡高度
             */
            @Override
            protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
                return 50;
            }

            /**
             * 选项卡最大宽度为100px
             * @param tabPlacement 选项卡排列方式
             * @return 选项卡最大宽度
             */
            @Override
            protected int calculateMaxTabWidth(int tabPlacement) {
                return 100;
            }

            /**
             * 选项卡最大高度为100px
             * @param tabPlacement 选项卡排列方式
             * @return 选项卡最大高度
             */
            @Override
            protected int calculateMaxTabHeight(int tabPlacement) {
                return 50;
            }

            /**
             * 选项卡区域高度
             * @param tabPlacement 选项卡排列方式
             * @param horizRunCount 选项卡数量
             * @param maxTabHeight 选项卡最大高度
             * @return 选项卡区域高度
             */
            @Override
            protected int calculateTabAreaHeight(int tabPlacement, int horizRunCount, int maxTabHeight) {
                return maxTabHeight;
            }

            /**
             * 选项卡区域宽度
             * @param tabPlacement 选项卡排列方式
             * @param vertRunCount 选项卡数量
             * @param maxTabWidth 选项卡最大宽度
             * @return 选项卡区域宽度
             */
            @Override
            protected int calculateTabAreaWidth(int tabPlacement, int vertRunCount, int maxTabWidth) {
                return vertRunCount > 0 ? maxTabWidth * vertRunCount : 0;
            }

            /**
             * 绘制选项卡背景
             * @param g 画笔对象
             * @param tabPlacement 选项卡排列方式
             * @param tabIndex 选项卡下标
             * @param x 起始x坐标
             * @param y 起始y坐标
             * @param w 宽度
             * @param h 高度
             * @param isSelected 选项卡是否被选择
             */
            @Override
            protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
                Graphics2D g2d = (Graphics2D)g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                if (isSelected) {
                    setFont(new Font("黑体", Font.BOLD, 22));
                    g2d.setColor(LayoutColors.DARKEST_BLUE);
                    g2d.setStroke(new BasicStroke(5));
                    g2d.drawLine(x + 10, h - 6, x + (w - 10), h - 6);
                }
                else {
                    setFont(new Font("黑体", Font.BOLD, 18));
                }
            }

            /**
             * 绘制选项卡背景
             * @param g 画笔对象
             * @param tabPlacement 选项卡排列方式
             * @param tabIndex 选项卡下标
             * @param rects 选项卡矩形对象
             * @param iconRect 图标矩形对象
             * @param textRect 文字矩形对象
             * @param isSelected 选项卡是否被选择
             */
            @Override
            protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect, boolean isSelected) {
            }

            /**
             * 绘制选项卡背景
             * @param g 画笔对象
             * @param tabPlacement 选项卡排列方式
             * @param selectedIndex 被选择的选项卡下标
             */
            @Override
            protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
            }

            /**
             * 绘制选项卡背景
             * @param g 画笔对象
             * @param tabPlacement 选项卡排列方式
             * @param selectedIndex 被选择的选项卡下标
             * @param x 起始x坐标
             * @param y 起始y坐标
             * @param w 宽度
             * @param h 高度
             */
            @Override
            protected void paintContentBorderBottomEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
            }

            /**
             * 绘制选项卡背景
             * @param g 画笔对象
             * @param tabPlacement 选项卡排列方式
             * @param selectedIndex 被选择的选项卡下标
             * @param x 起始x坐标
             * @param y 起始y坐标
             * @param w 宽度
             * @param h 高度
             */
            @Override
            protected void paintContentBorderLeftEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
            }

            /**
             * 绘制选项卡背景
             * @param g 画笔对象
             * @param tabPlacement 选项卡排列方式
             * @param selectedIndex 被选择的选项卡下标
             * @param x 起始x坐标
             * @param y 起始y坐标
             * @param w 宽度
             * @param h 高度
             */
            @Override
            protected void paintContentBorderRightEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
            }

            /**
             * 绘制选项卡背景
             * @param g 画笔对象
             * @param tabPlacement 选项卡排列方式
             * @param selectedIndex 被选择的选项卡下标
             * @param x 起始x坐标
             * @param y 起始y坐标
             * @param w 宽度
             * @param h 高度
             */
            @Override
            protected void paintContentBorderTopEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
            }

            /**
             * 绘制选项卡背景
             * @param g 画笔对象
             * @param tabPlacement 选项卡排列方式
             * @param tabIndex 选项卡下标
             * @param x 起始x坐标
             * @param y 起始y坐标
             * @param w 宽度
             * @param h 高度
             * @param isSelected 选项卡是否被选择
             */
            @Override
            protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
            }

        }
        this.setUI(new TabbedPaneUI());

    }

}
