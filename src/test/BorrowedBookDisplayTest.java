package test;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;

class BorrowedBookDisplay extends JPanel {

    class CustomizedProgressBar extends JProgressBar {

        private final int WIDTH = 10;
        private final int HEIGHT = 200;

        public CustomizedProgressBar(){
            this(JProgressBar.VERTICAL, 0, 100);
        }

        public CustomizedProgressBar(int orient, int min, int max){
            super(orient, min, max);
            setupUI();
        }

        private void setupUI(){
            this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
            this.setBorderPainted(false);
            this.setStringPainted(false);
            this.setValue(10);

            class ProgressBarUI extends BasicProgressBarUI {

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

    public BorrowedBookDisplay(){
        this(0);
    }

    public BorrowedBookDisplay(int val){
        super();
        setupUI();
    }

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


public class BorrowedBookDisplayTest {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        BorrowedBookDisplay display = new BorrowedBookDisplay();
        panel.add(display);
        frame.add(panel);
        frame.setVisible(true);
    }

}
