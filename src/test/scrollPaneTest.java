package test;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class scrollPaneTest {
    /**
     * Create the frame.
     */

    public static void main(String[] args) {
        JFrame frame = new JFrame("滚动测试");
        frame.setBounds(100, 100, 450, 300); //位置（100 ，100）宽：450，高300
        JPanel contentPane = new JPanel();
        //Border描述了面板四周的边界（属于面板内部），EmptyBorder为5的一个空白的边界；
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        for (int i = 0; i < 25; i++) {
            //设置宽100，高100的JButton
            JButton button = new JButton(String.valueOf(i));
            button.setPreferredSize(new Dimension(100, 100));
            contentPane.add(button);
            //添加按钮动作监听
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(button.getText());

                }
            });
        }

        JScrollPane scrollPane = new JScrollPane(contentPane, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //最后添加上scrollPane
        scrollPane.setPreferredSize(new Dimension(450, 300));
        frame.setContentPane(scrollPane);

        frame.pack();
        frame.setVisible(true);

    }

}
