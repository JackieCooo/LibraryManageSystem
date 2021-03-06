package test;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class login_window_design {
    private JPanel loginWindow;
    private JTextField studentNumField;
    private JPasswordField passwordField;
    private JButton studentSignInBtn;
    private JButton studentSignUpBtn;
    private JButton switch2AdminBtn;
    private JPanel studentLoginPage;
    private JLabel loginLabel;
    private JPanel adminLoginPage;
    private JPanel btnSet1;
    private JPasswordField adminPasswordField;
    private JButton switch2StudentBtn;
    private JLabel adminLoginLabel;
    private JTextField adminNumField;
    private JPanel btnSet2;
    private JButton adminSignInBtn;
    private JPanel signUpPage;
    private JTextField signUpStudentNumField;
    private JPasswordField signUpPasswordField;
    private JPasswordField signUpPasswordConfirmField;
    private JButton signUpBtn;
    private JLabel signUpLabel;
    private JLabel signUpStudentNumLabel;
    private JLabel signUpPasswordLabel;
    private JLabel signUpPasswordConfirmLabel;
    private JButton signUp2Login;
    private JLabel loginMessage;
    private JLabel adminLoginMessage;
    private JLabel signUpMessage;
    private JPanel signUpStudentNumPanel;
    private JPanel signUpPasswordPanel;
    private JPanel signUpPasswordConfirmPanel;

    public login_window_design() {
        switch2AdminBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = loginWindow.getComponentCount();
                for (int i = 0; i < n; i++) {
                    loginWindow.getComponent(i).setVisible(false);
                }
                loginWindow.getComponent(1).setVisible(true);
            }
        });

        switch2StudentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = loginWindow.getComponentCount();
                for (int i = 0; i < n; i++) {
                    loginWindow.getComponent(i).setVisible(false);
                }
                loginWindow.getComponent(0).setVisible(true);
            }
        });

        studentSignUpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = loginWindow.getComponentCount();
                for (int i = 0; i < n; i++) {
                    loginWindow.getComponent(i).setVisible(false);
                }
                loginWindow.getComponent(2).setVisible(true);
            }
        });

        signUp2Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = loginWindow.getComponentCount();
                for (int i = 0; i < n; i++) {
                    loginWindow.getComponent(i).setVisible(false);
                }
                loginWindow.getComponent(0).setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("test");
        frame.setContentPane(new login_window_design().loginWindow);
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
        loginWindow = new JPanel();
        loginWindow.setLayout(new CardLayout(0, 0));
        loginWindow.setOpaque(true);
        loginWindow.setPreferredSize(new Dimension(400, 300));
        loginWindow.setVisible(true);
        studentLoginPage = new JPanel();
        studentLoginPage.setLayout(new FormLayout("fill:d:grow", "center:max(d;4px):noGrow,fill:20px:noGrow,center:43px:noGrow,fill:10px:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:d:grow,top:4dlu:noGrow,center:max(d;4px):noGrow"));
        studentLoginPage.setPreferredSize(new Dimension(400, 300));
        studentLoginPage.setVisible(true);
        loginWindow.add(studentLoginPage, "studentLoginPage");
        studentLoginPage.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        loginLabel = new JLabel();
        loginLabel.setEnabled(true);
        Font loginLabelFont = this.$$$getFont$$$("Microsoft YaHei", Font.BOLD, 24, loginLabel.getFont());
        if (loginLabelFont != null) loginLabel.setFont(loginLabelFont);
        loginLabel.setHorizontalAlignment(10);
        loginLabel.setHorizontalTextPosition(11);
        loginLabel.setOpaque(true);
        loginLabel.setText("??????");
        CellConstraints cc = new CellConstraints();
        studentLoginPage.add(loginLabel, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        studentNumField = new JTextField();
        studentNumField.setMargin(new Insets(2, 6, 2, 6));
        studentNumField.setPreferredSize(new Dimension(250, 30));
        studentNumField.setText("test");
        studentLoginPage.add(studentNumField, cc.xy(1, 3, CellConstraints.CENTER, CellConstraints.DEFAULT));
        passwordField = new JPasswordField();
        passwordField.setMargin(new Insets(2, 6, 2, 6));
        passwordField.setPreferredSize(new Dimension(250, 30));
        passwordField.setText("1234");
        studentLoginPage.add(passwordField, cc.xy(1, 5, CellConstraints.CENTER, CellConstraints.DEFAULT));
        btnSet1 = new JPanel();
        btnSet1.setLayout(new FormLayout("center:d:grow,center:50px:grow,fill:d:grow", "center:d:grow"));
        studentLoginPage.add(btnSet1, cc.xy(1, 9, CellConstraints.CENTER, CellConstraints.TOP));
        studentSignInBtn = new JButton();
        studentSignInBtn.setHorizontalTextPosition(0);
        studentSignInBtn.setPreferredSize(new Dimension(100, 40));
        studentSignInBtn.setText("??????");
        btnSet1.add(studentSignInBtn, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        studentSignUpBtn = new JButton();
        studentSignUpBtn.setHorizontalTextPosition(0);
        studentSignUpBtn.setPreferredSize(new Dimension(100, 40));
        studentSignUpBtn.setText("??????");
        btnSet1.add(studentSignUpBtn, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        switch2AdminBtn = new JButton();
        switch2AdminBtn.setPreferredSize(new Dimension(180, 45));
        switch2AdminBtn.setText("???????????????");
        studentLoginPage.add(switch2AdminBtn, cc.xy(1, 11, CellConstraints.DEFAULT, CellConstraints.CENTER));
        loginMessage = new JLabel();
        loginMessage.setFocusable(true);
        Font loginMessageFont = this.$$$getFont$$$("Consolas", Font.PLAIN, 12, loginMessage.getFont());
        if (loginMessageFont != null) loginMessage.setFont(loginMessageFont);
        loginMessage.setHorizontalAlignment(0);
        loginMessage.setHorizontalTextPosition(0);
        loginMessage.setPreferredSize(new Dimension(300, 25));
        loginMessage.setText("test");
        studentLoginPage.add(loginMessage, cc.xy(1, 7, CellConstraints.CENTER, CellConstraints.DEFAULT));
        adminLoginPage = new JPanel();
        adminLoginPage.setLayout(new FormLayout("fill:d:grow", "center:34px:noGrow,fill:20px:noGrow,center:43px:noGrow,fill:10px:noGrow,center:43px:noGrow,fill:10px:noGrow,center:18px:noGrow,fill:10px:noGrow,center:d:grow"));
        adminLoginPage.setPreferredSize(new Dimension(400, 300));
        adminLoginPage.setVisible(false);
        loginWindow.add(adminLoginPage, "adminLoginPage");
        adminLoginPage.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        adminLoginLabel = new JLabel();
        Font adminLoginLabelFont = this.$$$getFont$$$("Microsoft YaHei", Font.BOLD, 24, adminLoginLabel.getFont());
        if (adminLoginLabelFont != null) adminLoginLabel.setFont(adminLoginLabelFont);
        adminLoginLabel.setText("???????????????");
        adminLoginPage.add(adminLoginLabel, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        adminNumField = new JTextField();
        adminNumField.setMargin(new Insets(2, 6, 2, 6));
        adminNumField.setPreferredSize(new Dimension(250, 30));
        adminLoginPage.add(adminNumField, cc.xy(1, 3, CellConstraints.CENTER, CellConstraints.DEFAULT));
        adminPasswordField = new JPasswordField();
        adminPasswordField.setPreferredSize(new Dimension(250, 30));
        adminLoginPage.add(adminPasswordField, cc.xy(1, 5, CellConstraints.CENTER, CellConstraints.DEFAULT));
        btnSet2 = new JPanel();
        btnSet2.setLayout(new FormLayout("fill:d:grow,fill:50px:noGrow,fill:d:grow", "fill:d:grow"));
        adminLoginPage.add(btnSet2, cc.xy(1, 9, CellConstraints.CENTER, CellConstraints.TOP));
        adminSignInBtn = new JButton();
        adminSignInBtn.setMargin(new Insets(0, 0, 0, 0));
        adminSignInBtn.setPreferredSize(new Dimension(100, 40));
        adminSignInBtn.setText("??????");
        btnSet2.add(adminSignInBtn, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        switch2StudentBtn = new JButton();
        switch2StudentBtn.setHorizontalTextPosition(0);
        switch2StudentBtn.setPreferredSize(new Dimension(100, 40));
        switch2StudentBtn.setText("????????????");
        btnSet2.add(switch2StudentBtn, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        adminLoginMessage = new JLabel();
        Font adminLoginMessageFont = this.$$$getFont$$$("Consolas", Font.PLAIN, 12, adminLoginMessage.getFont());
        if (adminLoginMessageFont != null) adminLoginMessage.setFont(adminLoginMessageFont);
        adminLoginMessage.setHorizontalAlignment(0);
        adminLoginMessage.setHorizontalTextPosition(0);
        adminLoginMessage.setPreferredSize(new Dimension(250, 25));
        adminLoginMessage.setText("test");
        adminLoginPage.add(adminLoginMessage, cc.xy(1, 7, CellConstraints.CENTER, CellConstraints.DEFAULT));
        signUpPage = new JPanel();
        signUpPage.setLayout(new FormLayout("fill:d:grow", "center:38px:noGrow,fill:20px:noGrow,center:d:noGrow,fill:10px:noGrow,center:d:noGrow,fill:10px:noGrow,center:d:noGrow,fill:10px:noGrow,center:d:noGrow,fill:10px:noGrow,center:d:grow,fill:10px:noGrow,center:d:noGrow"));
        signUpPage.setPreferredSize(new Dimension(400, 300));
        loginWindow.add(signUpPage, "signUpPage");
        signUpPage.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        signUpBtn = new JButton();
        signUpBtn.setPreferredSize(new Dimension(250, 40));
        signUpBtn.setText("??????");
        signUpPage.add(signUpBtn, cc.xy(1, 11, CellConstraints.CENTER, CellConstraints.TOP));
        signUpLabel = new JLabel();
        signUpLabel.setAlignmentX(0.0f);
        Font signUpLabelFont = this.$$$getFont$$$("Microsoft YaHei", Font.BOLD, 24, signUpLabel.getFont());
        if (signUpLabelFont != null) signUpLabel.setFont(signUpLabelFont);
        signUpLabel.setHorizontalAlignment(0);
        signUpLabel.setHorizontalTextPosition(0);
        signUpLabel.setOpaque(false);
        signUpLabel.setText("??????");
        signUpPage.add(signUpLabel, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        signUp2Login = new JButton();
        signUp2Login.setPreferredSize(new Dimension(250, 40));
        signUp2Login.setText("??????????????????");
        signUpPage.add(signUp2Login, cc.xy(1, 13, CellConstraints.CENTER, CellConstraints.BOTTOM));
        signUpMessage = new JLabel();
        Font signUpMessageFont = this.$$$getFont$$$("Consolas", Font.PLAIN, 12, signUpMessage.getFont());
        if (signUpMessageFont != null) signUpMessage.setFont(signUpMessageFont);
        signUpMessage.setHorizontalAlignment(0);
        signUpMessage.setHorizontalTextPosition(0);
        signUpMessage.setPreferredSize(new Dimension(250, 25));
        signUpMessage.setText("test");
        signUpPage.add(signUpMessage, cc.xy(1, 9, CellConstraints.CENTER, CellConstraints.DEFAULT));
        signUpStudentNumPanel = new JPanel();
        signUpStudentNumPanel.setLayout(new FormLayout("fill:max(d;4px):noGrow,fill:10px:noGrow,fill:max(d;4px):noGrow", "center:max(d;4px):noGrow"));
        signUpPage.add(signUpStudentNumPanel, cc.xy(1, 3, CellConstraints.CENTER, CellConstraints.DEFAULT));
        signUpStudentNumField = new JTextField();
        signUpStudentNumField.setPreferredSize(new Dimension(250, 30));
        signUpStudentNumPanel.add(signUpStudentNumField, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        signUpStudentNumLabel = new JLabel();
        Font signUpStudentNumLabelFont = this.$$$getFont$$$("Consolas", Font.PLAIN, 14, signUpStudentNumLabel.getFont());
        if (signUpStudentNumLabelFont != null) signUpStudentNumLabel.setFont(signUpStudentNumLabelFont);
        signUpStudentNumLabel.setHorizontalAlignment(4);
        signUpStudentNumLabel.setHorizontalTextPosition(4);
        signUpStudentNumLabel.setPreferredSize(new Dimension(60, 30));
        signUpStudentNumLabel.setText("??????");
        signUpStudentNumPanel.add(signUpStudentNumLabel, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        signUpPasswordPanel = new JPanel();
        signUpPasswordPanel.setLayout(new FormLayout("fill:d:noGrow,fill:10px:noGrow,fill:d:grow", "center:d:grow,center:d:noGrow"));
        signUpPage.add(signUpPasswordPanel, cc.xy(1, 5, CellConstraints.CENTER, CellConstraints.DEFAULT));
        signUpPasswordLabel = new JLabel();
        Font signUpPasswordLabelFont = this.$$$getFont$$$("Consolas", Font.PLAIN, 14, signUpPasswordLabel.getFont());
        if (signUpPasswordLabelFont != null) signUpPasswordLabel.setFont(signUpPasswordLabelFont);
        signUpPasswordLabel.setHorizontalAlignment(4);
        signUpPasswordLabel.setHorizontalTextPosition(4);
        signUpPasswordLabel.setInheritsPopupMenu(true);
        signUpPasswordLabel.setPreferredSize(new Dimension(60, 30));
        signUpPasswordLabel.setText("??????");
        signUpPasswordPanel.add(signUpPasswordLabel, cc.xy(1, 2, CellConstraints.CENTER, CellConstraints.DEFAULT));
        signUpPasswordField = new JPasswordField();
        signUpPasswordField.setPreferredSize(new Dimension(250, 30));
        signUpPasswordPanel.add(signUpPasswordField, cc.xy(3, 2, CellConstraints.CENTER, CellConstraints.DEFAULT));
        signUpPasswordConfirmPanel = new JPanel();
        signUpPasswordConfirmPanel.setLayout(new FormLayout("fill:61px:noGrow,fill:10px:noGrow,fill:max(d;4px):noGrow", "center:max(d;4px):noGrow"));
        signUpPage.add(signUpPasswordConfirmPanel, cc.xy(1, 7, CellConstraints.CENTER, CellConstraints.DEFAULT));
        signUpPasswordConfirmLabel = new JLabel();
        Font signUpPasswordConfirmLabelFont = this.$$$getFont$$$("Consolas", Font.PLAIN, 14, signUpPasswordConfirmLabel.getFont());
        if (signUpPasswordConfirmLabelFont != null) signUpPasswordConfirmLabel.setFont(signUpPasswordConfirmLabelFont);
        signUpPasswordConfirmLabel.setHorizontalAlignment(4);
        signUpPasswordConfirmLabel.setHorizontalTextPosition(4);
        signUpPasswordConfirmLabel.setPreferredSize(new Dimension(60, 30));
        signUpPasswordConfirmLabel.setText("????????????");
        signUpPasswordConfirmPanel.add(signUpPasswordConfirmLabel, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        signUpPasswordConfirmField = new JPasswordField();
        signUpPasswordConfirmField.setPreferredSize(new Dimension(250, 30));
        signUpPasswordConfirmField.setText("");
        signUpPasswordConfirmPanel.add(signUpPasswordConfirmField, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return loginWindow;
    }

}
