package gui.frames;

import gui.admin.panels.BookManagePanel;
import gui.shared.ParentAvailable;

import javax.swing.*;
import java.awt.*;

public class AddBookFrame extends JDialog implements ParentAvailable<AdminFrame> {

    private AdminFrame parent;

    public AddBookFrame(){
        super();
        setupUI();
    }

    private void setupUI(){
        this.setBounds(0, 0, 400, 300);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setVisible(false);
        this.setModal(true);
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
