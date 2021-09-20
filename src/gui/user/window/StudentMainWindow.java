package gui.user.window;

import javax.swing.*;
import java.awt.*;

/**
 * 用户界面类
 * @author Jackie
 */
public class StudentMainWindow extends JPanel{
    
    private TopPanel topPanel;
    private CentrePanel centrePanel;
    private BottomPanel bottomPanel;

    /**
     * 初始化界面
     */
    public StudentMainWindow(){
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setLayout(new BorderLayout(0, 0));
        this.setPreferredSize(new Dimension(900, 675));

        topPanel = new TopPanel();
        this.add(topPanel, BorderLayout.NORTH);

        centrePanel = new CentrePanel();
        this.add(centrePanel, BorderLayout.CENTER);

        bottomPanel = new BottomPanel();
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

}
