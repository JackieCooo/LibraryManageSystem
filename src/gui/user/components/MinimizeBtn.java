package gui.user.components;

import gui.shared.ParentAvailable;
import gui.shared.components.CustomizedMinimizedBtn;
import gui.user.panels.TopPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 用户界面最小化按钮类
 * @author Jackie
 */
public class MinimizeBtn extends CustomizedMinimizedBtn implements ParentAvailable<TopPanel> {

    private TopPanel parent;

    /**
     * 初始化监听器
     */
    @Override
    public void setupListener(){
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
             * 设置鼠标点击事件
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                getParentPanel().getParentPanel().setState(Frame.ICONIFIED);
            }
        });
    }

    /**
     * 设置父级
     * @param obj 父级对象
     */
    @Override
    public void setParentPanel(TopPanel obj) {
        this.parent = obj;
    }

    /**
     * 获取父级
     * @return 返回父级对象
     */
    @Override
    public TopPanel getParentPanel() {
        return this.parent;
    }
}
