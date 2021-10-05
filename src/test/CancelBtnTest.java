package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CancelBtnTest {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 400, 300);

        JPanel panel = new JPanel();

        class MyButton extends JButton {

            private final int WIDTH = 30;
            private final int HEIGHT = 30;

            /**
             * 初始化按钮
             */
            public MyButton() {
                super();
                setupUI();
            }

            /**
             * 重绘按钮样式
             * @param g 画图对象
             */
            @Override
            public void paint(Graphics g) {
                Graphics2D g2d = (Graphics2D)g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(new Color(65, 99, 188));
                g2d.fillOval(0, 0, WIDTH, HEIGHT);
                g2d.setColor(Color.WHITE);
                g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                g2d.drawLine(10, 15, 17, 8);
                g2d.drawLine(10, 15, 17, 22);
            }

            /**
             * 初始化按钮属性
             */
            private void setupUI(){
                this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
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
                        System.exit(0);
                    }

                });

            }

        }

        MyButton btn = new MyButton();

        panel.add(btn);
        frame.add(panel);

        frame.setVisible(true);
    }
}
