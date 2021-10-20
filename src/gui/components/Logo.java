package gui.components;

import gui.shared.ParentAvailable;
import gui.shared.components.TopPanel;
import gui.user.window.MainPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 软件logo类
 * @author Jackie
 */
public class Logo extends JLabel implements ParentAvailable<TopPanel> {

    private TopPanel parent;
    private BufferedImage logo;

    /**
     * 初始化界面
     */
    public Logo(String path){
        super();
        setupIcon(path);
        setupUI();
        setupListener();
    }

    /**
     * 设置父级
     * @param obj 父级对象
     */
    @Override
    public void setParentPanel(TopPanel obj) {
        parent = obj;
    }

    /**
     * 获取父级
     * @return 返回父级对象
     */
    @Override
    public TopPanel getParentPanel() {
        return parent;
    }

    /**
     * 初始化监听器
     */
    private void setupListener(){
        this.addMouseListener(new MouseAdapter() {

            /**
             * 鼠标点击返回首页
             * @param e 鼠标事件
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                MainPanel p = getParentPanel().getParentPanel().getMainWindow();
                for (int i = 0; i < p.getComponentCount(); i++) {
                    if (p.getComponent(i).isVisible()) {
                        p.getComponent(i).setVisible(false);
                        break;
                    }
                }
                p.getComponent(0).setVisible(true);
            }

            /**
             * 鼠标进入切换鼠标样式
             * @param e 鼠标事件
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            /**
             * 鼠标退出切换鼠标样式
             * @param e 鼠标事件
             */
            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }

        });
    }

    /**
     * 初始化图标
     */
    private void setupIcon(String path){
        try {
            logo = ImageIO.read(new File(path));
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
