package gui.admin.components;

import gui.shared.components.CustomizedCloseBtn;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DialogCloseBtn extends CustomizedCloseBtn {

    @Override
    protected void setupListener() {
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
             * 设置鼠标点击关闭弹出窗口
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
    }
}
