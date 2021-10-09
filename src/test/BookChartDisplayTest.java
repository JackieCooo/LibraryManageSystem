package test;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.user.window.BookDisplay;
import gui.user.window.RankInfoPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BookChartDisplayTest {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        class BookDisplay extends JButton {

            private BufferedImage img;
            private final int WIDTH = 150;
            private final int HEIGHT = 200;

            /**
             * 初始化界面
             */
            public BookDisplay(String path){
                super();
                setupImg(path);
                setupUI();
            }

            @Override
            public void paint(Graphics g) {
                Graphics2D g2d = (Graphics2D)g;
                g2d.setColor(Color.BLUE);
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//                g2d.setComposite(AlphaComposite.Src);
                g2d.fillRoundRect(0, 0, WIDTH, HEIGHT, 20, 20);

//                g2d.drawImage(img, null, 0, 0);
            }

            private void setupImg(String path){
                try {
                    img = ImageIO.read(new File(path));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            /**
             * 设置部件的属性
             */
            private void setupUI(){
                this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
            }

        }

        class RankInfoPanel extends JPanel {

            private JLabel rankNum;
            private JLabel rankChangeIcon;
            private JLabel rankChangeNum;

            /**
             * 初始化界面
             * @param rank 排名
             * @param change 排名变化（正数为上升，负数为下降）
             */
            public RankInfoPanel(int rank, int change){
                super();
                setupUI();
                setRankInfo(rank, change);
            }

            /**
             * 初始化界面
             */
            public RankInfoPanel(){
                super();
                setupUI();
            }

            /**
             * 设置部件属性
             */
            private void setupUI(){
                this.setPreferredSize(new Dimension(50, 200));
                this.setLayout(new FormLayout("center:d:noGrow", "center:d:noGrow,center:10px:noGrow,center:d:noGrow,center:d:noGrow"));
                CellConstraints cc = new CellConstraints();
                rankNum = new JLabel();
                rankNum.setPreferredSize(new Dimension(40, 40));
                rankNum.setText("1");
                this.add(rankNum, cc.xy(1, 1));
                rankChangeIcon = new JLabel();
                rankChangeIcon.setPreferredSize(new Dimension(40, 40));
                rankChangeIcon.setText("2");
                this.add(rankChangeIcon, cc.xy(1, 3));
                rankChangeNum = new JLabel();
                rankChangeNum.setPreferredSize(new Dimension(40, 20));
                rankChangeNum.setText("3");
                this.add(rankChangeNum, cc.xy(1, 4));
            }

            /**
             * 函数说明
             *
             * @param rank 排名
             * @param rankChange 排名变化（正数为上升，负数为下降）
             */
            public void setRankInfo(int rank, int rankChange){

            }

        }

        class BookChartDisplay extends JPanel {

            private RankInfoPanel rankInfo;
            private BookDisplay book;

            /**
             * 初始化界面
             */
            public BookChartDisplay(String path){
                super();
                setupUI(path);
            }

            /**
             * 设置界面属性
             * @param path 图片路径
             */
            private void setupUI(String path){
                this.setPreferredSize(new Dimension(200, 200));
                this.setLayout(new FormLayout("center:d:noGrow,center:d:noGrow", "center:d:noGrow"));
                CellConstraints cc = new CellConstraints();
                rankInfo = new RankInfoPanel(1, 0);
                this.add(rankInfo, cc.xy(1, 1));
                book = new BookDisplay(path);
                this.add(book, cc.xy(2, 1));
            }

        }

        BookChartDisplay bookChartDisplay = new BookChartDisplay("");

        JPanel panel = new JPanel();
        panel.add(bookChartDisplay);

        frame.add(panel);
        frame.setVisible(true);

    }

}
