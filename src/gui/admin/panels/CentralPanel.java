package gui.admin.panels;

import gui.frames.BookFrame;
import gui.shared.ParentAvailable;
import gui.shared.panels.ShadowPanel;

import javax.swing.*;
import java.awt.*;

public class CentralPanel extends ShadowPanel implements ParentAvailable<BookFrame> {

    private BookPanel bookPanel;
    private BottomPanel bottomPanel;
    private BookFrame parent;

    public CentralPanel(){
        super();
        setupUI();
    }

    private void setupUI(){
        bookPanel = new BookPanel();
        this.add(bookPanel);

        bottomPanel = new BottomPanel();
        bottomPanel.setParentPanel(this);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * 设置父级
     * @param obj 父级对象
     */
    @Override
    public void setParentPanel(BookFrame obj) {
        parent = obj;
    }

    /**
     * 获取父级
     * @return 返回父级对象
     */
    @Override
    public BookFrame getParentPanel() {
        return parent;
    }
}
