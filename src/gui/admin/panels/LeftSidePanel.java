package gui.admin.panels;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.admin.components.LeftSideBtn;
import gui.frames.AdminFrame;
import gui.shared.LayoutColors;
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
        this.setPreferredSize(new Dimension(150, 600));
        this.setLayout(new FormLayout("center:d:grow", "center:30px:noGrow,center:d:noGrow,center:30px:noGrow,center:d:noGrow"));
        this.setOpaque(true);
        this.setBackground(LayoutColors.BLUE);
        CellConstraints cc = new CellConstraints();

        frontPageBtn = new LeftSideBtn("首页");
        frontPageBtn.setParentPanel(this);
        frontPageBtn.setState(true);
        frontPageBtn.addActionListener(e -> {
            frontPageBtn.setState(true);
            bookManagePageBtn.setState(false);
            repaint();
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
        this.add(frontPageBtn, cc.xy(1, 2, CellConstraints.CENTER, CellConstraints.DEFAULT));

        bookManagePageBtn = new LeftSideBtn("图书管理");
        bookManagePageBtn.setParentPanel(this);
        bookManagePageBtn.addActionListener(e -> {
            bookManagePageBtn.setState(true);
            frontPageBtn.setState(false);
            repaint();
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
        this.add(bookManagePageBtn, cc.xy(1, 4, CellConstraints.CENTER, CellConstraints.DEFAULT));
    }


    /**
     * 设置父级
     * @param obj 父级对象
     */
    @Override
    public void setParentPanel(AdminFrame obj) {
        this.parentPanel = obj;
    }

    /**
     * 获取父级
     * @return 返回父级对象
     */
    @Override
    public AdminFrame getParentPanel() {
        return this.parentPanel;
    }
}
