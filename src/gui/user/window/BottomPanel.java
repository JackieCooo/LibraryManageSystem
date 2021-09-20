package gui.user.window;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * 底部板块类
 * @author Jackie
 */
public class BottomPanel extends JPanel{

    private BottomFuncBtn bookRepoBtn;
    private BottomFuncBtn myCollectBtn;
    private BottomFuncBtn myBorrowBtn;
    private BottomFuncBtn mySpaceBtn;

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
        bookRepoBtn = new BottomFuncBtn("书库");
        // 设置转到书库事件
        bookRepoBtn.addActionListener(e -> {
            Container p = bookRepoBtn.getParent().getParent().getParent();
            p.getComponent(0).setVisible(false);
            p.getComponent(1).setVisible(true);
        });
        this.add(bookRepoBtn, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));

        myCollectBtn = new BottomFuncBtn("我的收藏");
        this.add(myCollectBtn, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));

        myBorrowBtn = new BottomFuncBtn("我的借阅");
        this.add(myBorrowBtn, cc.xy(5, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));

        mySpaceBtn = new BottomFuncBtn("我的空间");
        this.add(mySpaceBtn, cc.xy(7, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
    }

}
