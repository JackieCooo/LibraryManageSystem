package gui.components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MessageBtn extends JButton {

    private BufferedImage normalIcon;
    private BufferedImage focusIcon;
    private final int WIDTH = 30;
    private final int HEIGHT = 30;
    private boolean isFocus = false;

    /**
     * 初始化按钮
     */
    public MessageBtn(){
        super();
        setupIcon();
        setupUI();
    }

    /**
     * 初始化按钮图标
     */
    private void setupIcon(){
        try {
            normalIcon = ImageIO.read(new File("icons/MessageBtnNormal.png"));
            focusIcon = ImageIO.read(new File("icons/MessageBtnFocus.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 重绘按钮样式
     * @param g 画图对象
     */
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
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

            }
        });
    }
}
