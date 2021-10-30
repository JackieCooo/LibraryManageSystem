package gui.admin.panels;

import gui.frames.AdminFrame;
import gui.shared.ParentAvailable;

import javax.swing.*;
import java.awt.*;

/**
 * 管理端主窗口类
 * @author Jackie
 */
public class MainWindow extends JPanel implements ParentAvailable<AdminFrame> {

    private AdminFrame parentPanel;
    private FrontPage frontPage;
    private BookManagePage bookManagePage;

    /**
     * 初始化界面
     */
    public MainWindow(){
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setLayout(new CardLayout());
        this.setPreferredSize(new Dimension(700, 600));
        frontPage = new FrontPage();
        this.add(frontPage, "frontPage");  // 0
        bookManagePage = new BookManagePage();
        this.add(bookManagePage, "bookManagePage");  // 1

    }

    @Override
    public void setParentPanel(AdminFrame obj) {
        this.parentPanel = obj;
    }

    @Override
    public AdminFrame getParentPanel(){
        return this.parentPanel;
    }

}
