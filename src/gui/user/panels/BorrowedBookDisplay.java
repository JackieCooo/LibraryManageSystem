package gui.user.panels;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;

/**
 * 借阅图书展示类
 * @author Jackie
 */
class BorrowedBookDisplay extends JPanel {

    /**
     * 自定义进度条类
     * @author Jackie
     */
    class CustomizedProgressBar extends JProgressBar {

        private final int WIDTH = 10;
        private final int HEIGHT = 200;

        /**
         * 初始化界面
         */
        public CustomizedProgressBar(){
            this(JProgressBar.VERTICAL, 0, 100);
        }

        /**
         * 初始化界面
         * @param orient 进度条方向
         * @param min 进度条最小值
         * @param max 进度条最大值
         */
        public CustomizedProgressBar(int orient, int min, int max){
            super(orient, min, max);
            setupUI();
        }

        /**
         * 初始化界面属性
         */
        private void setupUI(){
            this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
            this.setBorderPainted(false);
            this.setStringPainted(false);
            this.setValue(10);

            // 定制进度条UI
            class ProgressBarUI extends BasicProgressBarUI {

                /**
                 * 绘制确定进度条
                 * @param g 画笔对象
                 * @param c 组件对象
                 */
                @Override
                protected void paintDeterminate(Graphics g, JComponent c) {
                    if (!(g instanceof Graphics2D)) {
                        return;
                    }

                    Insets b = progressBar.getInsets(); // area for border
                    int barRectWidth = progressBar.getWidth() - (b.right + b.left);
                    int barRectHeight = progressBar.getHeight() - (b.top + b.bottom);

                    if (barRectWidth <= 0 || barRectHeight <= 0) {
                        return;
                    }

                    int cellLength = getCellLength();
                    int cellSpacing = getCellSpacing();
                    // amount of progress to draw
                    int amountFull = getAmountFull(b, barRectWidth, barRectHeight);  // 获取进度条应该被填充的高度

                    Graphics2D g2 = (Graphics2D)g;
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    if ((double)amountFull / (double)barRectHeight > 2.0 / 3.0) {
                        g2.setColor(Color.GREEN);
                    }
                    else if ((double)amountFull / (double)barRectHeight < 1.0 / 6.0) {
                        g2.setColor(Color.RED);
                    }
                    else{
                        g2.setColor(Color.ORANGE);
                    }

                    if (progressBar.getOrientation() == JProgressBar.HORIZONTAL) {
                        // draw the cells
                        if (cellSpacing == 0 && amountFull > 0) {
                            // draw one big Rect because there is no space between cells
                            g2.setStroke(new BasicStroke((float)barRectHeight, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
                        } else {
                            // draw each individual cell
                            g2.setStroke(new BasicStroke((float)barRectHeight, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0.f, new float[] { cellLength, cellSpacing }, 0.f));
                        }

                        if (c.getComponentOrientation().isLeftToRight()) {
                            g2.drawLine(b.left, (barRectHeight/2) + b.top, amountFull + b.left, (barRectHeight/2) + b.top);
                        } else {
                            g2.drawLine((barRectWidth + b.left), (barRectHeight/2) + b.top, barRectWidth + b.left - amountFull, (barRectHeight/2) + b.top);
                        }

                    }
                    else {  // VERTICAL
                        // draw the cells
                        if (cellSpacing == 0 && amountFull > 0) {
                            // draw one big Rect because there is no space between cells
                            g2.setStroke(new BasicStroke((float)barRectWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
                        }
                        else {
                            // draw each individual cell
                            g2.setStroke(new BasicStroke((float)barRectWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 0f, new float[] { cellLength, cellSpacing }, 0f));
                        }

                        g2.drawLine(barRectWidth/2 + b.left, b.top + barRectHeight - 3, barRectWidth/2 + b.left, b.top + barRectHeight - amountFull + 3);
                    }
                }
            }
            ProgressBarUI ui = new ProgressBarUI();
            this.setUI(ui);
        }

    }

    private BookDisplay bookDisplay;
    private CustomizedProgressBar progressBar;

    /**
     * 初始化界面
     */
    public BorrowedBookDisplay(){
        super();
        setupUI();
    }

    /**
     * 设置进度
     * @param val 进度
     */
    public void setProgress(int val){
        progressBar.setValue(val);
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(170, 200));
        this.setLayout(new FormLayout("center:d:noGrow,center:10px:noGrow,center:d:noGrow", "center:d:noGrow"));
        CellConstraints cc = new CellConstraints();
        bookDisplay = new BookDisplay("pics/test.png");
        this.add(bookDisplay, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        progressBar = new CustomizedProgressBar(JProgressBar.VERTICAL, 0, 100);
        this.add(progressBar, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
    }

}
