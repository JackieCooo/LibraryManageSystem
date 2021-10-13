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

public class Test {
    public static void main(String[] args) {
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
                    if ((entry.getKey().toString()).startsWith("TabbedPane")) {
                        System.out.println(entry.getKey() + " = " + entry.getValue());
                    }
                }

                JFrame frame = new JFrame("TextField Skining Demo");
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.getContentPane().setLayout(new BorderLayout());
                JPanel panel = new JPanel(new GridLayout(0, 1, 20, 20));
                panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                panel.setBackground(Color.darkGray);

                UIDefaults textFieldDefaults = new UIDefaults();
                textFieldDefaults.put("TextField.contentMargins", new Insets(6,
                        6, 6, 6));
                textFieldDefaults.put("TextField[Selected].textForeground",
                        Color.WHITE);
                textFieldDefaults.put("TextField.backgroundPainter",
                        new Painter<JComponent>() {
                            public void paint(Graphics2D g, JComponent c,
                                              int w, int h) {
                                g.setRenderingHint(
                                        RenderingHints.KEY_ANTIALIASING,
                                        RenderingHints.VALUE_ANTIALIAS_ON);
                                g.setStroke(new BasicStroke(2f));
                                g.setColor(Color.WHITE);
                                g.fillRoundRect(0, 0, w - 2, h - 2, 8, 8);
                            }
                        });
                textFieldDefaults.put("TextField.borderPainter",
                        new Painter<JComponent>() {
                            public void paint(Graphics2D g, JComponent c,
                                              int w, int h) {
                                g.setRenderingHint(
                                        RenderingHints.KEY_ANTIALIASING,
                                        RenderingHints.VALUE_ANTIALIAS_ON);
                                g.setStroke(new BasicStroke(2f));
                                g.setColor(Color.LIGHT_GRAY);
                                g.drawRoundRect(0, 0, w - 2, h - 2, 8, 8);
                            }
                        });

                JTextField textField = new JTextField(15);
                panel.add(textField);
                textField.putClientProperty("Nimbus.Overrides", textFieldDefaults);
                textField.putClientProperty("Nimbus.Overrides.InheritDefaults", false);

                // Add a normal themed slider for comparison
                JTextField normalTextField = new JTextField(15);
                panel.add(normalTextField);

                frame.getContentPane().add(panel, BorderLayout.CENTER);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}