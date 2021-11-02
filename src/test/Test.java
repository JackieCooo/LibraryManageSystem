package test;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Painter;
import javax.swing.SwingUtilities;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

class F {
    public void base(){
        System.out.println("F");
    }
}

class A extends F {
    public void show(){
        System.out.println("A");
    }
}

class B extends F {
    public void show(){
        System.out.println("B");
    }
}

public class Test {
    public static void main(String[] args) {
/*
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(laf.getName())) {
                        try {
                            UIManager.setLookAndFeel(laf.getClassName());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                for (Map.Entry<Object, Object> entry : UIManager.getLookAndFeelDefaults().entrySet()) {
                    if ((entry.getKey().toString()).startsWith("ProgressBar")) {
                        System.out.println(entry.getKey() + " = " + entry.getValue());
                    }
                }

            }
        });
*/
        F f = new F();
        A a = (A)f;
        a.show();
    }
}