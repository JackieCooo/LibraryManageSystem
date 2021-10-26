package gui.user.window;

import com.jgoodies.forms.layout.FormLayout;
import gui.shared.LayoutColors;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
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
    private BufferedImage hoverCover;
    private boolean isBtn1Set = false;
    private boolean isBtn2Set = false;
    private boolean isBtn3Hover = false;
    private final int WIDTH = 150;
    private final int HEIGHT = 200;

    /**
     * 文本框类
     * @author Jackie
     */
    class InfoPanel extends JTextPane {

        private StyledDocument doc;
        private SimpleAttributeSet attributeSet;

        /**
         * 初始化界面
         */
        public InfoPanel(){
            super();
            setupUI();
        }

        /**
         * 向文本框插入文字
         * @param text 插入的文字
         */
        public void insert(String text){
            try {
                doc.insertString(doc.getLength(), text, attributeSet);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }

        /**
         * 初始化文字
         */
        private void setupText(){
            insert("Hello\n");
        }

        /**
         * 初始化界面
         */
        private void setupUI(){
            doc = this.getStyledDocument();
            attributeSet = new SimpleAttributeSet();
            StyleConstants.setFontFamily(attributeSet, "微软雅黑");
            StyleConstants.setFontSize(attributeSet, 14);
            this.setLayout(new FormLayout("center:10px:noGrow,center:d:noGrow,center:10px:noGrow,center:d:noGrow,center:10px:noGrow", "center:10px:noGrow,center:d:noGrow,center:10px:noGrow"));
            this.setOpaque(true);
            this.setBackground(Color.WHITE);
            this.setPreferredSize(new Dimension(300, 300));
            this.setEditable(false);
            setupText();
        }

    }

    /**
     * 弹出窗口类类
     * @author Jackie
     */
    class PopupMenu extends JPopupMenu {

        private InfoPanel infoPanel;

        /**
         * 初始化界面
         */
        public PopupMenu(){
            super();
            setupUI();
        }

        /**
         * 初始化界面属性
         */
        private void setupUI(){
            this.setPreferredSize(new Dimension(300, 300));
            this.setOpaque(true);
            this.setBackground(Color.WHITE);
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
            infoPanel = new InfoPanel();

            this.add(infoPanel);
        }

    }

    private PopupMenu popupMenu = new PopupMenu();


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
     */
    private void createHoverIcons(){
        try {
            BufferedImage collectBtn;
            BufferedImage borrowBtn;
            BufferedImage infoBtn;

            if (!isBtn1Set) collectBtn = ImageIO.read(new File("icons/Uncollected_50px.png"));
            else collectBtn = ImageIO.read(new File("icons/Collected_50px.png"));

            if (!isBtn2Set) borrowBtn = ImageIO.read(new File("icons/Unborrowed_50px.png"));
            else borrowBtn = ImageIO.read(new File("icons/Borrowed_50px.png"));

            if (!isBtn3Hover) infoBtn = ImageIO.read(new File("icons/InfoNormal_50px.png"));
            else infoBtn = ImageIO.read(new File("icons/InfoFocus_50px.png"));

            hoverCover = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = hoverCover.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setColor(LayoutColors.LIGHT_GRAY);
            g2d.fillRoundRect(0, 0, WIDTH, HEIGHT, 15, 15);
            g2d.drawImage(collectBtn, 50, 10, null);
            g2d.drawImage(borrowBtn, 50, 75, null);
            g2d.drawImage(infoBtn, 50, 140, null);
            hoverCover = getAlphaImg(hoverCover, 205);
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
        createHoverIcons();
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
                Point p = e.getPoint();
                if (p.x >= 50 && p.x <= 100 && p.y >= 10 && p.y <= 60){
                    isBtn1Set = !isBtn1Set;
                    createHoverIcons();
                    repaint();
                }
                else if (p.x >= 50 && p.x <= 100 && p.y >= 75 && p.y <= 125) {
                    isBtn2Set = !isBtn2Set;
                    createHoverIcons();
                    repaint();
                }
            }

        });

        this.addMouseMotionListener(new MouseMotionAdapter() {

            /**
             * 鼠标移动事件
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseMoved(MouseEvent e) {
                Point p = e.getPoint();

                // 鼠标移动到图标时改变指针样式
                if (p.x >= 50 && p.x <= 100 && ((p.y >= 10 && p.y <= 60) || (p.y >= 75 && p.y <= 125) || (p.y >= 140 && p.y <= 190))) {
                    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
                else {
                    setCursor(Cursor.getDefaultCursor());
                }

                // 指针指向信息按钮，显示书本信息
                if (p.x >= 50 && p.x <= 100 && p.y >= 140 && p.y <= 190){
                    isBtn3Hover = true;
                    Point pp = e.getComponent().getLocationOnScreen();
                    popupMenu.setInvoker(e.getComponent());
                    popupMenu.setLocation(pp.x + WIDTH, pp.y);
                    popupMenu.setVisible(true);
                }
                else {
                    isBtn3Hover = false;
                    popupMenu.setVisible(false);
                }

                createHoverIcons();
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
            g2d.drawImage(hoverCover, 0, 0, null);
        });
        this.putClientProperty("Nimbus.Overrides", btnDefaults);
        this.putClientProperty("Nimbus.Overrides.InheritDefaults", false);

    }

}
