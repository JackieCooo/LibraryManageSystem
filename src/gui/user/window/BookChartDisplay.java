package gui.user.window;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;

/**
 * 书籍排行榜展示框类
 * @author Jackie
 */
public class BookChartDisplay extends JPanel {

    private RankInfoPanel rankInfo;
    private BookDisplay book;

    /**
     * 初始化界面
     */
    public BookChartDisplay(){
        super();
        setupUI();
    }

    /**
     * 设置界面属性
     */
    private void setupUI(){
        this.setPreferredSize(new Dimension(200, 200));
        this.setLayout(new FormLayout("center:d:noGrow,center:d:noGrow", "center:d:noGrow"));
        CellConstraints cc = new CellConstraints();
        rankInfo = new RankInfoPanel(1, 0);
        this.add(rankInfo, cc.xy(1, 1));
        book = new BookDisplay();
        this.add(book, cc.xy(2, 1));
    }

}
