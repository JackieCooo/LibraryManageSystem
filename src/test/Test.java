package test;

import gui.frames.BookFrame;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {

/*
        for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(laf.getName())) {
                try {
                    UIManager.setLookAndFeel(laf.getClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
*/

/*
        for (Map.Entry<Object, Object> entry : UIManager.getLookAndFeelDefaults().entrySet()) {
            if ((entry.getKey().toString()).startsWith("ProgressBar")) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }

        }
*/
        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        BookFrame win = new BookFrame(frame, true);
        JButton btn = new JButton();
        btn.addActionListener(e -> {
            win.setVisible(true);
        });
        frame.add(btn);
        frame.setVisible(true);
    }
}