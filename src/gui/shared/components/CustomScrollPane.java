package gui.shared.components;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * 滚动面板类
 * @author Jackie
 */
public class CustomScrollPane extends JScrollPane {

    public final static int VERTICAL = 0;
    public final static int HORIZONTAL = 1;
    public final static int VERTICAL_AND_HORIZONTAL = 2;
    public final static int NONE = 3;

    /**
     * 滚动条UI类
     * @author Jackie
     */
    class MyScrollBarUI extends BasicScrollBarUI {

        /**
         * 滚动条监听器类
         * @author Jackie
         */
        class MyScrollBarListener extends TrackListener {

            /**
             * 处理鼠标释放事件
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseReleased(MouseEvent e) {
//                System.out.println("鼠标释放");
                super.mouseReleased(e);
                Rectangle r = getThumbBounds();
                // 如果鼠标释放时，鼠标在滑块内，视为鼠标悬停；否则，视为鼠标未进入窗口
                if (getThumbBounds().contains(e.getPoint())){
                    thumbColor = Color.GRAY;
                }
                else {
                    thumbColor = Color.LIGHT_GRAY;
                }
                scrollbar.repaint(r);
            }

            /**
             * 处理鼠标按下事件
             * @param e 鼠标事件对象
             */
            @Override
            public void mousePressed(MouseEvent e) {
//                System.out.println("鼠标按下");
                thumbColor = Color.DARK_GRAY;
                super.mousePressed(e);
            }

            /**
             * 处理鼠标进入事件
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseEntered(MouseEvent e) {
//                System.out.println("鼠标进入");
                Rectangle r = getThumbBounds();
                // 如果鼠标进入时不在滑块范围内，不变色
                if (getThumbBounds().contains(e.getPoint())){
                    thumbColor = Color.GRAY;
                    scrollbar.repaint(r);
                }
            }

            /**
             * 处理鼠标退出事件
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseExited(MouseEvent e) {
//                System.out.println("鼠标退出");
                super.mouseExited(e);
                if (isDragging) return;  // 鼠标拖动时移出窗口不变颜色
                Rectangle r = getThumbBounds();
                thumbColor = Color.LIGHT_GRAY;
                scrollbar.repaint(r);
            }
        }

        /**
         * 初始化控件颜色
         */
        @Override
        protected void configureScrollBarColors() {
            super.configureScrollBarColors();
            trackColor = Color.WHITE;
            thumbColor = Color.LIGHT_GRAY;
            thumbHighlightColor = Color.WHITE;
            thumbLightShadowColor = Color.WHITE;
            thumbDarkShadowColor = Color.WHITE;
        }

        /**
         * 初始化UI
         * @param c 控件类
         */
        @Override
        public void installUI(JComponent c) {
            super.installUI(c);

            // 去掉按钮
            scrollbar.remove(decrButton);
            scrollbar.remove(incrButton);
            scrollbar.setOpaque(true);
            scrollbar.setBackground(Color.WHITE);
            scrollbar.repaint();
        }

        /**
         * 获取滚动条大小
         * @param c 组件对象
         * @return 返回尺寸对象
         */
        @Override
        public Dimension getPreferredSize(JComponent c) {
            return (scrollbar.getOrientation() == JScrollBar.VERTICAL)
                    ? new Dimension(10, 48)
                    : new Dimension(48, 10);
        }

        /**
         * 重绘滑块
         * @param g 图形类对象
         * @param c 控件类对象
         * @param thumbBounds 滑块矩形类
         */
        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            if(thumbBounds.isEmpty() || !scrollbar.isEnabled()) {
                return;
            }

            Graphics2D g2d = (Graphics2D)g;

            int w = thumbBounds.width;
            int h = thumbBounds.height;

            g2d.translate(thumbBounds.x, thumbBounds.y);

            g2d.setColor(thumbColor);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.fillRoundRect(0, 0, w - 1, h - 1, 10, 10);

            g2d.translate(-thumbBounds.x, -thumbBounds.y);
        }

        /**
         * 绘制滚动条轨道
         * @param g 画笔对象
         * @param c 组件对象
         * @param trackBounds 轨道大小对象
         */
        @Override
        protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
            g.setColor(trackColor);
            g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
        }

        /**
         * 创建滑轨监听器
         * @return 返回滑轨监听器对象
         */
        @Override
        protected TrackListener createTrackListener() {
            return new MyScrollBarUI.MyScrollBarListener();
        }
    }

    /**
     * 初始化界面
     */
    public CustomScrollPane() {
        super();
        setupUI();
    }

    /**
     * 初始化界面，设置面板大小
     * @param width 宽度
     * @param height 高度
     */
    public CustomScrollPane(int width, int height) {
        this(VERTICAL_AND_HORIZONTAL, width, height);
    }

    /**
     * 初始化界面，设置面板大小及滑动条显示方向
     * @param width 宽度
     * @param height 高度
     * @param direction 滑动条显示方向
     */
    public CustomScrollPane(int direction, int width, int height) {
        this();
        this.setPreferredSize(new Dimension(width, height));
        switch (direction) {
            case VERTICAL -> {
                this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                this.getVerticalScrollBar().setUI(new CustomScrollPane.MyScrollBarUI());
            }
            case HORIZONTAL -> {
                this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
                this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                this.getHorizontalScrollBar().setUI(new CustomScrollPane.MyScrollBarUI());
            }
            case VERTICAL_AND_HORIZONTAL -> {
                this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                this.getVerticalScrollBar().setUI(new CustomScrollPane.MyScrollBarUI());
                this.getHorizontalScrollBar().setUI(new CustomScrollPane.MyScrollBarUI());
            }
            case NONE -> {
                this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
                this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            }
        }
    }

    /**
     * 初始化界面属性
     */
    private void setupUI() {
        this.setBorder(null);
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
    }

}
