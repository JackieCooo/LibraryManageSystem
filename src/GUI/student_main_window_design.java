package GUI;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class student_main_window_design {
    private JButton cancelBtn;
    private JButton undoBtn;
    private JButton userName;
    private JButton mailboxBtn;
    private JButton settingBtn;
    private JButton minimiseBtn;
    private JButton closeBtn;
    private JTabbedPane centrePanel;
    private JPanel userMainWindow;
    private JPanel topPanel;
    private JButton bookRepoBtn;
    private JButton myCollectBtn;
    private JButton myBorrowBtn;
    private JButton mySpaceBtn;
    private JPanel bottomPanel;
    private JLabel softwareLabel;
    private JPanel accountPanel;
    private JLabel userPic;
    private JScrollPane recommendPage;
    private JScrollPane bookChartPage;
    private JScrollPane latestBookPage;
    private JPanel recommendPanel;
    private JPanel bookChartPanel;
    private JPanel latestBookPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("student_main_window_design");
        frame.setContentPane(new student_main_window_design().userMainWindow);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        userMainWindow = new JPanel();
        userMainWindow.setLayout(new BorderLayout(0, 0));
        userMainWindow.setPreferredSize(new Dimension(900, 675));
        topPanel = new JPanel();
        topPanel.setLayout(new FormLayout("center:d:noGrow,left:20px:noGrow,fill:d:noGrow,left:10px:noGrow,fill:d:noGrow,left:10px:noGrow,right:p:grow,left:20px:noGrow,center:33px:noGrow,left:10px:noGrow,center:d:noGrow,left:20px:noGrow,center:d:noGrow,left:10px:noGrow,center:d:noGrow", "center:d:grow"));
        topPanel.setPreferredSize(new Dimension(900, 75));
        userMainWindow.add(topPanel, BorderLayout.NORTH);
        topPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        softwareLabel = new JLabel();
        softwareLabel.setHorizontalAlignment(0);
        softwareLabel.setHorizontalTextPosition(0);
        softwareLabel.setOpaque(false);
        softwareLabel.setPreferredSize(new Dimension(200, 50));
        softwareLabel.setText("test");
        CellConstraints cc = new CellConstraints();
        topPanel.add(softwareLabel, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.CENTER));
        cancelBtn = new JButton();
        cancelBtn.setMargin(new Insets(0, 0, 0, 0));
        cancelBtn.setPreferredSize(new Dimension(30, 30));
        cancelBtn.setText("Button");
        topPanel.add(cancelBtn, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.CENTER));
        undoBtn = new JButton();
        undoBtn.setPreferredSize(new Dimension(30, 30));
        undoBtn.setText("Button");
        topPanel.add(undoBtn, cc.xy(5, 1, CellConstraints.CENTER, CellConstraints.CENTER));
        accountPanel = new JPanel();
        accountPanel.setLayout(new FormLayout("fill:d:noGrow,left:10dlu:noGrow,fill:d:noGrow", "center:max(d;4px):noGrow"));
        accountPanel.setPreferredSize(new Dimension(200, 50));
        topPanel.add(accountPanel, cc.xy(7, 1));
        accountPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        userPic = new JLabel();
        userPic.setHorizontalAlignment(0);
        userPic.setHorizontalTextPosition(0);
        userPic.setPreferredSize(new Dimension(50, 50));
        userPic.setText("Label");
        accountPanel.add(userPic, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        userName = new JButton();
        userName.setPreferredSize(new Dimension(100, 30));
        userName.setText("Button");
        accountPanel.add(userName, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        mailboxBtn = new JButton();
        mailboxBtn.setOpaque(true);
        mailboxBtn.setPreferredSize(new Dimension(30, 30));
        mailboxBtn.setText("Button");
        topPanel.add(mailboxBtn, cc.xy(9, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        settingBtn = new JButton();
        settingBtn.setPreferredSize(new Dimension(30, 30));
        settingBtn.setText("Button");
        topPanel.add(settingBtn, cc.xy(11, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        minimiseBtn = new JButton();
        minimiseBtn.setPreferredSize(new Dimension(20, 20));
        minimiseBtn.setText("Button");
        topPanel.add(minimiseBtn, cc.xy(13, 1, CellConstraints.DEFAULT, CellConstraints.CENTER));
        closeBtn = new JButton();
        closeBtn.setPreferredSize(new Dimension(20, 20));
        closeBtn.setText("Button");
        topPanel.add(closeBtn, cc.xy(15, 1, CellConstraints.DEFAULT, CellConstraints.CENTER));
        centrePanel = new JTabbedPane();
        centrePanel.setPreferredSize(new Dimension(900, 325));
        userMainWindow.add(centrePanel, BorderLayout.CENTER);
        centrePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        recommendPage = new JScrollPane();
        centrePanel.addTab("Untitled", recommendPage);
        recommendPanel = new JPanel();
        recommendPanel.setLayout(new FormLayout("", ""));
        recommendPage.setViewportView(recommendPanel);
        bookChartPage = new JScrollPane();
        centrePanel.addTab("Untitled", bookChartPage);
        bookChartPanel = new JPanel();
        bookChartPanel.setLayout(new FormLayout("", ""));
        bookChartPage.setViewportView(bookChartPanel);
        latestBookPage = new JScrollPane();
        centrePanel.addTab("Untitled", latestBookPage);
        latestBookPanel = new JPanel();
        latestBookPanel.setLayout(new FormLayout("", ""));
        latestBookPage.setViewportView(latestBookPanel);
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FormLayout("fill:d:grow,left:10px:noGrow,fill:d:grow,left:10px:noGrow,fill:d:grow,left:10px:noGrow,fill:d:grow", "center:d:grow"));
        bottomPanel.setPreferredSize(new Dimension(900, 275));
        userMainWindow.add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        bookRepoBtn = new JButton();
        bookRepoBtn.setHorizontalTextPosition(0);
        bookRepoBtn.setPreferredSize(new Dimension(150, 200));
        bookRepoBtn.setText("Button");
        bottomPanel.add(bookRepoBtn, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        myCollectBtn = new JButton();
        myCollectBtn.setPreferredSize(new Dimension(150, 200));
        myCollectBtn.setText("Button");
        bottomPanel.add(myCollectBtn, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        myBorrowBtn = new JButton();
        myBorrowBtn.setPreferredSize(new Dimension(150, 200));
        myBorrowBtn.setText("Button");
        bottomPanel.add(myBorrowBtn, cc.xy(5, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        mySpaceBtn = new JButton();
        mySpaceBtn.setPreferredSize(new Dimension(150, 200));
        mySpaceBtn.setText("Button");
        bottomPanel.add(mySpaceBtn, cc.xy(7, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return userMainWindow;
    }
}
