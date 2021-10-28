package gui.login.panels;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.components.LoginPanelBtn;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 学生登录页面
 * @author Jackie
 */
public class StudentLoginPanel extends JPanel{

    private JTextField studentNumField;
    private JPasswordField passwordField;
    private BtnSetPanel btnSet;
    private LoginPanelBtn switch2AdminBtn;
    private MessageArea loginMessage;

    /**
     * 初始化页面
     */
    public StudentLoginPanel(){
        this.setLayout(new FormLayout("center:d:grow", "center:10px:noGrow,center:d:noGrow,center:10px:noGrow,center:d:noGrow,center:10px:noGrow,center:d:noGrow,top:d:grow,bottom:d:noGrow,center:10px:noGrow"));
        this.setPreferredSize(new Dimension(400, 300));
        this.setOpaque(false);
        CellConstraints cc = new CellConstraints();

        studentNumField = new JTextField();
        studentNumField.setMargin(new Insets(2, 6, 2, 6));
        studentNumField.setPreferredSize(new Dimension(250, 30));
        this.add(studentNumField, cc.xy(1, 2, CellConstraints.CENTER, CellConstraints.DEFAULT));

        passwordField = new JPasswordField();
        passwordField.setMargin(new Insets(2, 6, 2, 6));
        passwordField.setPreferredSize(new Dimension(250, 30));
        this.add(passwordField, cc.xy(1, 4, CellConstraints.CENTER, CellConstraints.DEFAULT));

        loginMessage = new MessageArea();
        this.add(loginMessage, cc.xy(1, 6, CellConstraints.CENTER, CellConstraints.DEFAULT));

        btnSet = new BtnSetPanel("登录", "注册");
        btnSet.getRightBtn().addMouseListener(new MouseAdapter() {
            /**
             * 转到学生注册页面
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                Container p = getParent();
                p.getComponent(0).setVisible(false);
                p.getComponent(2).setVisible(true);
            }
        });
        this.add(btnSet, cc.xy(1, 7, CellConstraints.CENTER, CellConstraints.TOP));

        switch2AdminBtn = new LoginPanelBtn(180, 45, "管理员登录");
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
        });
        this.add(switch2AdminBtn, cc.xy(1, 8, CellConstraints.CENTER, CellConstraints.CENTER));

    }

}
