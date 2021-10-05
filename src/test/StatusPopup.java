package test;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Composite;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.RenderingHints.Key;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

/**
 * QQ登录状态选择弹出菜单
 *
 * @author Tang
 *
 */
@SuppressWarnings("serial")
public class StatusPopup extends JPopupMenu {

    public static void main(String[] args) {

        // 设置工具提示的默认样式
        Color toolTipColor = new Color(80, 80, 80);
        UIManager.put("ToolTip.border",
                BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(toolTipColor), BorderFactory.createEmptyBorder(2, 3, 2, 3)));
        UIManager.put("ToolTip.background", Color.WHITE);
        UIManager.put("ToolTip.foreground", toolTipColor);

        final JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        // frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setLocationRelativeTo(null);

        JPanel userIconPanel = new JPanel();
        userIconPanel.setBackground(Color.LIGHT_GRAY);
        userIconPanel.setLayout(null);
        userIconPanel.setPreferredSize(new Dimension(80, 80));
        frame.add(userIconPanel);

        // Status

        // 选择状态的背景
        final Image statusbgImage1 = ImageTool.cutStateBackgroundImage(0);
        final Image statusbgImage2 = ImageTool.cutStateBackgroundImage(1);

        final ImagePanel statusLabelPanel = new ImagePanel(statusbgImage1);
        statusLabelPanel.setLayout(null);
        statusLabelPanel.setBounds(61, 61, 17, 17);
        statusLabelPanel.setOpaque(false);
        userIconPanel.add(statusLabelPanel);

        final StatusLabel statusLabel = new StatusLabel(Status.imonline);
        statusLabel.setBounds(3, 3, 11, 11);

        final StatusPopup statusPopup = new StatusPopup(statusLabel);

