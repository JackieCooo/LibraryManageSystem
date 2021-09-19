package GUI;

import javax.swing.*;
import java.awt.*;

public class FuncBtn extends JButton {

    public FuncBtn(){
        super();
        setupUI();
    }

    public FuncBtn(String label){
        super(label);
        setupUI();
    }

    private void setupUI(){
        this.setPreferredSize(new Dimension(150, 200));
    }

}
