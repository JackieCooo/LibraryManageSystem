package test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class buttonTest {

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 400, 300);

        JPanel panel = new JPanel();

        class MyImageIcon implements Icon {

            private BufferedImage iconImg;
            private final int WIDTH = 30;
            private final int HEIGHT = 30;

            public MyImageIcon(String filepath) throws IOException {
                iconImg = ImageIO.read(new File(filepath));
            }

            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                Graphics2D g2d = (Graphics2D)g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(Color.BLUE);
                g2d.fillOval(x, y, this.WIDTH, this.HEIGHT);
                g2d.drawImage(this.iconImg, x, y, c);
            }

            @Override
            public int getIconWidth() {
                return this.WIDTH;
            }

            @Override
            public int getIconHeight() {
                return this.HEIGHT;
            }
        }

        class MyButton extends JButton {

            private MyImageIcon btnIcon;

            /**
             * 初始化按钮
             * @param iconUrl 按钮的图标路径
             */
            public MyButton(String iconUrl) throws IOException {
                super();
                setupIcons(iconUrl);
                setupUI();
            }

            /**
             * 初始化图标
             */
            private void setupIcons(String iconUrl) throws IOException {
                if (iconUrl != null) this.btnIcon = new MyImageIcon(iconUrl);
                this.setIcon(this.btnIcon);
            }

            /**
             * 初始化按钮属性
             */
            private void setupUI(){
                this.setPreferredSize(new Dimension(30, 30));
                this.setText(null);
                this.setBorderPainted(false);
                this.setContentAreaFilled(false);

                this.addMouseListener(new MouseAdapter() {

                    /**
                     * 设置鼠标进入事件
                     * @param e 鼠标事件
                     */
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    }

                    /**
                     * 设置鼠标退出事件
                     * @param e 鼠标事件
                     */
                    @Override
                    public void mouseExited(MouseEvent e) {
                        setCursor(Cursor.getDefaultCursor());
                    }

                    /**
                     * 设置鼠标点击后的图标
                     * @param e 鼠标事件对象
                     */
                    @Override
                    public void mouseClicked(MouseEvent e) {

                    }

                });

            }

        }

        MyButton btn = new MyButton("icons/CancelBtn.png");

        panel.add(btn);
        frame.add(panel);

        frame.setVisible(true);
    }

}
