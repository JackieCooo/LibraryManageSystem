package gui.shared.components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AccountPic extends JLabel {

    private BufferedImage userPic;

    /**
     * 初始化界面
     */
    public AccountPic(String path){
        super();
        setupIcon(path);
        setupUI();
    }

    /**
     * 设置头像
     * @param path 图片路径
     */
    public void setUserPic(String path) {
        setupIcon(path);
    }

    /**
     * 绘制头像
     * @param g 画笔对象
     */
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.drawImage(userPic, 0, 0, null);
    }

    /**
     * 初始化头像
     * @param path 图片
     */
    private void setupIcon(String path){
        try {
            BufferedImage srcImage = ImageIO.read(new File(path));
            BufferedImage dstImage = new BufferedImage(40, 40, BufferedImage.TYPE_INT_ARGB);
            Graphics2D gs = dstImage.createGraphics();
            gs.setComposite(AlphaComposite.Src);
            gs.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            gs.setColor(Color.WHITE);
            gs.fillOval(0, 0, 40, 40);
            gs.setComposite(AlphaComposite.SrcAtop);
            gs.drawImage(srcImage.getScaledInstance(40, 40, Image.SCALE_SMOOTH), 0, 0, null);
            gs.dispose();
            userPic = dstImage;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化界面
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(40, 40));
    }

}
