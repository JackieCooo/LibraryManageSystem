package gui.components;

import gui.shared.LayoutColors;
import gui.shared.ParentAvailable;
import gui.user.panels.AccountPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 用户账号操作按钮类
 * @author Jackie
 */
public class AccountOpBtn extends JButton implements ParentAvailable<AccountPanel> {

    /**
     * 用户消息按钮弹出窗口
     * @author Jackie
     */
    class AccountOpPopupMenu extends JPopupMenu{

        private JMenuItem checkoutBtn;

        /**
         * 初始化界面
         */
        public AccountOpPopupMenu(){
            super();
            setupUI();
        }

        /**
         * 初始化界面属性
         */
        private void setupUI(){
            this.setPreferredSize(new Dimension(100, 40));
            this.setOpaque(true);
            this.setBorderPainted(false);
            this.setBackground(Color.WHITE);
            checkoutBtn = new JMenuItem("登出");
            checkoutBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
            checkoutBtn.setHorizontalAlignment(SwingConstants.CENTER);
            checkoutBtn.setHorizontalTextPosition(SwingConstants.CENTER);
            checkoutBtn.addMouseListener(new MouseAdapter() {

                /**
                 * 设置鼠标点击后退回登录界面
                 * @param e 鼠标事件对象
                 */
                @Override
                public void mouseClicked(MouseEvent e) {

                }

                /**
                 * 设置鼠标悬停指针样式
                 * @param e 鼠标事件对象
                 */
                @Override
                public void mouseEntered(MouseEvent e) {
                    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }

                /**
                 * 设置鼠标非悬停指针样式
                 * @param e 鼠标事件对象
                 */
                @Override
                public void mouseExited(MouseEvent e) {
                    setCursor(Cursor.getDefaultCursor());
                }

            });
            this.add(checkoutBtn);
        }

    }


    private final AccountOpPopupMenu popupMenu = new AccountOpPopupMenu();
    private AccountPanel parent;

    /**
     * 初始化界面
     */
    public AccountOpBtn(String userName){
        super();
        setupUI();
        setupText(userName);
        setupListener();
    }

    /**
     * 设置父级
     * @param obj 父级对象
     */
    @Override
    public void setParentPanel(AccountPanel obj) {
        parent = obj;
    }

    /**
     * 获取父级
     * @return 返回父级对象
     */
    @Override
    public AccountPanel getParentPanel() {
        return parent;
    }

    /**
     * 初始化监听器
     */
    private void setupListener(){
        this.addMouseListener(new MouseAdapter() {

            /**
             * 设置鼠标点击弹出菜单
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                Point fp = getParentPanel().getParentPanel().getLocationOnScreen();  // 窗口绝对位置
                popupMenu.setInvoker(e.getComponent());
                popupMenu.setLocation(fp.x + 560, fp.y + 75);
                popupMenu.setVisible(true);
            }

            /**
             * 设置鼠标悬停指针样式
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                setForeground(LayoutColors.LIGHT_GRAY);
            }

            /**
             * 设置鼠标非悬停指针样式
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
                setForeground(Color.WHITE);
            }
        });
    }

    /**
     * 初始化显示用户名
     * @param userName 用户名
     */
    private void setupText(String userName){
        String dstText = userName;
        // 用户名长于9位，后面加省略号
        if (userName.length() >= 9) {
            dstText = userName.substring(0, 8) + "...";
        }
        this.setText(dstText);
    }

    /**
     * 初始化界面
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(150, 50));
        this.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        this.setForeground(Color.WHITE);
        this.setBorderPainted(false);
        this.setHorizontalTextPosition(SwingConstants.LEFT);
        this.setHorizontalAlignment(SwingConstants.LEFT);
        this.setFocusPainted(false);
        this.setComponentPopupMenu(popupMenu);

        UIDefaults btnDefaults = new UIDefaults();
        btnDefaults.put("Button.contentMargins", new Insets(6, 14, 6, 14));

        this.putClientProperty("Nimbus.Overrides", btnDefaults);
        this.putClientProperty("Nimbus.Overrides.InheritDefaults", false);

    }

}
