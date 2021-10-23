package gui.components;

import gui.shared.GlobalConstants;
import gui.shared.LayoutColors;
import gui.shared.ParentAvailable;
import gui.shared.components.TopPanel;
import gui.user.window.BottomPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * 底部面板按钮类
 * @author Jackie
 */
public class BottomBtn extends JButton implements ParentAvailable<BottomPanel> {

    private BufferedImage icon;
    private BottomPanel parent;
    private final int jumpIndex;

    /**
     * 设置父级
     * @param obj 父级对象
     */
    @Override
    public void setParentPanel(BottomPanel obj) {
        parent = obj;
    }

    /**
     * 获取父级
     * @return 返回父级对象
     */
    @Override
    public BottomPanel getParentPanel() {
        return parent;
    }

    /**
     * 初始化界面
     */
    public BottomBtn(){
        this(null, 0);
    }

    /**
     * 初始化界面
     * @param label 要在按钮上显示的文字
     * @param index 此按钮跳转到的页码
     */
    public BottomBtn(String label, int index){
        super(label);
        this.jumpIndex = index;
        setupIcon();
        setupUI();
        setupListener();
    }

    private void setupIcon(){
        try {
            switch (jumpIndex) {
                case 1 -> icon = ImageIO.read(new File("icons/RepoBtn.png"));
                case 2 -> icon = ImageIO.read(new File("icons/MyCollectBtn.png"));
                case 3 -> icon = ImageIO.read(new File("icons/MyBorrowBtn.png"));
                case 4 -> icon = ImageIO.read(new File("icons/MySpaceBtn.png"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化监听器
     */
    private void setupListener(){
        this.addMouseListener(new MouseAdapter() {

            /**
             * 鼠标点击执行页面跳转操作
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                Container p = getParent().getParent().getParent();
                p.getComponent(0).setVisible(false);
                p.getComponent(jumpIndex).setVisible(true);
                // 更新按钮状态
                GlobalConstants.pageChange(jumpIndex);
                TopPanel b = getParentPanel().getParentPanel().getParentPanel().getParentPanel().getTopPanel();
                b.getPrePageBtn().stateUpdate();
                b.getNextPageBtn().stateUpdate();
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

    /**
     * 初始化属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(150, 200));
        this.setFont(new Font("微软雅黑", Font.BOLD, 18));
        this.setForeground(Color.WHITE);

        UIDefaults btnDefaults = new UIDefaults();
        btnDefaults.put("Button.backgroundPainter", (Painter<JComponent>)(g2d, c, w, h) -> {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setColor(LayoutColors.BLUE);
            g2d.fillRoundRect(0, 0, 150, 200, 20, 20);
            g2d.drawImage(icon, 35, 35, null);
        });
        btnDefaults.put("Button.contentMargins", new Insets(100, 14, 6, 14));
        this.putClientProperty("Nimbus.Overrides", btnDefaults);
        this.putClientProperty("Nimbus.Overrides.InheritDefaults", false);

    }

}
