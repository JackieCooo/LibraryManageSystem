package gui.login.panels;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.login.components.BottomBtn;
import gui.login.components.MessageArea;
import gui.shared.components.CustomizedTextBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 学生登录页面
 * @author Jackie
 */
public class UserLoginPanel extends JPanel{

    private CustomizedTextBox studentNumField;
    private LoginPasswordPanel passwordField;
    private BtnSetPanel btnSet;
    private BottomBtn switch2AdminBtn;
    private MessageArea loginMessage;

    /**
     * 初始化页面
     */
    public UserLoginPanel(){
        this.setLayout(new FormLayout("center:d:grow", "center:10px:noGrow,center:d:noGrow,center:10px:noGrow,center:d:noGrow,center:10px:noGrow,center:d:noGrow,top:d:grow,bottom:d:noGrow,center:10px:noGrow"));
        this.setPreferredSize(new Dimension(400, 270));
        this.setOpaque(false);
        CellConstraints cc = new CellConstraints();

        studentNumField = new CustomizedTextBox("账号");
        this.add(studentNumField, cc.xy(1, 2, CellConstraints.CENTER, CellConstraints.DEFAULT));

        passwordField = new LoginPasswordPanel();
        this.add(passwordField, cc.xy(1, 4, CellConstraints.CENTER, CellConstraints.DEFAULT));

        loginMessage = new MessageArea();
        this.add(loginMessage, cc.xy(1, 6, CellConstraints.CENTER, CellConstraints.DEFAULT));

        btnSet = new BtnSetPanel("登录", "注册");
        btnSet.getRightBtn().addActionListener(e ->  {
            Container p = getParent();
            p.getComponent(0).setVisible(false);
            p.getComponent(2).setVisible(true);
        });
        this.add(btnSet, cc.xy(1, 7, CellConstraints.CENTER, CellConstraints.TOP));

        switch2AdminBtn = new BottomBtn("管理员登录", 180, 45);
        switch2AdminBtn.addMouseListener(new MouseAdapter() {
            /**
             * 转到管理员登录界面
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                Container p = getParent();
                p.getComponent(0).setVisible(false);
                p.getComponent(1).setVisible(true);
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
        this.add(switch2AdminBtn, cc.xy(1, 8, CellConstraints.CENTER, CellConstraints.CENTER));

    }

}