        MouseAdapter mouseAdapter = new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                if (!statusPopup.isVisible()) {
                    statusLabelPanel.setBackgroundImage(statusbgImage2);
                }
            }

            public void mouseExited(MouseEvent e) {
                statusLabel.setLocation(3, 3);
                statusLabelPanel.setBackgroundImage(statusbgImage1);
            }

            public void mouseClicked(MouseEvent e) {
                statusPopup.setVisible(false);
                statusLabelPanel.setBackgroundImage(statusbgImage2);
                statusLabel.setLocation(4, 4);
                statusPopup.show(statusLabelPanel, 0, 20);
                statusPopup.repaint();
            }
        };
        statusLabel.addMouseListener(mouseAdapter);

        statusLabelPanel.add(statusLabel);

        frame.setVisible(true);
    }

    public static Dimension popupSize = new Dimension(110, 142);
    public static Color leftbackColor = new Color(209, 228, 236);
    public static Color rightbackColor = Color.WHITE;
    public static Color selecedbackColor = new Color(55, 142, 206);
    public static Color separatorColor = new Color(183, 195, 204);

    public static Font font = new Font("微软雅黑", Font.PLAIN, 12);

    public static Color borderColor1 = new Color(150, 150, 150, 20);
    public static Color borderColor2 = new Color(100, 100, 100, 80);
    public static Color borderColor3 = new Color(199, 199, 199);
    public static Color borderColor4 = new Color(255, 255, 255);
    public static Paint[] borderPaints = { borderColor3, borderColor4 };

    StatusLabel statusLabel;

    public StatusPopup(StatusLabel statusLabel) {
        this.statusLabel = statusLabel;
        add(new StatusPanel(statusLabel, this));
        setPopupSize(popupSize);
        setBorder(BorderFactory.createEmptyBorder());
        setOpaque(false);
    }

    public static class StatusPanel extends JPanel {

        StatusLabel statusLabel;// 这是选择之后要改变的状态

        StatusRowPanel[] rowPanels = new StatusRowPanel[6];// 不需要离线，所以是6个
        int mouseRow;
        JPopupMenu popupMenu;

        public StatusPanel(final StatusLabel statusLabel, JPopupMenu popupMenu) {
            this.statusLabel = statusLabel;
            this.popupMenu = popupMenu;
            initStatusPanel();
        }

        private void initStatusPanel() {
            // 绘制圆角和边框阴影，可能会造成子组件被绘掉的问题，解决方法是将布局设置为空，调代理的setLocation(x, y),setSize(w,h)，用一个代理添加子组件
            setLayout(null);
            setBackground(rightbackColor);
            setOpaque(false);
            setPreferredSize(popupSize);

            JPanel proxyPanel = new JPanel();
            proxyPanel.setLayout(new BoxLayout(proxyPanel, BoxLayout.Y_AXIS));
            proxyPanel.setBackground(rightbackColor);
            proxyPanel.setPreferredSize(popupSize);
            proxyPanel.setLocation(borderPaints.length, borderPaints.length);
            proxyPanel.setSize(popupSize.width - borderPaints.length * 2, popupSize.height - borderPaints.length * 2);

            add(proxyPanel);

            Status[] ss = Status.getValuesByIndex();
            for (int i = 0; i < rowPanels.length; i++) {

                rowPanels[i] = new StatusRowPanel(ss[i]);

                proxyPanel.add(rowPanels[i]);
            }
        }

        // 绘制圆角和边框阴影，可能会造成子组件被绘掉的问题，解决方法是将布局设置为空，调代理的setLocation(4, 4)，用一个代理添加子组件
        @Override
        public void paint(Graphics g) {
            super.paintChildren(g);
            Graphics2D g2d = (Graphics2D) g;
            ImageTool.drawAndClearRoundRect(g2d, getWidth(), getHeight(), 2, getParentBackground(this), borderPaints);// 绘制软键盘成圆角和多层颜色边框
        }

        public class StatusRowPanel extends JPanel {

            public StatusRowPanel(final Status status) {

                setToolTipText(status.getTooltip());
                setLayout(new BorderLayout());
                setBackground(rightbackColor);

                final StatusLabel sl = new StatusLabel(status);
                sl.setOpaque(true);
                sl.setBackground(leftbackColor);
                sl.setBorder(new EmptyBorder(0, 8, 0, 8));
                add(sl, BorderLayout.WEST);

                final JLabel label = new JLabel(status.getName());
                label.setBorder(new EmptyBorder(0, 10, 0, 0));
                label.setFont(font);
                label.setForeground(Color.BLACK);
                add(label, BorderLayout.CENTER);
                //
                MouseAdapter mouseAdapter = new MouseAdapter() {
                    public void mouseEntered(MouseEvent e) {
                        mouseRow = status.ordinal();
                        // 改变 背景色
                        setBackground(selecedbackColor);
                        sl.setBackground(selecedbackColor);
                        label.setForeground(rightbackColor);
                        popupMenu.repaint();
                    }

                    public void mouseExited(MouseEvent e) {
                        // 改变 背景色
                        setBackground(rightbackColor);
                        sl.setBackground(leftbackColor);
                        label.setForeground(Color.BLACK);
                        popupMenu.repaint();
                    }

                    public void mouseClicked(MouseEvent e) {
                        System.out.println(sl.getStatus().getName());
                        statusLabel.setStatus(sl.getStatus());
                        popupMenu.setVisible(false);
                        setBackground(rightbackColor);
                        label.setForeground(Color.BLACK);
                        sl.setBackground(leftbackColor);
                    }
                };

                addMouseMotionListener(mouseAdapter);
                addMouseListener(mouseAdapter);
            }
        }
    }

    public static Color getParentBackground(Component c) {
        Container parent = c.getParent();
        if (parent != null) {
            if (c.isOpaque()) {
                return parent.getBackground();
            } else {
                return getParentBackground(parent);
            }
        } else {
            return c.getBackground();
        }
    }

    public enum Status {

        // index 是不依赖ordinal的索引，也就是不依赖枚举的摆放顺序
        imonline("我在线上", "<html>表示希望好友看到你在线。<br/>" + "声音：开启<br/>" + "消息提醒框：开启<br/>" + "会话消息：任务栏头像闪动</html>", 0), // 在线

        qme("Q我吧", "<html>表示希望好友主动联系你。<br/>" + "声音：开启<br/>" + "消息提醒框：开启<br/>" + "会话消息：自动弹出会话窗口</html>", 1), // Q我

        away("离开", "<html>表示离开，暂时无法处理消息。<br/>" + "声音：开启<br/>" + "消息提醒框：开启<br/>" + "会话消息：任务栏头像闪动</html>", 2), // 离开

        busy("忙碌", "<html>表示忙碌，不会即时处理消息。<br/>" + "声音：开启<br/>" + "消息提醒框：开启<br/>" + "会话消息：任务栏显示气泡</html>", 3), // 忙碌

        mute("请勿打扰", "<html>表示不想被打扰。<br/>" + "声音：开启<br/>" + "消息提醒框：开启<br/>" + "会话消息：任务栏显示气泡</html>", 4), // 勿打扰

        invisible("隐身", "<html>表示好友看到你是离线的。<br/>" + "声音：开启<br/>" + "消息提醒框：开启<br/>" + "会话消息：任务栏头像闪动</html>", 5), // 隐身

        imoffline("离线", "<html>无法连接到网络。</html>", 6)// 离线
        ;
        String name;
        String tooltip;
        int index;

        Status(String name, String tooltip, int index) {
            this.name = name;
            this.tooltip = tooltip;
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public String getTooltip() {
            return tooltip;
        }

        public int getIndex() {
            return index;
        }

        public static Status[] getValuesByIndex() {
            // values()方法获取的就是根据ordinal索引排序过的数组，所以对values()的返回值排序不会影响下次再调用values()的顺序
            Status[] values = Status.values();
            Arrays.sort(values, new Comparator<Status>() {
                public int compare(Status o1, Status o2) {
                    return o1.getIndex() - o2.getIndex();
                }
            });
            return values;
        }
    }

    public static class StatusLabel extends JLabel {

        private Status status;

        public StatusLabel(Status status) {
            super(getIcon(status));
            this.status = status;
        }

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
            setIcon(getIcon(status));
        }

        private static Icon getIcon(Status status) {
            return ImageTool.getImageIcon(status.name() + ".png");
        }
    }
}

