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
                this.setPreferredSize(new Dimension(300, 150));
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
                        g2d.setColor(LayoutColors.BLUE);
                        g2d.fillRoundRect(0, 0, 300, 150, 20, 20);
                        g2d.drawImage(cardIcon, 40, 40, null);
                        g2d.setColor(Color.WHITE);
                        g2d.setFont(new Font("黑体", Font.BOLD, 24));
                        g2d.drawString(getText(), 100, 20);
                        g2d.drawString(Integer.toString(value), 100, 100);
                    }
                }
                LabelUI ui = new LabelUI();
                this.setUI(ui);
            }

        }

        InfoCard infoCard = new InfoCard("icons/RepoBtn.png");
        JPanel panel = new JPanel();
        panel.add(infoCard);
        frame.add(panel);
        frame.setVisible(true);
    }

}
