package gui.shared.components;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 自定义软件Logo类
 * @author Jackie
 */
public class CustomizedLogo extends JLabel {

    private BufferedImage logo;

    /**
     * 初始化界面
     */
    public CustomizedLogo(){
        super();
        setupIcon();
        setupUI();
        setupListener();
    }

    /**
     * 初始化监听器
     */
    public void setupListener(){
    }

    /**
     * 初始化图标
     */
    private void setupIcon(){
        try {
            logo = ImageIO.read(new File("icons/Logo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(200, 50));

        // 定制标签UI
        class LabelUI extends BasicLabelUI {

            /**
             * 绘制图标
             * @param g 画笔对象
             * @param c 部件对象
             */
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2d = (Graphics2D)g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g2d.drawImage(logo, 0, 0, null);
            }
        }
        LabelUI ui = new LabelUI();
        this.setUI(ui);
    }

}
