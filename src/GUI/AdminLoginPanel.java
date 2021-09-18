package GUI;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class AdminLoginPanel {
    
    JPanel adminLoginPanel = new JPanel();
    JLabel adminLoginLabel = new JLabel();
    JTextField adminNumField = new JTextField();
    JPasswordField adminPasswordField = new JPasswordField();
    BtnSetPanel adminSignInBtnSet = new BtnSetPanel("登录", "学生登录");
    JLabel adminLoginMessage = new JLabel();
    
    AdminLoginPanel(){
        CellConstraints cc = new CellConstraints();
        adminLoginPanel.setLayout(new FormLayout("fill:d:grow", "center:34px:noGrow,fill:20px:noGrow,center:43px:noGrow,fill:10px:noGrow,center:43px:noGrow,fill:10px:noGrow,center:18px:noGrow,fill:10px:noGrow,center:d:grow"));
        adminLoginPanel.setPreferredSize(new Dimension(400, 300));
        adminLoginPanel.setVisible(false);
        adminLoginPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        adminLoginLabel.setFont(new Font("黑体", Font.BOLD, 24));
        adminLoginLabel.setText("管理员登录");
        adminLoginPanel.add(adminLoginLabel, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        adminNumField.setMargin(new Insets(2, 6, 2, 6));
        adminNumField.setPreferredSize(new Dimension(250, 30));
        adminLoginPanel.add(adminNumField, cc.xy(1, 3, CellConstraints.CENTER, CellConstraints.DEFAULT));
        adminPasswordField.setPreferredSize(new Dimension(250, 30));
        adminLoginPanel.add(adminPasswordField, cc.xy(1, 5, CellConstraints.CENTER, CellConstraints.DEFAULT));

        // 处理转到学生登录页面的按钮事件
        adminSignInBtnSet.rightBtn.addActionListener(e -> {
            Container p = adminLoginPanel.getParent();
            p.getComponent(1).setVisible(false);
            p.getComponent(0).setVisible(true);
        });

        adminLoginPanel.add(adminSignInBtnSet.getBtnSet(), cc.xy(1, 9, CellConstraints.CENTER, CellConstraints.TOP));
        adminLoginMessage.setHorizontalAlignment(0);
        adminLoginMessage.setHorizontalTextPosition(0);
        adminLoginMessage.setPreferredSize(new Dimension(250, 25));
        adminLoginMessage.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        adminLoginMessage.setText("test");
        adminLoginPanel.add(adminLoginMessage, cc.xy(1, 7, CellConstraints.CENTER, CellConstraints.DEFAULT));
    }
    
    JPanel getAdminLoginPanel(){
        return adminLoginPanel;
    }
}
