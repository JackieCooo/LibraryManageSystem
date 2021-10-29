package gui.login.components;

import javax.swing.*;
import java.awt.*;

public class BottomBtn extends JLabel {

    public BottomBtn(String text){
        super(text);
        setupUI();
    }

    private void setupUI(){
        this.setPreferredSize(new Dimension(180, 45));
        this.setFont(new Font("微软雅黑", Font.BOLD, 18));
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
    }

}
