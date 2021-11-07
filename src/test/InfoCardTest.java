package test;

import gui.shared.LayoutColors;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class InfoCardTest {

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

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 400, 300);

        class InfoCard extends JLabel {

            private final int WIDTH = 200;
            private final int HEIGHT = 100;
            private BufferedImage cardIcon;
            private int value = 0;

            /**
             * 初始化界面
             * @param iconPath 图标路径
             */
            public InfoCard(String iconPath){
                super();
                setupIcon(iconPath);
                setupUI();
            }

            /**
             * 设置数值
             * @param val 数值
             */
            public void setValue(int val){
                this.value = val;
            }

            /**
             * 初始化图标
             * @param iconPath 图标路径
             */
            private void setupIcon(String iconPath){
                try {
                    cardIcon = ImageIO.read(new File(iconPath));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            /**
             * 初始化界面属性
             */
            private void setupUI(){
                this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
                this.setText("测试");

                // 定制标签UI
                class LabelUI extends BasicLabelUI {

                    /**
                     * 绘制组件
                     * @param g 画笔对象
                     * @param c 组件对象
                     */
                    @Override
                    public void paint(Graphics g, JComponent c) {
                        Graphics2D g2d = (Graphics2D)g;
                        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                        g2d.setPaint(new GradientPaint(0.0f, 50.0f, new Color(11, 186, 251), 200.0f, 50.0f, new Color(66, 133, 236)));
                        g2d.fillRoundRect(0, 0, WIDTH, HEIGHT, 20, 20);
                        g2d.drawImage(cardIcon, 20, 35, null);
                        g2d.setColor(Color.WHITE);
                        g2d.setFont(new Font("黑体", Font.BOLD, 20));
                        g2d.drawString(getText(), 80, 40);
                        g2d.drawString(Integer.toString(value), 80, 75);
                    }
                }
                LabelUI ui = new LabelUI();
                this.setUI(ui);
            }

        }

        InfoCard infoCard = new InfoCard("icons/Books_30px.png");
        JPanel panel = new JPanel();
        panel.add(infoCard);
        frame.add(panel);
        frame.setVisible(true);
    }

}
