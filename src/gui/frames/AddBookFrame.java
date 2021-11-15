package gui.frames;

import javax.swing.*;

public class AddBookFrame extends JDialog {

    public AddBookFrame(){
        super();
        setupUI();
    }

    private void setupUI(){
        this.setBounds(0, 0, 400, 300);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
    }

}
