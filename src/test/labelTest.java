package test;

import javax.swing.*;
import java.awt.*;

public class labelTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 300, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("标签中的文字1");
        l1.setPreferredSize(new Dimension(300, 200));
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setOpaque(true);
        l1.setBackground(Color.BLUE);

        frame.add(l1);
        frame.setVisible(true);
    }
}
