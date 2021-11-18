import gui.frames.AdminFrame;
import gui.frames.LoginFrame;
import gui.frames.UserFrame;

import javax.swing.*;

/**
 * 程序入口类
 * @author Jackie
 */
public class Main {

    /**
     * main函数
     * @param args args
     */
    public static void main(String[] args) {

        for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(laf.getName())) {
                try {
                    UIManager.setLookAndFeel(laf.getClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        new AdminFrame();
//        new UserFrame();
//        new LoginFrame();
    }
}
