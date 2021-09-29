package test;

import javax.swing.*;
import java.awt.*;

public class buttonTest {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 400, 300);

        JPanel panel = new JPanel();

        class MyButton extends JButton {

            public MyButton(){
                super();
                setupUI();
            }

            private void setupUI(){
                this.setPreferredSize(new Dimension(30, 30));
                this.setText("");

            }

        }

        MyButton btn = new MyButton();

        panel.add(btn);
        frame.add(panel);

        frame.setVisible(true);
    }

}
