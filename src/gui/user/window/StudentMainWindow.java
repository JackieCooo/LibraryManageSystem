package gui.user.window;

import javax.swing.*;
import java.awt.*;

/**
 * 用户界面类
 * @author Jackie
 */
public class StudentMainWindow {
    private JFrame frame;
    private JPanel userMainWindow;

    private TopPanel topPanel;
    private CentrePanel centrePanel;
    private BottomPanel bottomPanel;

    /**
     * 初始化界面
     */
    public StudentMainWindow(){
        frame = new JFrame();
        frame.setBounds(100, 100, 900, 675);

        userMainWindow = new JPanel();
        userMainWindow.setLayout(new BorderLayout(0, 0));
        userMainWindow.setPreferredSize(new Dimension(900, 675));

        topPanel = new TopPanel();
        userMainWindow.add(topPanel.getTopPanel(), BorderLayout.NORTH);

        centrePanel = new CentrePanel();
        userMainWindow.add(centrePanel.getCentrePanel(), BorderLayout.CENTER);

        bottomPanel = new BottomPanel();
        userMainWindow.add(bottomPanel.getBottomPanel(), BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(userMainWindow);
        frame.pack();
        frame.setVisible(true);
    }

}
