package test;

import gui.shared.LayoutColors;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 书本展示框类
 * @author Jackie
 */
class BookDisplay extends JButton {

    private BufferedImage img;
    private BufferedImage unselectedIcon;
    private BufferedImage selectedIcon;
    private boolean isBtnSet = false;
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
     * 图片设置圆角
     * @param srcImage 原图片
     * @param radius 圆角半径
     * @return 新的图片对象
     */
    private BufferedImage setRadius(BufferedImage srcImage, final int radius){

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
     * 将图片转成对应的透明度
     * @param src 源图片
     * @param alpha 透明度值
     * @return 返回目标图片对象
     */
    private BufferedImage getAlphaImg(BufferedImage src, final int alpha){
        BufferedImage dst = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                int rgb = src.getRGB(i, j);
                if (rgb == 0) continue;
                Color color = new Color(rgb);
                color = new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
                dst.setRGB(i, j, color.getRGB());
            }
        }
        return dst;
    }

    /**
     * 创建鼠标悬停的样式
     * @param unselectedIconPath 未收藏时的按钮图标路径
     * @param selectedIconPath 收藏时的按钮图标路径
     */
    private void createHoverIcons(final String unselectedIconPath, final String selectedIconPath){
        try {
            BufferedImage unselectedImg = ImageIO.read(new File(unselectedIconPath));
            unselectedIcon = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = unselectedIcon.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setColor(LayoutColors.LIGHT_GRAY);
            g2d.fillRoundRect(0, 0, WIDTH, HEIGHT, 15, 15);
            g2d.drawImage(unselectedImg, 45, 70, null);
            unselectedIcon = getAlphaImg(unselectedIcon, 205);

            BufferedImage selectedImg = ImageIO.read(new File(selectedIconPath));
            selectedIcon = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
            g2d = selectedIcon.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setColor(LayoutColors.LIGHT_GRAY);
            g2d.fillRoundRect(0, 0, WIDTH, HEIGHT, 15, 15);
            g2d.drawImage(selectedImg, 45, 70, null);
            g2d.dispose();
            selectedIcon = getAlphaImg(selectedIcon, 205);

        } catch (IOException e) {
            e.printStackTrace();
        }
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
        createHoverIcons("icons/Uncollected_60px.png", "icons/Collected_60px.png");
    }

    /**
     * 初始化监听器
     */
    private void setupListener(){
        this.addMouseListener(new MouseAdapter() {

            /**
             * 鼠标点击执行收藏操作
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                isBtnSet = !isBtnSet;
            }

        });

        this.addMouseMotionListener(new MouseMotionAdapter() {

            /**
             * 鼠标移动到收藏图标时改变指针样式
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseMoved(MouseEvent e) {
                Point p = e.getPoint();
                if (p.x >= 45 && p.x <= 105 && p.y >= 70 && p.y <= 130) {
                    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
                else {
                    setCursor(Cursor.getDefaultCursor());
                }
                repaint();
            }

        });
    }

    /**
     * 设置部件的属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        UIDefaults btnDefaults = new UIDefaults();
        btnDefaults.put("Button.backgroundPainter", (Painter<JComponent>)(g2d, c, w, h) -> {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            img = setRadius(img, 15);
            g2d.drawImage(img, 0, 0, null);
        });
        btnDefaults.put("Button[MouseOver].backgroundPainter", (Painter<JComponent>)(g2d, c, w, h) -> {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            img = setRadius(img, 15);
            g2d.drawImage(img, 0, 0, null);
            if (isBtnSet) g2d.drawImage(selectedIcon, 0, 0, null);
            else g2d.drawImage(unselectedIcon, 0, 0, null);
        });
        this.putClientProperty("Nimbus.Overrides", btnDefaults);
        this.putClientProperty("Nimbus.Overrides.InheritDefaults", false);

    }

}

public class BookDisplayTest {

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
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();

        BookDisplay bookDisplay = new BookDisplay("pics/test.png");
        panel.add(bookDisplay);

        frame.add(panel);
        frame.setVisible(true);
    }

}
