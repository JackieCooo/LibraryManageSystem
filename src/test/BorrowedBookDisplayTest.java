package test;

import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;

class BorrowedBookDisplay extends JPanel {

    private BookDisplay bookDisplay;

    public BorrowedBookDisplay(){
        this(0);
    }

    public BorrowedBookDisplay(int val){
        super();
        setupUI();
    }

    private void setupUI(){
        this.setPreferredSize(new Dimension(170, 200));
        this.setLayout(new FormLayout("center:d:noGrow,center:10px:noGrow,center:d:noGrow", "center:d:noGrow"));
        
    }

}


public class BorrowedBookDisplayTest {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        BorrowedBookDisplay display = new BorrowedBookDisplay();
        panel.add(display);
        frame.add(panel);
        frame.setVisible(true);
    }

}
