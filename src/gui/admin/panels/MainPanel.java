package gui.admin.panels;

import gui.frames.AdminFrame;
import gui.shared.ParentAvailable;

import javax.swing.*;
import java.awt.*;

/**
 * 管理端主窗口类
 * @author Jackie
 */
public class MainPanel extends JPanel implements ParentAvailable<AdminFrame> {

    private AdminFrame parent;
    private FrontPanel frontPanel;
    private BookManagePanel bookManagePanel;

    /**
     * 初始化界面
     */
    public MainPanel(){
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setLayout(new CardLayout(0, 0));
        this.setPreferredSize(new Dimension(750, 600));
        this.setOpaque(true);
        this.setBackground(Color.WHITE);

        frontPanel = new FrontPanel();
        this.add(frontPanel, "frontPage");  // 0

        bookManagePanel = new BookManagePanel();
        this.add(bookManagePanel, "bookManagePage");  // 1

        frontPanel.setVisible(false);
        bookManagePanel.setVisible(true);
    }

    /**
     * 设置父级
     * @param obj 父级对象
     */
    @Override
    public void setParentPanel(AdminFrame obj) {
        parent = obj;
    }

    /**
     * 获取父级
     * @return 返回父级对象
     */
    @Override
    public AdminFrame getParentPanel(){
        return parent;
    }

}
