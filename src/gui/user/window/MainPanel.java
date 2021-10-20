package gui.user.window;

import javax.swing.*;
import java.awt.*;

/**
 * 主窗口类
 * @author Jackie
 */
public class MainPanel extends JPanel {

    private FrontPanel mainPanel;
    private BookRepoPanel bookRepoPanel;
    private MyCollectionPanel myCollectionPanel;
    private MyBorrowPanel myBorrowPanel;
    private MySpacePanel mySpacePanel;

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
        mainPanel = new FrontPanel();
        this.add(mainPanel, "mainPanel");  // 0
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
