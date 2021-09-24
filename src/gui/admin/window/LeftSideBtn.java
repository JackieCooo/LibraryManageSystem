package gui.admin.window;

import gui.shared.ParentAvailable;

import javax.swing.*;
import java.awt.*;

/**
 * 左侧按钮类
 * @author Jackie
 */
public class LeftSideBtn extends JButton implements ParentAvailable<LeftSidePanel> {

    private LeftSidePanel parentPanel;

    /**
     * 初始化界面
     */
    public LeftSideBtn(){
        super();
        setupUI();
    }

    /**
     * 初始化界面
     */
    public LeftSideBtn(String label){
        super(label);
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(150, 40));
    }

    /**
     * 设置父级
     * @param obj 父级对象
     */
    @Override
    public void setParentPanel(LeftSidePanel obj) {
        this.parentPanel = obj;
    }

    /**
     * 获取父级
     * @return 返回父级对象
     */
    @Override
    public LeftSidePanel getParentPanel() {
        return this.parentPanel;
    }
}
