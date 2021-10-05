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
        frame.setBounds(100, 100, 900, 675);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(900, 75));

        // 定制侧边框
        class MyPopupMenu extends JPopupMenu {

            public MyPopupMenu(){
                super();
                setupUI();
            }

            private void setupUI(){
                this.setPopupSize(new Dimension(400, 300));
                this.setOpaque(true);
                this.setBackground(Color.BLUE);
            }
        }

        // 定制滚动面板
        class MyScrollPane extends JScrollPane {

            private MyPanel panel;

            public MyScrollPane(){
                super();
                setupUI();
            }

            private void setupUI(){

            }
        }

        // 定制滚动面板内面板
        class MyPanel extends JPanel {

        }

        // 定制消息框
        class MyMessageBox extends JPanel {

        }

        class MyButton extends JButton {

            private MyPopupMenu popupMenu;
            private BufferedImage normalIcon;
            private BufferedImage focusIcon;
            private final int WIDTH = 30;
            private final int HEIGHT = 30;
            private boolean isFocus = false;

            /**
             * 初始化按钮
             */
            public MyButton() throws IOException {
                super();
                setupIcon();
                setupPopupMenu();
                setupUI();
            }

            private void setupIcon() throws IOException {
                normalIcon = ImageIO.read(new File("icons/MessageBtnNormal.png"));
                focusIcon = ImageIO.read(new File("icons/MessageBtnFocus.png"));
            }

            /**
             * 重绘按钮样式
             * @param g 画图对象
             */
            @Override
            public void paint(Graphics g) {
                Graphics2D g2d = (Graphics2D)g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                if (isFocus) {
                    g2d.drawImage(focusIcon, null, 0, 0);
                }
                else {
                    g2d.drawImage(normalIcon, null, 0, 0);
                }
            }

            /**
             * 改变按钮状态并重绘
             */
            public void toggleState(){
                isFocus = !isFocus;
                this.repaint();
            }

            private void setupPopupMenu(){
                popupMenu = new MyPopupMenu();
            }

            private MyButton getThis(){
                return this;
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
                        toggleState();
                    }

                    /**
                     * 设置鼠标退出事件
                     * @param e 鼠标事件
                     */
                    @Override
                    public void mouseExited(MouseEvent e) {
                        setCursor(Cursor.getDefaultCursor());
                        toggleState();
                    }

                    /**
                     * 设置鼠标点击事件
                     * @param e 鼠标事件对象
                     */
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        popupMenu.setInvoker(getThis());
                        popupMenu.setVisible(true);
                        popupMenu.setLocation(0, 0);
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
