package gui.user.window;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.components.BottomBtn;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * 底部面板类
 * @author Jackie
 */
public class BottomPanel extends JPanel{

    private BottomBtn bookRepoBtn;
    private BottomBtn myCollectBtn;
    private BottomBtn myBorrowBtn;
    private BottomBtn mySpaceBtn;

    /**
     * 初始化界面
     */
    public BottomPanel(){
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setLayout(new FormLayout("fill:d:grow,left:10px:noGrow,fill:d:grow,left:10px:noGrow,fill:d:grow,left:10px:noGrow,fill:d:grow", "center:d:grow"));
        this.setPreferredSize(new Dimension(900, 275));
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        CellConstraints cc = new CellConstraints();
        bookRepoBtn = new BottomBtn("书库");
        // 设置转到书库按钮事件
        bookRepoBtn.addActionListener(e -> {
            Container p = bookRepoBtn.getParent().getParent().getParent();
            p.getComponent(0).setVisible(false);
            p.getComponent(1).setVisible(true);
        });
        this.add(bookRepoBtn, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));

        // 设置转到我的收藏按钮事件
        myCollectBtn = new BottomBtn("我的收藏");
        myCollectBtn.addActionListener(e -> {
            Container p = myCollectBtn.getParent().getParent().getParent();
            p.getComponent(0).setVisible(false);
            p.getComponent(2).setVisible(true);
        });
        this.add(myCollectBtn, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));

        // 设置转到我的借阅按钮事件
        myBorrowBtn = new BottomBtn("我的借阅");
        myBorrowBtn.addActionListener(e -> {
            Container p = myBorrowBtn.getParent().getParent().getParent();
            p.getComponent(0).setVisible(false);
            p.getComponent(3).setVisible(true);
        });
        this.add(myBorrowBtn, cc.xy(5, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));

        // 设置转到我的空间按钮事件
        mySpaceBtn = new BottomBtn("我的空间");
        mySpaceBtn.addActionListener(e -> {
            Container p = mySpaceBtn.getParent().getParent().getParent();
            p.getComponent(0).setVisible(false);
            p.getComponent(4).setVisible(true);
        });
        this.add(mySpaceBtn, cc.xy(7, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
    }

}
