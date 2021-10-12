package test;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.shared.LayoutColors;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
                setupListener();
            }

            /**
             * 绘制书本缩略图
             * @param g 图像对象
             */
            @Override
            public void paint(Graphics g) {
                Graphics2D g2d = (Graphics2D)g;
                g2d.setColor(Color.BLUE);
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                img = setRadius(img, 15);
                g2d.drawImage(img, 0, 0, null);
            }

            /**
             * 图片设置圆角
             * @param srcImage 原图片
             * @param radius 圆角半径
             * @return 新的图片对象
             */
            private BufferedImage setRadius(BufferedImage srcImage, int radius){

//                if (srcImage.getWidth(null) > width || srcImage.getHeight(null) > height)
//                {
//                    // 图片过大，进行缩放
//                    ImageIcon imageIcon = new ImageIcon();
//                    imageIcon.setImage(srcImage.getScaledInstance(width, height, Image.SCALE_SMOOTH));
//                    srcImage = imageIcon.getImage();
//                }

                BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
                Graphics2D gs = image.createGraphics();
                gs.setComposite(AlphaComposite.Src);
                gs.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                gs.setColor(Color.WHITE);
                gs.fillRoundRect(0, 0, WIDTH, HEIGHT, radius, radius);
                gs.setComposite(AlphaComposite.SrcAtop);
                gs.drawImage(srcImage, 0, 0, null);
                gs.dispose();

                return image;
            }

            /**
             * 初始化书本缩略图
             * @param path 图片路径
             */
            private void setupImg(String path){
                try {
                    img = ImageIO.read(new File(path));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            /**
             * 初始化监听器
             */
            private void setupListener(){
                this.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        setCursor(Cursor.getDefaultCursor());
                    }
                });
            }

            /**
             * 设置部件的属性
             */
            private void setupUI(){
                this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
            }

        }

        class RankChangeIcon extends JLabel {

            private final int UP = 0;
            private final int DOWN = 1;
            private final int HOLD = 2;
            private int STATUS = HOLD;  // 排名为上升、下降、保持

            /**
             * 初始化界面
             */
            public RankChangeIcon(){
                super();
                setupUI();
            }

            /**
             * 设置排名变化状态
             * @param changeRank 排名变化
             */
            public void setRankChangeIcon(int changeRank){
                if (changeRank < 0) STATUS = DOWN;
                else if (changeRank > 0) STATUS = UP;
                else STATUS = HOLD;
                this.repaint();
            }

            /**
             * 绘制排名变化状态
             * @param g 图像对象
             */
            @Override
            public void paint(Graphics g) {
                Graphics2D g2d = (Graphics2D)g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                if (STATUS == UP) {
                    try {
                        BufferedImage icon = ImageIO.read(new File("icons/Up.png"));
                        g2d.drawImage(icon, 0, 0, null);
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (STATUS == DOWN) {
                    try {
                        BufferedImage icon = ImageIO.read(new File("icons/Down.png"));
                        g2d.drawImage(icon, 0, 0, null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    g2d.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                    g2d.setColor(new Color(1, 163, 188));
                    g2d.drawLine(10, 20, 20, 20);
                }
            }

            /**
             * 初始化界面
             */
            private void setupUI(){
                this.setPreferredSize(new Dimension(30, 30));
            }
        }

        class RankInfoPanel extends JPanel {

            private JLabel rankNum;
            private RankChangeIcon rankChangeIcon;
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
             * 设置部件属性
             */
            private void setupUI(){
                this.setPreferredSize(new Dimension(50, 200));
                this.setLayout(new FormLayout("center:d:noGrow", "center:d:noGrow,center:10px:noGrow,center:d:noGrow,center:d:noGrow"));
                CellConstraints cc = new CellConstraints();
                rankNum = new JLabel();
                rankNum.setForeground(LayoutColors.DARKEST_GRAY);
                rankNum.setPreferredSize(new Dimension(40, 40));
                rankNum.setFont(new Font("黑体", Font.BOLD, 24));
                rankNum.setHorizontalAlignment(SwingConstants.CENTER);
                this.add(rankNum, cc.xy(1, 1));
                rankChangeIcon = new RankChangeIcon();
                this.add(rankChangeIcon, cc.xy(1, 3));
                rankChangeNum = new JLabel();
                rankChangeNum.setPreferredSize(new Dimension(40, 20));
                rankChangeNum.setFont(new Font("微软雅黑", Font.BOLD, 14));
                rankChangeNum.setHorizontalAlignment(SwingConstants.CENTER);
                this.add(rankChangeNum, cc.xy(1, 4));
            }

            /**
             * 函数说明
             *
             * @param rank 排名
             * @param rankChange 排名变化（正数为上升，负数为下降）
             */
            public void setRankInfo(int rank, int rankChange){
                rankNum.setText(Integer.toString(rank));
                rankChangeIcon.setRankChangeIcon(rankChange);
                rankChangeNum.setText(Integer.toString(rankChange));
                if (rankChange < 0) rankChangeNum.setForeground(new Color(213, 64, 83));
                else if (rankChange > 0) rankChangeNum.setForeground(new Color(98, 204, 177));
                else rankChangeNum.setForeground(new Color(1, 163, 188));
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
             * 获取排名信息面板
             * @return 返回排名信息面板对象
             */
            public RankInfoPanel getRankInfoPanel() {
                return rankInfo;
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

        BookChartDisplay bookChartDisplay = new BookChartDisplay("pics/test.png");
        bookChartDisplay.getRankInfoPanel().setRankInfo(1, -5);

        JPanel panel = new JPanel();
        panel.add(bookChartDisplay);

        frame.add(panel);
        frame.setVisible(true);

    }

}
