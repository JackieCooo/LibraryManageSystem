package test;

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
 * 书本展示框类
 * @author Jackie
 */
class BookDisplay extends JButton {

    private BufferedImage img;
    private BufferedImage unselectedIcon;
    private BufferedImage selectedIcon;
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

//    private BufferedImage getAlphaImg(BufferedImage src, final int alpha){
//
//    }

    private void createHoverIcons(String unselectedIconPath, String selectedIconPath){
        try {
            BufferedImage unselectedImg = ImageIO.read(new File(unselectedIconPath));
            unselectedIcon = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = unselectedIcon.createGraphics();
            g2d.setColor(LayoutColors.BLUE);
            g2d.fillRoundRect(0, 0, WIDTH, HEIGHT, 15, 15);
            g2d.drawImage(unselectedImg, 0, 0, null);

            BufferedImage selectedImg = ImageIO.read(new File(selectedIconPath));
            g2d = selectedIcon.createGraphics();
            g2d.setColor(LayoutColors.BLUE);
            g2d.fillRoundRect(0, 0, WIDTH, HEIGHT, 15, 15);
            g2d.drawImage(unselectedImg, 0, 0, null);

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
        createHoverIcons("icons/Uncollected.png", "icons/Collected.png");
    }

    /**
     * 初始化监听器
     */
    private void setupListener(){
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
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
            g2d.drawImage(unselectedIcon, 0, 0, null);
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
