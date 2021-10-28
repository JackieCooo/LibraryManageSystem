package gui.user.panels;

import javax.swing.*;
import java.awt.*;

/**
 * 我的收藏窗口类
 * @author Jackie
 */
public class MyCollectionPanel extends JScrollPane {

    private JPanel myCollectionPanel;

    /**
     * 初始化界面
     */
    public MyCollectionPanel(){
        super(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(900, 600));
        myCollectionPanel = new JPanel();
        myCollectionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        myCollectionPanel.setPreferredSize(new Dimension(900, 600));
        myCollectionPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 30));
        this.add(myCollectionPanel);
    }

}
