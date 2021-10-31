package gui.login.panels;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.login.components.BottomBtn;
import gui.login.components.MessageArea;
import gui.login.components.OpBtn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 用户注册面板类
 * @author Jackie
 */
public class UserSignUpPanel extends JPanel{

    private OpBtn signUpBtn;
    private JLabel signUpLabel;
    private BottomBtn signUp2Login;
    private MessageArea signUpMessage;
    private SignUpTextPanel userNumPanel;
    private SignUpPasswordPanel passwordPanel;
    private SignUpPasswordPanel passwordConfirmPanel;

    /**
     * 初始化界面
     */
    public UserSignUpPanel(){
        this.setOpaque(false);
        CellConstraints cc = new CellConstraints();
        this.setLayout(new FormLayout("center:d:grow", "center:d:noGrow,center:10px:noGrow,center:d:noGrow,center:10px:noGrow,center:d:noGrow,center:10px:noGrow,center:d:noGrow,center:d:noGrow,top:d:grow,bottom:d:noGrow"));
        this.setPreferredSize(new Dimension(400, 270));
        
        signUpLabel = new JLabel("注册");
        signUpLabel.setHorizontalAlignment(SwingConstants.CENTER);
        signUpLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        signUpLabel.setFont(new Font("黑体", Font.BOLD, 24));
        this.add(signUpLabel, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));

        userNumPanel = new SignUpTextPanel("用户名", "用户名");
        this.add(userNumPanel, cc.xy(1, 3, CellConstraints.CENTER, CellConstraints.DEFAULT));

        passwordPanel = new SignUpPasswordPanel("密码", "密码");
        this.add(passwordPanel, cc.xy(1, 5, CellConstraints.CENTER, CellConstraints.DEFAULT));

        passwordConfirmPanel = new SignUpPasswordPanel("确认密码", "确认密码");
        this.add(passwordConfirmPanel, cc.xy(1, 7, CellConstraints.CENTER, CellConstraints.DEFAULT));

        signUpMessage = new MessageArea();
        this.add(signUpMessage, cc.xy(1, 8, CellConstraints.CENTER, CellConstraints.DEFAULT));

        signUpBtn = new OpBtn("注册", 250, 40);
        this.add(signUpBtn, cc.xy(1, 9, CellConstraints.CENTER, CellConstraints.TOP));

        signUp2Login = new BottomBtn("前往登录", 250, 40);
        signUp2Login.addMouseListener(new MouseAdapter() {

            /**
             * 点击转至登录页面
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                Container p = getParent();
                p.getComponent(2).setVisible(false);
                p.getComponent(0).setVisible(true);
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
        this.add(signUp2Login, cc.xy(1, 10, CellConstraints.CENTER, CellConstraints.BOTTOM));

    }
    
}
