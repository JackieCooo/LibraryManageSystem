package gui.frames;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    public LoginFrame(){
        super();
        setupUI();
    }

    private void setupUI(){
        this.setBounds(100, 100, 400, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new CardLayout(0, 0));

        this.setVisible(true);
    }

}
