package gui.shared;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.components.*;
import gui.frames.UserFrame;
import gui.user.window.AccountPanel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * 顶部板块类
 * @author Jackie
 */
public class TopPanel extends JPanel implements ParentAvailable<UserFrame>{

    private Point originPoint = new Point();
    private UserFrame parent;

    private Logo logo;
    private CancelBtn cancelBtn;
    private UndoBtn undoBtn;
    private MessageBtn mailboxBtn;
    private SettingBtn settingBtn;
    private MinimizeBtn minimiseBtn;
    private CloseBtn closeBtn;
    private AccountPanel accountPanel;

    /**
     * 初始化界面
     */
    public TopPanel(){
        super();
        setupUI();
        setupListener();
    }

    private void setupListener(){
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                originPoint.x = e.getX();
                originPoint.y = e.getY();
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
                Point p = getParentPanel().getLocation();
                getParentPanel().setLocation(p.x + e.getX() - originPoint.x, p.y + e.getY() - originPoint.y);
            }

        });
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setLayout(new FormLayout("center:d:noGrow,left:20px:noGrow,fill:d:noGrow,left:10px:noGrow,fill:d:noGrow,left:10px:noGrow,right:p:grow,left:20px:noGrow,center:33px:noGrow,left:10px:noGrow,center:d:noGrow,left:20px:noGrow,center:d:noGrow,left:10px:noGrow,center:d:noGrow", "center:d:grow"));
        this.setPreferredSize(new Dimension(900, 75));
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        this.setOpaque(true);
        this.setBackground(LayoutColors.DARK_BLUE);
        CellConstraints cc = new CellConstraints();
        logo = new Logo("icons/logo.png");
        this.add(logo, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.CENTER));
        cancelBtn = new CancelBtn();
        this.add(cancelBtn, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.CENTER));
        undoBtn = new UndoBtn();
        this.add(undoBtn, cc.xy(5, 1, CellConstraints.CENTER, CellConstraints.CENTER));
        accountPanel = new AccountPanel();
        this.add(accountPanel, cc.xy(7, 1));
        mailboxBtn = new MessageBtn();
        this.add(mailboxBtn, cc.xy(9, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        settingBtn = new SettingBtn();
        this.add(settingBtn, cc.xy(11, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        minimiseBtn = new MinimizeBtn();
        minimiseBtn.setParentPanel(this);
        this.add(minimiseBtn, cc.xy(13, 1, CellConstraints.DEFAULT, CellConstraints.CENTER));
        closeBtn = new CloseBtn();
        this.add(closeBtn, cc.xy(15, 1, CellConstraints.DEFAULT, CellConstraints.CENTER));
    }

    /**
     * 设置父级
     * @param obj 父级对象
     */
    @Override
    public void setParentPanel(UserFrame obj) {
        this.parent = obj;
    }

    /**
     * 获取父级
     * @return 返回父级对象
     */
    @Override
    public UserFrame getParentPanel() {
        return this.parent;
    }
}
