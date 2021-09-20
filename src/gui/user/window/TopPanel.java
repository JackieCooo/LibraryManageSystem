package gui.user.window;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * 顶部板块类
 * @author Jackie
 */
public class TopPanel extends JPanel{

    private JLabel softwareLabel;
    private TopFuncBtn cancelBtn;
    private TopFuncBtn undoBtn;
    private TopFuncBtn mailboxBtn;
    private TopFuncBtn settingBtn;
    private TopWinFuncBtn minimiseBtn;
    private TopWinFuncBtn closeBtn;
    private AccountPanel accountPanel;

    /**
     * 初始化界面
     */
    public TopPanel(){
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setLayout(new FormLayout("center:d:noGrow,left:20px:noGrow,fill:d:noGrow,left:10px:noGrow,fill:d:noGrow,left:10px:noGrow,right:p:grow,left:20px:noGrow,center:33px:noGrow,left:10px:noGrow,center:d:noGrow,left:20px:noGrow,center:d:noGrow,left:10px:noGrow,center:d:noGrow", "center:d:grow"));
        this.setPreferredSize(new Dimension(900, 75));
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        softwareLabel = new JLabel();
        softwareLabel.setHorizontalAlignment(0);
        softwareLabel.setHorizontalTextPosition(0);
        softwareLabel.setPreferredSize(new Dimension(200, 50));
        softwareLabel.setText("test");
        CellConstraints cc = new CellConstraints();
        this.add(softwareLabel, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.CENTER));
        cancelBtn = new TopFuncBtn();
        this.add(cancelBtn, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.CENTER));
        undoBtn = new TopFuncBtn();
        this.add(undoBtn, cc.xy(5, 1, CellConstraints.CENTER, CellConstraints.CENTER));
        accountPanel = new AccountPanel();
        this.add(accountPanel.getAccountPanel(), cc.xy(7, 1));
        mailboxBtn = new TopFuncBtn();
        this.add(mailboxBtn, cc.xy(9, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        settingBtn = new TopFuncBtn();
        this.add(settingBtn, cc.xy(11, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        minimiseBtn = new TopWinFuncBtn();
        this.add(minimiseBtn, cc.xy(13, 1, CellConstraints.DEFAULT, CellConstraints.CENTER));
        closeBtn = new TopWinFuncBtn();
        // 设置关闭窗口事件
        closeBtn.addActionListener(e -> {
            System.exit(0);
        });
        this.add(closeBtn, cc.xy(15, 1, CellConstraints.DEFAULT, CellConstraints.CENTER));
    }

}
