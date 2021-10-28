package gui.user.panels;

import gui.frames.UserFrame;
import gui.shared.ParentAvailable;

import javax.swing.*;
import java.awt.*;

/**
 * 主窗口类
 * @author Jackie
 */
public class MainPanel extends JPanel implements ParentAvailable<UserFrame> {

    private UserFrame parent;
    private FrontPanel frontPanel;
    private BookRepoPanel bookRepoPanel;
    private MyCollectionPanel myCollectionPanel;
    private MyBorrowPanel myBorrowPanel;
    private MySpacePanel mySpacePanel;

    /**
     * 设置父级
     * @param obj 父级对象
     */
    @Override
    public void setParentPanel(UserFrame obj) {
        parent = obj;
    }

    /**
     * 获取父级
     * @return 返回父级对象
     */
    @Override
    public UserFrame getParentPanel() {
        return parent;
    }

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
        this.setPreferredSize(new Dimension(900, 600));
        this.setLayout(new CardLayout());

        frontPanel = new FrontPanel();
        frontPanel.setParentPanel(this);
        this.add(frontPanel, "mainPanel");  // 0

        bookRepoPanel = new BookRepoPanel();
        this.add(bookRepoPanel, "bookRepoPanel");  // 1

        myCollectionPanel = new MyCollectionPanel();
        this.add(myCollectionPanel, "myCollectionPanel");  // 2

        myBorrowPanel = new MyBorrowPanel();
        this.add(myBorrowPanel, "myBorrowPanel");  // 3

        mySpacePanel = new MySpacePanel();
        this.add(mySpacePanel, "mySpacePanel");  // 4
    }

}
