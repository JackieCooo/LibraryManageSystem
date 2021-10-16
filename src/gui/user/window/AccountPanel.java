package gui.user.window;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.components.AccountOpBtn;
import gui.components.AccountPic;
import gui.shared.LayoutColors;

import javax.swing.*;
import java.awt.*;

/**
 * 账号板块类
 * @author Jackie
 */
public class AccountPanel extends JPanel{

    private AccountPic accountPic;
    private AccountOpBtn accountOpBtn;

    /**
     * 初始化界面
     */
    public AccountPanel(){
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        CellConstraints cc = new CellConstraints();
        this.setLayout(new FormLayout("center:d:noGrow,center:d:noGrow", "center:d:noGrow"));
        this.setPreferredSize(new Dimension(200, 50));
        this.setOpaque(false);
        accountPic = new AccountPic("pics/user.jpg");
        this.add(accountPic, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        accountOpBtn = new AccountOpBtn("马浩同学");
        this.add(accountOpBtn, cc.xy(2, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
    }

}
