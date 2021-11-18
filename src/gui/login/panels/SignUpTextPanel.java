package gui.login.panels;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.shared.components.CustomizedTextBox;

import javax.swing.*;
import java.awt.*;

/**
 * 注册文本框面板类
 * @author Jackie
 */
public class SignUpTextPanel extends JPanel{

    private CustomizedTextBox textBox;
    private JLabel label;

    /**
     * 初始化界面
     * @param labelText 标签文本
     * @param textBoxTipText 密码框提示文本
     */
    public SignUpTextPanel(String labelText, String textBoxTipText){
        super();
        setupUI(labelText, textBoxTipText);
    }

    /**
     * 初始化界面属性
     * @param labelText 标签文本
     * @param textBoxTipText 密码框提示文本
     */
    private void setupUI(String labelText, String textBoxTipText){
        CellConstraints cc = new CellConstraints();
        this.setLayout(new FormLayout("center:d:noGrow,center:10px:noGrow,center:d:noGrow", "center:d:noGrow"));
        this.setOpaque(false);

        label = new JLabel(labelText);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setHorizontalTextPosition(SwingConstants.RIGHT);
        label.setPreferredSize(new Dimension(60, 30));
        label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        this.add(label, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));

        textBox = new CustomizedTextBox(textBoxTipText);
        this.add(textBox, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));

    }

}
