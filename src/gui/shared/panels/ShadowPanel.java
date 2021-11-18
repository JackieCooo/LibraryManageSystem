package gui.shared.panels;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ShadowPanel extends JPanel {

    private final int pixels = 8;  // 阴影大小像素

    public ShadowPanel() {
        Border border = BorderFactory.createEmptyBorder(pixels, pixels, pixels, pixels);
        this.setBorder(BorderFactory.createCompoundBorder(this.getBorder(), border));
        this.setLayout(new BorderLayout());
    }

    @Override
    protected void paintComponent(Graphics g) {
        int shade = 0;
        int topOpacity = 80;  // 最大透明度
        for (int i = 0; i < pixels; i++) {
            Graphics2D g2d = (Graphics2D)g;
            g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
            g2d.setColor(new Color(shade, shade, shade, ((topOpacity / (pixels * 2)) * i)));
            g2d.drawRect(i, i, this.getWidth() - ((i * 2) + 1), this.getHeight() - ((i * 2) + 1));
        }
    }
}
