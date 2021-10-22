package gui.user.window;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.components.BottomBtn;
import gui.shared.ParentAvailable;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * 底部面板类
 * @author Jackie
 */
public class BottomPanel extends JPanel implements ParentAvailable<FrontPanel> {

    private FrontPanel parent;
    private BottomBtn bookRepoBtn;
    private BottomBtn myCollectBtn;
    private BottomBtn myBorrowBtn;
    private BottomBtn mySpaceBtn;

    /**
     * 设置父级
     * @param obj 父级对象
     */
    @Override
    public void setParentPanel(FrontPanel obj) {
        parent = obj;
    }

    /**
     * 获取父级
     * @return 返回父级对象
     */
    @Override
    public FrontPanel getParentPanel() {
        return parent;
    }

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
        bookRepoBtn = new BottomBtn("书库", 1);
        bookRepoBtn.setParentPanel(this);
        this.add(bookRepoBtn, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));

        myCollectBtn = new BottomBtn("我的收藏", 2);
        myCollectBtn.setParentPanel(this);
        this.add(myCollectBtn, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));

        myBorrowBtn = new BottomBtn("我的借阅", 3);
        myBorrowBtn.setParentPanel(this);
        this.add(myBorrowBtn, cc.xy(5, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));

        mySpaceBtn = new BottomBtn("我的空间", 4);
        mySpaceBtn.setParentPanel(this);
        this.add(mySpaceBtn, cc.xy(7, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
    }

}
