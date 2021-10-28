package gui.user.panels;

import gui.shared.ParentAvailable;

import javax.swing.*;
import java.awt.*;

/**
 * 窗口首页类
 * @author Jackie
 */
public class FrontPanel extends JPanel implements ParentAvailable<MainPanel> {

    private MainPanel parent;
    private CentrePanel centrePanel;
    private BottomPanel bottomPanel;

    /**
     * 设置父级
     * @param obj 父级对象
     */
    @Override
    public void setParentPanel(MainPanel obj) {
        parent = obj;
    }

    /**
     * 获取父级
     * @return 返回父级对象
     */
    @Override
    public MainPanel getParentPanel() {
        return parent;
    }

    /**
     * 初始化界面
     */
    public FrontPanel(){
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setLayout(new BorderLayout(0, 0));
        this.setPreferredSize(new Dimension(900, 600));

        centrePanel = new CentrePanel();
        this.add(centrePanel, BorderLayout.CENTER);

        bottomPanel = new BottomPanel();
        bottomPanel.setParentPanel(this);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

}