class ImageTool {

    public static String statusPath = System.getProperty("user.dir") + File.separator + "status" + File.separator;

    // 加载图片文件得到一个ImageIcon
    public static ImageIcon getImageIcon(String filename) {
        return new ImageIcon(statusPath + filename);
    }

    // 加载图片文件得到一张图片
    public static Image getImage(String filename) {
        return getImageIcon(filename).getImage();
    }

    // 裁剪图片
    public static Image cutImage(Image src, int x, int y, int w, int h) {
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g2d = bi.createGraphics();
        setAntiAliasing(g2d);
        setRendering(g2d);
        g2d.drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
        return bi;
    }

    public static Image cutHorizontalImage(Image src, int op, int count) {
        int width = src.getWidth(null);
        int h = src.getHeight(null);
        int w = (int) (width * 1.0 / count);
        int x = w * op;
        int y = 0;
        return cutImage(src, x, y, w, h);
    }

    public static Image cutStateBackgroundImage(int op) {
        return cutHorizontalImage(getImage("status_bg.png"), op, 3);
    }

    // 绘制圆角
    public static void drawAndClearRoundRect(Graphics2D g2d, int width, int height, int r, Paint anglePaint, Paint[] borderPaints) {
        clearMultiBorder(g2d, width, height, r, anglePaint, borderPaints);
        drawMultiBorder(g2d, width, height, r, anglePaint, borderPaints);// 画边框
    }

    public static void clearMultiBorder(Graphics2D g2d, int width, int height, int r, Paint anglePaint, Paint[] borderPaints) {
        Composite oldComposite = g2d.getComposite();
        if (anglePaint == null) {
            g2d.setComposite(AlphaComposite.Clear);// 设置Composite为清空
        } else {
            g2d.setPaint(anglePaint);
        }

        setAntiAliasing(g2d);

        int roundx = r * 2;
        int roundy = roundx;
        int x = 0;
        int y = 0;
        int offs = borderPaints.length;

        RoundRectangle2D.Float outer = new RoundRectangle2D.Float(x, y, width, height, roundx, roundy);
        RoundRectangle2D.Float inner = new RoundRectangle2D.Float(x + offs, y + offs, width - (offs * 2), height - (offs * 2), roundx, roundy);

        Path2D.Float paht2d = new Path2D.Float(Path2D.WIND_EVEN_ODD);
        paht2d.append(outer, false);
        paht2d.append(inner, false);

        g2d.fill(paht2d);
        g2d.setComposite(oldComposite);
    }

    // 绘制有层次感的边框
    public static void drawMultiBorder(Graphics2D g2d, int width, int height, int r, Paint anglePaint, Paint[] borderPaints) {
        setAntiAliasing(g2d);

        int roundx = r * 2;
        int roundy = roundx;
        int grow = 2;
        int x = 0;
        int y = 0;
        int w = width;
        int h = height;

        // 从外层往内层开始画
        for (int i = 0; i < borderPaints.length; i++, x++, y++, w -= grow, h -= grow) {
            g2d.setPaint(borderPaints[i]);
            if (r > 0) {
                g2d.drawRoundRect(x, y, w - 1, h - 1, roundx, roundy);
            } else {
                g2d.drawRect(x, y, w - 1, h - 1);
            }
        }
    }

