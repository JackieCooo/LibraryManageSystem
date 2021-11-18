package gui.login.panels;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.shared.components.CustomizedOpBtn;

import javax.swing.*;

/**
 * 按钮组合界面
 * @author Jackie
 */
public class BtnSetPanel extends JPanel{

    private CustomizedOpBtn leftBtn;
    private CustomizedOpBtn rightBtn;

    /**
     * 构造函数说明
     * @param leftBtnName 左按钮文字
     * @param rightBtnName 右按钮文字
     */
    public BtnSetPanel(String leftBtnName, String rightBtnName){
        this.setOpaque(false);
        CellConstraints cc = new CellConstraints();
        this.setLayout(new FormLayout("center:d:noGrow,center:50px:noGrow,center:d:noGrow", "center:d:grow"));
        leftBtn = new CustomizedOpBtn(leftBtnName, 100, 40);
        this.add(leftBtn, cc.xy(1, 1, CellConstraints.DEFAULT, CellConstraints.DEFAULT));

        rightBtn = new CustomizedOpBtn(rightBtnName, 100, 40);
        this.add(rightBtn, cc.xy(3, 1, CellConstraints.DEFAULT, CellConstraints.DEFAULT));
    }

    /**
     * 获取左按钮
     * @return JButton
     */
    public CustomizedOpBtn getLeftBtn() {
        return leftBtn;
    }

    /**
     * 获取右按钮
     * @return JButton
     */
    public CustomizedOpBtn getRightBtn() {
        return rightBtn;
    }
}
