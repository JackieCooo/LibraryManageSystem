package gui.admin.components;

import gui.admin.panels.MainPanel;
import gui.admin.panels.TopPanel;
import gui.shared.ParentAvailable;
import gui.shared.components.CustomizedLogo;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 管理界面Logo类
 * @author Jackie
 */
public class Logo extends CustomizedLogo implements ParentAvailable<TopPanel> {

    private TopPanel parent;

    /**
     * 初始化监听器
     */
    @Override
    public void setupListener() {
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
}
