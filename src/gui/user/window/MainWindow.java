package gui.user.window;

import javax.swing.*;
import java.awt.*;

/**
 * 主窗口类
 * @author Jackie
 */
public class MainWindow extends JPanel {

    private MainPanel mainPanel;
    private BookRepoPanel bookRepoPanel;

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
        this.setPreferredSize(new Dimension(900, 600));
        this.setLayout(new CardLayout());
        mainPanel = new MainPanel();
        this.add(mainPanel, "mainPanel");
        bookRepoPanel = new BookRepoPanel();
        this.add(bookRepoPanel, "bookRepoPanel");
    }
}
