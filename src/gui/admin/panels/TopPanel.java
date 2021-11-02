package gui.admin.panels;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.admin.components.Logo;
import gui.frames.AdminFrame;
import gui.shared.LayoutColors;
import gui.shared.ParentAvailable;
import gui.shared.components.*;
import gui.shared.panels.AccountPanel;
import gui.admin.components.MinimizeBtn;

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
public class TopPanel extends JPanel implements ParentAvailable<AdminFrame> {

    private Point originPoint = new Point();
    private AdminFrame parent;

    private Logo logo;
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

    /**
     * 初始化监听器
     */
    private void setupListener(){
        this.addMouseListener(new MouseAdapter() {

            /**
             * 按下鼠标记录当前鼠标坐标
             * @param e 鼠标事件对象
             */
            @Override
            public void mousePressed(MouseEvent e) {
                originPoint.x = e.getX();
                originPoint.y = e.getY();
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {

            /**
             * 拖动鼠标移动窗口
             * @param e 鼠标事件对象
             */
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
        this.setLayout(new FormLayout("center:d:noGrow,right:d:grow,center:10px:noGrow,center:d:noGrow,center:10px:noGrow,center:d:noGrow,center:10px:noGrow,center:d:noGrow", "center:d:grow"));
        this.setPreferredSize(new Dimension(900, 75));
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        this.setOpaque(true);
        this.setBackground(LayoutColors.DARK_BLUE);
        CellConstraints cc = new CellConstraints();
        logo = new Logo();
        logo.setParentPanel(this);
        this.add(logo, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.CENTER));
        accountPanel = new AccountPanel();
        this.add(accountPanel, cc.xy(2, 1));
        settingBtn = new SettingBtn();
        this.add(settingBtn, cc.xy(4, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        minimiseBtn = new MinimizeBtn();
        minimiseBtn.setParentPanel(this);
        this.add(minimiseBtn, cc.xy(6, 1, CellConstraints.DEFAULT, CellConstraints.CENTER));
        closeBtn = new CloseBtn();
        this.add(closeBtn, cc.xy(8, 1, CellConstraints.DEFAULT, CellConstraints.CENTER));
    }

    /**
     * 设置父级
     * @param obj 父级对象
     */
    @Override
    public void setParentPanel(AdminFrame obj) {
        parent = obj;
    }

    /**
     * 获取父级
     * @return 返回父级对象
     */
    @Override
    public AdminFrame getParentPanel() {
        return parent;
    }
}
