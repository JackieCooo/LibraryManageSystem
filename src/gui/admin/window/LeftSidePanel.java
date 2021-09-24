package gui.admin.window;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.frames.AdminFrame;
import gui.shared.ParentAvailable;

import javax.swing.*;
import java.awt.*;

/**
 * 左侧面板类
 * @author Jackie
 */
public class LeftSidePanel extends JPanel implements ParentAvailable<AdminFrame> {

    private AdminFrame parentPanel;
    private LeftSideBtn frontPageBtn;
    private LeftSideBtn bookManagePageBtn;

    /**
     * 初始化界面
     */
    public LeftSidePanel(){
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(200, 600));
        this.setLayout(new FormLayout("fill:d:grow", "center:d:noGrow,center:30px:noGrow,center:d:noGrow"));
        CellConstraints cc = new CellConstraints();

        frontPageBtn = new LeftSideBtn("首页");
        frontPageBtn.setParentPanel(this);
        frontPageBtn.addActionListener(e -> {
            JPanel p = frontPageBtn.getParentPanel().getParentPanel().getMainWindow();
            int n = p.getComponentCount();
            for (int i = 0; i < n; i++) {
                if (p.getComponent(i).isVisible()){
                    p.getComponent(i).setVisible(false);
                    break;
                }
            }
            p.getComponent(0).setVisible(true);
        });
        this.add(frontPageBtn, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));

        bookManagePageBtn = new LeftSideBtn("图书管理");
        bookManagePageBtn.setParentPanel(this);
        bookManagePageBtn.addActionListener(e -> {
            JPanel p = bookManagePageBtn.getParentPanel().getParentPanel().getMainWindow();
            int n = p.getComponentCount();
            for (int i = 0; i < n; i++) {
                if (p.getComponent(i).isVisible()){
                    p.getComponent(i).setVisible(false);
                    break;
                }
            }
            p.getComponent(1).setVisible(true);
        });
        this.add(bookManagePageBtn, cc.xy(1, 3, CellConstraints.CENTER, CellConstraints.DEFAULT));
    }


    /**
     * 设置父级
     *
     * @param obj 父级对象
     */
    @Override
    public void setParentPanel(AdminFrame obj) {
        this.parentPanel = obj;
    }

    /**
     * 获取父级
     *
     * @return 返回父级对象
     */
    @Override
    public AdminFrame getParentPanel() {
        return this.parentPanel;
    }
}
