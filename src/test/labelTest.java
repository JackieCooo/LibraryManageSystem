package test;

import javax.swing.*;
import java.awt.*;

public class labelTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 300, 300);
        JLabel l1 = new JLabel("标签中的文字1");
        JLabel l2 = new JLabel("标签中的文字2");

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        JPanel p1 = new JPanel();
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
        l1.setAlignmentX(Component.CENTER_ALIGNMENT);
        p1.add(l1);
        p.add(p1);

        JPanel p2 = new JPanel();
        p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
//        l2.setAlignmentX(Component.CENTER_ALIGNMENT);
        p2.add(l2);
        p.add(p2);

        frame.add(p);
        frame.setVisible(true);
    }
}
