package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginTest {
    public static void main(String[] args) {
        JFrame a = new JFrame();
        a.setLayout(new CardLayout(0, 0));
        JPanel p1 = new JPanel();
        JButton b1 = new JButton();
        p1.add(b1);
        JPanel p2 = new JPanel();
        JButton b2 = new JButton();
        p1.add(b2);
        JPanel p3 = new JPanel();
        JButton b3 = new JButton();
        p1.add(b3);
        JFrame b = new JFrame();

        JButton btn = new JButton("switch");
        a.setBounds(100, 100, 300, 200);
        a.add(p1, "p1");
        a.add(p2, "p2");
        a.add(p3, "p3");

        b.setBounds(100, 100, 400, 300);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a.setVisible(false);
                b.setVisible(true);
            }
        });
//        a.add(btn);
        System.out.println(a.getComponentCount());
        a.setVisible(true);
    }
}
