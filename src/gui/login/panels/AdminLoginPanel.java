package gui.login.panels;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.login.components.MessageArea;
import gui.login.components.PasswordBox;
import gui.login.components.TextBox;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * 管理员登录页面
 * @author Jackie
 */
public class AdminLoginPanel extends JPanel{
    
    private JLabel adminLoginLabel;
    private TextBox adminNumField;
    private PasswordBox adminPasswordField;
    private BtnSetPanel adminSignInBtnSet;
    private MessageArea adminLoginMessage;

    /**
     * 初始化页面
     */
    public AdminLoginPanel(){
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        CellConstraints cc = new CellConstraints();
        this.setLayout(new FormLayout("center:d:grow", "center:d:noGrow,center:10px:noGrow,center:d:noGrow,center:10px:noGrow,center:d:noGrow,center:d:noGrow,top:d:grow"));
        this.setPreferredSize(new Dimension(400, 270));
        this.setOpaque(false);

        adminLoginLabel = new JLabel("管理员登录");
        adminLoginLabel.setFont(new Font("黑体", Font.BOLD, 24));
        this.add(adminLoginLabel, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));

        adminNumField = new TextBox("管理员用户名");
        this.add(adminNumField, cc.xy(1, 3, CellConstraints.CENTER, CellConstraints.DEFAULT));

        adminPasswordField = new PasswordBox("密码");
        this.add(adminPasswordField, cc.xy(1, 5, CellConstraints.CENTER, CellConstraints.DEFAULT));

        adminLoginMessage = new MessageArea();
        this.add(adminLoginMessage, cc.xy(1, 6, CellConstraints.CENTER, CellConstraints.DEFAULT));

        adminSignInBtnSet = new BtnSetPanel("登录", "学生登录");
        // 处理转到学生登录页面的按钮事件
        adminSignInBtnSet.getRightBtn().addActionListener(e -> {
            Container p = this.getParent();
            p.getComponent(1).setVisible(false);
            p.getComponent(0).setVisible(true);
        });
        this.add(adminSignInBtnSet, cc.xy(1, 7, CellConstraints.CENTER, CellConstraints.TOP));

    }
}
