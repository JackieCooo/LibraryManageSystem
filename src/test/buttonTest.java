package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class buttonTest {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 400, 300);

        JPanel panel = new JPanel();

        class MyButton extends JButton {

            private boolean hasBeenSet = false;  // 按钮是否被按下
            private ImageIcon setIcon;
            private ImageIcon unsetIcon;

            /**
             * 初始化按钮
             * @param unsetIconUrl 未被按下按钮的图标路径
             * @param setIconUrl 被按下按钮的图标路径
             */
            public MyButton(String unsetIconUrl, String setIconUrl){
                super();
                setupIcons(unsetIconUrl, setIconUrl);
                setupUI();
            }

            /**
             * 初始化图标
             */
            private void setupIcons(String unsetIconUrl, String setIconUrl){
                if (setIconUrl != null) this.setIcon = new ImageIcon(setIconUrl);
                if (unsetIconUrl != null) this.unsetIcon = new ImageIcon(unsetIconUrl);
            }

            /**
             * 初始化按钮属性
             */
            private void setupUI(){
                this.setPreferredSize(new Dimension(30, 30));
                this.setText(null);
                this.setBorderPainted(false);
                this.setContentAreaFilled(false);

                if (hasBeenSet) {
                    this.setIcon(setIcon);
                }
                else{
                    this.setIcon(unsetIcon);
                }

                this.addMouseListener(new MouseAdapter() {

                    /**
                     * 设置鼠标进入按钮区域的图标
                     * @param e 鼠标事件对象
                     */
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        if (!hasBeenSet){
                            setIcon(setIcon);
                            repaint();
                        }
                    }

                    /**
                     * 设置鼠标退出按钮区域的图标
                     * @param e 鼠标事件对象
                     */
                    @Override
                    public void mouseExited(MouseEvent e) {
                        setCursor(Cursor.getDefaultCursor());
                        if (!hasBeenSet){
                            setIcon(unsetIcon);
                            repaint();
                        }
                    }

                    /**
                     * 设置鼠标点击后的图标
                     * @param e 鼠标事件对象
                     */
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        hasBeenSet = !hasBeenSet;
                        if (hasBeenSet) {
                            setIcon(setIcon);
                        }
                        else{
                            setIcon(unsetIcon);
                        }
                        repaint();
                    }

                });

            }

        }

        MyButton btn = new MyButton("icons/Uncollected.png", "icons/Collected.png");

        panel.add(btn);
        frame.add(panel);

        frame.setVisible(true);
    }

}
