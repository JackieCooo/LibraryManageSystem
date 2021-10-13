package test;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.shared.LayoutColors;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SearchPanelTest {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        // 定制文本输入框
        class SearchBox extends JTextField {

            /**
             * 初始化界面
             */
            public SearchBox(){
                super();
                setupUI();
            }

            /**
             * 初始化界面属性
             */
            private void setupUI(){
                this.setPreferredSize(new Dimension(400, 40));
                this.setFont(new Font("微软雅黑", Font.PLAIN, 14));
                UIDefaults searchBoxDefaults = new UIDefaults();
                searchBoxDefaults.put("TextField.contentMargins", new Insets(6, 10, 6, 10));
                searchBoxDefaults.put("TextField.backgroundPainter", (Painter<JComponent>) (g2d, c, width, height) -> {
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2d.setColor(LayoutColors.LIGHT_BLUE);
                    g2d.fillRoundRect(0, 0, width, height, 20, 20);
                    g2d.fillRect(width-10, 0, width, height);
                });
                this.putClientProperty("Nimbus.Overrides", searchBoxDefaults);
                this.putClientProperty("Nimbus.Overrides.InheritDefaults", false);
            }

        }

        // 定制搜索按钮
        class SearchBtn extends JButton {

            private boolean isFocus = false;
            private BufferedImage focusIcon;
            private BufferedImage normalIcon;

            /**
             * 初始化界面
             */
            public SearchBtn(){
                super();
                setupIcon();
                setupUI();
                setupListener();
            }

            /**
             * 初始化按钮图标
             */
            private void setupIcon(){
                try {
                    normalIcon = ImageIO.read(new File("icons/SearchBtnNormal.png"));
                    focusIcon = ImageIO.read(new File("icons/SearchBtnFocus.png"));
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }

            /**
             * 绘制按钮样式
             * @param g 画笔对象
             */
            @Override
            public void paint(Graphics g) {
                Graphics2D g2d = (Graphics2D)g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g2d.setColor(LayoutColors.LIGHT_BLUE);
                g2d.fillRoundRect(0, 0, 40, 40, 20, 20);
                g2d.fillRect(0, 0, 10, 40);
                if (isFocus) g2d.drawImage(focusIcon, 10, 10, null);
                else g2d.drawImage(normalIcon, 10, 10, null);
            }

            public void toggleState(){
                isFocus = !isFocus;
                repaint();
            }

            /**
             * 初始化界面属性
             */
            private void setupUI(){
                this.setPreferredSize(new Dimension(40, 40));
            }

            /**
             * 初始化监听器
             */
            private void setupListener(){
                this.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        toggleState();
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        setCursor(Cursor.getDefaultCursor());
                        toggleState();
                    }
                });
            }

        }

        // 定制搜索面板
        class SearchPanel extends JPanel {

            private SearchBox searchBox;
            private SearchBtn searchBtn;

            /**
             * 初始化界面
             */
            public SearchPanel(){
                super();
                setupUI();
            }

            /**
             * 初始化界面属性
             */
            private void setupUI(){
                this.setLayout(new FormLayout("center:d:Grow,center:d:Grow", "center:d:noGrow"));
                CellConstraints cc = new CellConstraints();

                for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(laf.getName())) {
                        try {
                            UIManager.setLookAndFeel(laf.getClassName());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                searchBox = new SearchBox();
                this.add(searchBox, cc.xy(1, 1, CellConstraints.RIGHT, CellConstraints.CENTER));

                searchBtn = new SearchBtn();
                this.add(searchBtn, cc.xy(2, 1, CellConstraints.LEFT, CellConstraints.CENTER));
            }

        }

        SearchPanel searchPanel = new SearchPanel();
        panel.add(searchPanel);

        frame.add(panel);
        frame.setVisible(true);
    }

}
