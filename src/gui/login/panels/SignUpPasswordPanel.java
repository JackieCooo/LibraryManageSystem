package gui.login.panels;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.login.components.PasswordBox;

import javax.swing.*;
import java.awt.*;

/**
 * 注册密码面板类
 * @author Jackie
 */
public class SignUpPasswordPanel extends JPanel{

    private JLabel label;
    private PasswordBox passwordBox;

    /**
     * 初始化界面
     * @param labelText 标签文本
     * @param passwordBoxTipText 密码框提示文本
     */
    public SignUpPasswordPanel(String labelText, String passwordBoxTipText){
        super();
        setupUI(labelText, passwordBoxTipText);
    }

    /**
     * 初始化界面属性
     * @param labelText 标签文本
     * @param passwordBoxTipText 密码框提示文本
     */
    private void setupUI(String labelText, String passwordBoxTipText){
        CellConstraints cc = new CellConstraints();
        this.setOpaque(false);
        this.setLayout(new FormLayout("center:d:noGrow,center:10px:noGrow,center:d:noGrow", "center:d:noGrow"));

        label = new JLabel(labelText);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setHorizontalTextPosition(SwingConstants.RIGHT);
        label.setPreferredSize(new Dimension(60, 30));
        label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        this.add(label, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));

        passwordBox = new PasswordBox(passwordBoxTipText);
        this.add(passwordBox, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
    }

}
