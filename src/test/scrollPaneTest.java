package test;

import gui.shared.LayoutColors;
import gui.shared.components.CustomScrollPane;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;


public class scrollPaneTest {

    public static void main(String[] args) {
        JFrame frame = new JFrame("滚动测试");
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        class CustomScrollPane extends JScrollPane {

            protected final static int VERTICAL = 0;
            protected final static int HORIZONTAL = 1;
            protected final static int VERTICAL_AND_HORIZONTAL = 2;
            protected final static int NONE = 3;

            /**
             * 初始化界面
             */
            public CustomScrollPane() {
                super();
                setupUI();
            }

            /**
             * 初始化界面，设置面板大小
             * @param width 宽度
             * @param height 高度
             */
            public CustomScrollPane(int width, int height) {
                this(VERTICAL_AND_HORIZONTAL, width, height);
            }

            /**
             * 初始化界面，设置面板大小及滑动条显示方向
             * @param width 宽度
             * @param height 高度
             * @param direction 滑动条显示方向
             */
            public CustomScrollPane(int direction, int width, int height) {
                this();
                this.setPreferredSize(new Dimension(width, height));
                switch (direction) {
                    case VERTICAL -> {
                        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                    }
                    case HORIZONTAL -> {
                        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
                        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    }
                    case VERTICAL_AND_HORIZONTAL -> {
                        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    }
                    case NONE -> {
                        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
                        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                    }
                }
            }

            /**
             * 初始化界面属性
             */
            private void setupUI() {
                this.setBorder(null);
                this.setOpaque(true);
                this.setBackground(Color.WHITE);

                UIDefaults barDefaults = new UIDefaults();
                barDefaults.put("ScrollBar:ScrollBarThumb.backgroundPainter", (Painter<JComponent>)(g2d, c, w, h) -> {
                    g2d.setColor(LayoutColors.LIGHTEST_GRAY);
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2d.fillRoundRect(0, 0, w, h, 10, 10);
                });
                barDefaults.put("ScrollBar:ScrollBarThumb[MouseOver].backgroundPainter", (Painter<JComponent>)(g2d, c, w, h) -> {
                    g2d.setColor(LayoutColors.LIGHT_GRAY);
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2d.fillRoundRect(0, 0, w, h, 10, 10);
                });
                barDefaults.put("ScrollBar:ScrollBarThumb[Pressed].backgroundPainter", (Painter<JComponent>)(g2d, c, w, h) -> {
                    g2d.setColor(LayoutColors.GRAY);
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2d.fillRoundRect(0, 0, w, h, 10, 10);
                });
                this.getVerticalScrollBar().putClientProperty("Nimbus.Overrides", barDefaults);
                this.getVerticalScrollBar().putClientProperty("Nimbus.Overrides.InheritDefaults", false);
            }

        }

        for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(laf.getName())) {
                try {
                    UIManager.setLookAndFeel(laf.getClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        CustomScrollPane scrollPane = new CustomScrollPane(400, 300);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (int i = 0; i < 10; i++) {
            JButton btn = new JButton();
            btn.setPreferredSize(new Dimension(100, 100));
            panel.add(btn);
        }
        scrollPane.setViewportView(panel);
        frame.add(scrollPane);
        frame.setVisible(true);

    }

}