    // 设置Graphics2D质量优先,具体请查看RenderingHints类的API
    public static void setRendering(Graphics2D g2d) {
        setRenderingHint(g2d, RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    }

    // 设置Graphics2D抗锯齿,具体请查看RenderingHints类的API
    public static void setAntiAliasing(Graphics2D g2d) {
        setRenderingHint(g2d, RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    public static void setRenderingHint(Graphics2D g2d, Key key, Object value) {
        if (g2d.getRenderingHints() == null) {
            g2d.setRenderingHints(new RenderingHints(key, value));
        } else {
            g2d.setRenderingHint(key, value);
        }
    }
}

class ImagePanel extends JPanel {

    private static final long serialVersionUID = -8251916094895167058L;

    public static enum DisplayMode {
        Centre, // 居中
        Tiled, // 平铺
        Fill, // 拉伸
        Left, // 左对齐
        Custom//指定宽高
    }

    /**
     * 背景图片
     */
    protected Image backgroundImage;

    /**
     * 背景图片显示模式
     */
    protected DisplayMode displayMode;

    protected int customWidth;
    protected int customHeight;

    /**
     * 构造一个没有背景图片的ImagePanel
     */
    public ImagePanel(Image image) {
        this(image, DisplayMode.Fill);
    }

    /**
     * 构造一个具有指定背景图片和指定显示模式的ImagePanel
     *
     * @param image
     *            背景图片
     * @param modeName
     *            背景图片显示模式
     */
    public ImagePanel(Image image, DisplayMode modeName) {
        this.backgroundImage = image;
        this.displayMode = modeName;
    }

    /**
     * 设置背景图片
     *
     * @param image
     *            背景图片
     */
    public void setBackgroundImage(Image image) {
        if (this.backgroundImage != image) {
            this.backgroundImage = image;
            this.repaint();
        }
    }

    /**
     * 获取背景图片
     *
     * @return 背景图片
     */
    public Image getBackgroundImage() {
        return backgroundImage;
    }

    /**
     * 设置背景图片显示模式
     *
     * @param displayMode
     */
    public void setDisplayMode(DisplayMode displayMode) {
        if (this.displayMode != displayMode) {
            this.displayMode = displayMode;
            this.repaint();
        }
    }

    /**
     * 获取背景图片显示模式
     *
     * @return 显示模式
     */
    public DisplayMode getDisplayMode() {
        return displayMode;
    }

    public int getCustomWidth() {
        return customWidth;
    }

    public void setCustomWidth(int customWidth) {
        this.customWidth = customWidth;
    }

    public int getCustomHeight() {
        return customHeight;
    }

    public void setCustomHeight(int customHeight) {
        this.customHeight = customHeight;
    }

    /**
     * 绘制组件
     *
     * @see javax.swing.JComponent#paintComponent(Graphics)
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {// 如果设置了背景图片则显示
            int width = this.getWidth();
            int height = this.getHeight();
            int imageWidth = backgroundImage.getWidth(null);
            int imageHeight = backgroundImage.getHeight(null);
            if (displayMode == DisplayMode.Centre) {// 居中
                int x = (width - imageWidth) / 2;
                int y = (height - imageHeight) / 2;
                g.drawImage(backgroundImage, x, y, this);
            } else if (displayMode == DisplayMode.Tiled) {// 平铺
                for (int ix = 0; ix < width; ix += imageWidth) {
                    for (int iy = 0; iy < height; iy += imageHeight) {
                        g.drawImage(backgroundImage, ix, iy, this);
                    }
                }
            } else if (displayMode == DisplayMode.Fill) {// 拉伸
                g.drawImage(backgroundImage, 0, 0, width, height, this);
            } else if (displayMode == DisplayMode.Left) {// 左对齐
                g.drawImage(backgroundImage, 0, 0, imageWidth, imageHeight, this);
            } else if (displayMode == DisplayMode.Custom) {//指定宽高
                g.drawImage(backgroundImage, 0, 0, customWidth, customHeight, this);
            }
        }
    }
}