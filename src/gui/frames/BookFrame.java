package gui.frames;

import gui.admin.panels.AddBookPanel;
import gui.admin.panels.DialogTopPanel;

import javax.swing.*;
import java.awt.*;

public class AddBookFrame extends JDialog {

    private DialogTopPanel topPanel;
    private AddBookPanel addBookPanel;

    public AddBookFrame(JFrame owner, boolean model){
        super(owner, model);
        setupUI();
    }

    private void setupUI(){
        this.setBounds(0, 0, 500, 400);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setVisible(false);

        topPanel = new DialogTopPanel();
        this.add(topPanel, BorderLayout.NORTH);

        addBookPanel = new AddBookPanel();
        this.add(addBookPanel);
    }

}
