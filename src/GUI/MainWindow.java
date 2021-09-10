package GUI;

import java.awt.*;

public class MainWindow {
    Frame mainWindow = new Frame("测试窗口");

    public void init() {
        mainWindow.setBounds(0, 0, 800, 600);
        mainWindow.setVisible(true);
    }
}
