package gui.user.window;

import javax.swing.*;
import java.awt.*;

/**
 * 窗口首页类
 * @author Jackie
 */
public class FrontPanel extends JPanel{
    
    private CentrePanel centrePanel;
    private BottomPanel bottomPanel;

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
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

}
