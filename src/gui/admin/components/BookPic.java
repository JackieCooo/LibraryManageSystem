package gui.admin.components;

import gui.shared.LayoutColors;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 书本图片类
 * @author Jackie
 */
public class BookPic extends JButton {

    private BufferedImage img = null;
    private BufferedImage cover;
    private boolean hasPic = false;
    private final int WIDTH = 150;
    private final int HEIGHT = 200;

    /**
     * 初始化界面
     */
    public BookPic(){
        this(null);
    }

    /**
     * 初始化界面
     * @param path 图片路径
     */
    public BookPic(String path){
        super();
        setupImg(path);
        setupUI();
        setupListener();
    }

    /**
     * 设置书本图片
     * @param file 图片文件对象
     */
    public void setImg(File file){
        if (file == null) return;
        try {
            img = ImageIO.read(file);
            img = setRadius(img, 15);
            hasPic = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
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
     * 创建鼠标悬停的样式
     */
    private void createNullCover(){
        try {
            BufferedImage addIcon = ImageIO.read(new File("icons/Add_50px.png"));
            cover = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = cover.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setColor(LayoutColors.LIGHTEST_GRAY);
            g2d.fillRoundRect(0, 0, WIDTH, HEIGHT, 15, 15);
            g2d.drawImage(addIcon, 50, 75, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化书本缩略图
     * @param path 图片路径
     */
    private void setupImg(String path){
        createNullCover();
        if (path == null) return;
        try {
            img = ImageIO.read(new File(path));
            img = setRadius(img, 15);
            hasPic = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化监听器
     */
    private void setupListener(){
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
             * 鼠标点击执行选择图片操作
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser("./");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setMultiSelectionEnabled(false);
                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("image(*.png)", "png"));
                int res = fileChooser.showOpenDialog(getParent());
                if (res == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    setImg(file);
                    repaint();
                }
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
            if (hasPic) g2d.drawImage(img, 0, 0, null);
            else g2d.drawImage(cover, 0, 0, null);
        });
        this.putClientProperty("Nimbus.Overrides", btnDefaults);
        this.putClientProperty("Nimbus.Overrides.InheritDefaults", false);

    }

}
