package gui.user.window;

import javax.swing.*;
import java.awt.*;

/**
 * 推荐板块类
 * @author Jackie
 */
public class RecommendPanel extends JPanel{

    /**
     * 初始化界面
     */
    public RecommendPanel(){
        super();
        setupUI();
    }

    private void setupUI(){
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 45));
        for (int i = 0; i < 10; i++) {
            BookDisplay b = new BookDisplay(i + "");
            this.add(b);
        }
    }

}
