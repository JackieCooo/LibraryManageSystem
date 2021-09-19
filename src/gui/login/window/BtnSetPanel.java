package gui.login.window;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;

/**
 * 按钮组合界面
 * @author Jackie
 */
public class BtnSetPanel {

    private JPanel btnSet;
    private JButton leftBtn;
    private JButton rightBtn;

    /**
     * 构造函数说明
     * @param leftBtnName 左按钮文字
     * @param rightBtnName 右按钮文字
     */
    public BtnSetPanel(String leftBtnName, String rightBtnName){
        btnSet = new JPanel();
        CellConstraints cc = new CellConstraints();
        btnSet.setLayout(new FormLayout("fill:103px:grow,left:50px:noGrow,fill:d:grow", "center:d:grow"));
        leftBtn = new JButton();
        leftBtn.setHorizontalTextPosition(0);
        leftBtn.setPreferredSize(new Dimension(100, 40));
        leftBtn.setText(leftBtnName);
        btnSet.add(leftBtn, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        rightBtn = new JButton();
        rightBtn.setHorizontalTextPosition(0);
        rightBtn.setPreferredSize(new Dimension(100, 40));
        rightBtn.setText(rightBtnName);
        btnSet.add(rightBtn, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
    }

    /**
     * 获取按钮组合界面
     * @return JPanel
     */
    public JPanel getBtnSet(){
        return btnSet;
    }

    /**
     * 获取左按钮
     * @return JButton
     */
    public JButton getLeftBtn() {
        return leftBtn;
    }

    /**
     * 获取右按钮
     * @return JButton
     */
    public JButton getRightBtn() {
        return rightBtn;
    }
}
