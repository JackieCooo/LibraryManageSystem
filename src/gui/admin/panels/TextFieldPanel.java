package gui.admin.panels;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.shared.components.CustomizedTextBox;

import javax.swing.*;
import java.awt.*;

/**
 * 文本域面板类
 * @author Jackie
 */
public class TextFieldPanel extends JPanel {

    private String labelText;
    private CustomizedTextBox textBox;
    private JLabel label;

    /**
     * 初始化界面
     */
    public TextFieldPanel(String text){
        super();
        this.labelText = text;
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(230, 50));
        this.setOpaque(false);
        this.setLayout(new FormLayout("left:d:grow,right:d:grow", "center:d:grow"));
        CellConstraints cc = new CellConstraints();

        textBox = new CustomizedTextBox(180, 30);
        this.add(textBox, cc.xy(2, 1));

        label = new JLabel(labelText);
        label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        this.add(label, cc.xy(1, 1));
    }

}
