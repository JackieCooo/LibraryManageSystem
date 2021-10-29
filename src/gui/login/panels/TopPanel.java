package gui.login.panels;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.frames.LoginFrame;
import gui.shared.ParentAvailable;
import gui.shared.components.CloseBtn;
import gui.shared.components.MinimizeBtn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class TopPanel extends JPanel implements ParentAvailable<LoginFrame> {

    private Point originPoint = new Point();
    private LoginFrame parent;
    private CloseBtn closeBtn;
    private MinimizeBtn minimizeBtn;

    public TopPanel(){
        super();
        setupUI();
        setupListener();
    }

    /**
     * 设置父级
     * @param obj 父级对象
     */
    @Override
    public void setParentPanel(LoginFrame obj) {
        parent = obj;
    }

    /**
     * 获取父级
     * @return 返回父级对象
     */
    @Override
    public LoginFrame getParentPanel() {
        return parent;
    }

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

    private void setupUI(){
        this.setPreferredSize(new Dimension(400, 30));
        this.setLayout(new FormLayout("center:d:grow,center:d:noGrow,center:10px:noGrow,center:d:noGrow,center:5px:noGrow", "center:d:grow"));
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
        CellConstraints cc = new CellConstraints();

        closeBtn = new CloseBtn();
        this.add(closeBtn, cc.xy(4, 1, CellConstraints.CENTER, CellConstraints.CENTER));

        minimizeBtn = new MinimizeBtn();
        this.add(minimizeBtn, cc.xy(2, 1, CellConstraints.CENTER, CellConstraints.CENTER));
    }
}
