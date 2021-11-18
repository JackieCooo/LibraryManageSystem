package gui.admin.panels;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.frames.BookFrame;
import gui.shared.ParentAvailable;
import gui.shared.components.CustomizedOpBtn;

import javax.swing.*;
import java.awt.*;

/**
 * 底部面板类
 * @author Jackie
 */
public class BottomPanel extends JPanel implements ParentAvailable<CentralPanel> {

    private CentralPanel parent;
    private CustomizedOpBtn okBtn;
    private CustomizedOpBtn cancelBtn;

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
        this.setPreferredSize(new Dimension(500, 50));
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
        this.setLayout(new FormLayout("right:d:grow,center:20px:noGrow,left:d:grow", "top:d:grow"));
        CellConstraints cc = new CellConstraints();

        okBtn = new CustomizedOpBtn("确定", 100, 30);
        okBtn.addActionListener(e -> {

        });
        this.add(okBtn, cc.xy(1, 1));

        cancelBtn = new CustomizedOpBtn("取消", 100, 30);
        cancelBtn.addActionListener(e -> getParentPanel().getParentPanel().dispose());
        this.add(cancelBtn, cc.xy(3, 1));
    }

    /**
     * 设置父级
     * @param obj 父级对象
     */
    @Override
    public void setParentPanel(CentralPanel obj) {
        parent = obj;
    }

    /**
     * 获取父级
     * @return 返回父级对象
     */
    @Override
    public CentralPanel getParentPanel() {
        return parent;
    }
}
