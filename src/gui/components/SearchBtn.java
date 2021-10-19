package gui.components;

import gui.shared.LayoutColors;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 搜索按钮类
 * @author Jackie
 */
public class SearchBtn extends JButton {

    private BufferedImage focusIcon;
    private BufferedImage normalIcon;

    /**
     * 初始化界面
     */
    public SearchBtn(){
        super();
        setupIcon();
        setupUI();
        setupListener();
    }

    /**
     * 初始化按钮图标
     */
    private void setupIcon(){
        try {
            normalIcon = ImageIO.read(new File("icons/SearchBtnNormal.png"));
            focusIcon = ImageIO.read(new File("icons/SearchBtnFocus.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(40, 40));

        UIDefaults btnDefaults = new UIDefaults();
        btnDefaults.put("Button.backgroundPainter", (Painter<JComponent>)(g2d, c, w, h) -> {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setColor(LayoutColors.LIGHT_BLUE);
            g2d.fillRoundRect(0, 0, 40, 40, 20, 20);
            g2d.fillRect(0, 0, 10, 40);
            g2d.drawImage(normalIcon, 0, 0, null);
        });
        btnDefaults.put("Button[MouseOver].backgroundPainter", (Painter<JComponent>)(g2d, c, w, h) -> {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setColor(LayoutColors.LIGHT_BLUE);
            g2d.fillRoundRect(0, 0, 40, 40, 20, 20);
            g2d.fillRect(0, 0, 10, 40);
            g2d.drawImage(focusIcon, 0, 0, null);
        });
        this.putClientProperty("Nimbus.Overrides", btnDefaults);
        this.putClientProperty("Nimbus.Overrides.InheritDefaults", false);

    }

    /**
     * 初始化监听器
     */
    private void setupListener(){
        this.addMouseListener(new MouseAdapter() {

            /**
             * 鼠标点击执行搜索操作
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            /**
             * 鼠标进入改变指针样式
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            /**
             * 鼠标退出改变指针样式
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });
    }

}
