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

    private FuncBtn bookRepoBtn;
    private FuncBtn myCollectBtn;
    private FuncBtn myBorrowBtn;
    private FuncBtn mySpaceBtn;

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
        bookRepoBtn = new FuncBtn("书库");
        this.add(bookRepoBtn, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));

        myCollectBtn = new FuncBtn("我的收藏");
        this.add(myCollectBtn, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));

        myBorrowBtn = new FuncBtn("我的借阅");
        this.add(myBorrowBtn, cc.xy(5, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));

        mySpaceBtn = new FuncBtn("我的空间");
        this.add(mySpaceBtn, cc.xy(7, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
    }

}
