package test;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.BasicSliderUI;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Comparator;

/**
 * 表格类
 * @author Jackie
 */
class MyTable extends JTable {

    private int currentRow = -1;  // 记录鼠标当前悬停的行
    private final Color focusColor = Color.LIGHT_GRAY;  // 鼠标悬停颜色
    private final int WIDTH = 880;
    private final int HEIGHT = 530;

    /**
     * 初始化界面
     */
    public MyTable(){
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        // 定制表格模板
        class MyTableModel extends DefaultTableModel {

            private static final Object[] colNames = {"", "图书编号", "书名", "作者", "出版社", ""};  // 表头（列名）

            /**
             * 初始化表格模板
             * @param rowCnt 表格的行数
             */
            public MyTableModel(int rowCnt){
                super(colNames, rowCnt);
            }

            /**
             * 向表格加入多行数据
             * @param dat 需要添加的数据
             */
            public void addRows(Object[][] dat){
                for (Object[] rowData : dat){
                    super.addRow(rowData);
                }
            }

            /**
             * 设置单元格内容不可编辑
             * @param row 行
             * @param column 列
             * @return false（不能编辑）
             */
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        }

        // 定制单元格渲染模式
        class MyTableCellRenderer extends JLabel implements TableCellRenderer {

            /**
             * 定制渲染模式
             * @param table 表格对象
             * @param value 单元格内容
             * @param isSelected 单元格是否被选择
             * @param hasFocus 单元格是否被聚焦
             * @param row 该行
             * @param column 该列
             * @return 该组件对象
             */
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                this.setOpaque(true);

                if (currentRow == row){
                    this.setBackground(focusColor);
                }
                else{
                    this.setBackground(table.getBackground());
                }

                // 设置单元格内容
                this.setFont(table.getFont());
                this.setText(value == null ? "" : value.toString());

                // 第一列居中，其他列左对齐
                if (column == 0){
                    this.setHorizontalAlignment(SwingConstants.CENTER);
                }
                else {
                    this.setHorizontalAlignment(SwingConstants.LEFT);
                }

                // 鼠标移动到当前的单元格显示单元格内容
                this.setToolTipText(value == null ? "" : value.toString());

                return this;
            }
        }

        // 操作面板
        class OperatePanelRenderer extends JPanel implements TableCellRenderer{

            private JButton borrowBtn;
            private JButton collectBtn;

            /**
             * 初始化界面
             */
            public OperatePanelRenderer(){
                super();
                setupUI();
            }

            /**
             * 初始化界面属性
             */
            private void setupUI(){
                this.setOpaque(true);
                this.setPreferredSize(new Dimension(150, 30));
                this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));

                borrowBtn = new JButton();
                borrowBtn.setPreferredSize(new Dimension(30, 30));
                borrowBtn.addActionListener(e -> {
                    System.out.println("按钮点击");
                });
                this.add(borrowBtn);

                collectBtn = new JButton();
                collectBtn.setPreferredSize(new Dimension(30, 30));
                collectBtn.addActionListener(e -> {
                    System.out.println("按钮点击");
                });
                this.add(collectBtn);
            }

            /**
             * 定制渲染模式
             * @param table 表格对象
             * @param value 单元格内容
             * @param isSelected 单元格是否被选择
             * @param hasFocus 单元格是否被聚焦
             * @param row 该行
             * @param column 该列
             * @return 该组件对象
             */
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                if (currentRow == row){
                    this.setBackground(focusColor);
                }
                else{
                    this.setBackground(table.getBackground());
                }

                return this;
            }
        }

        // 定制表头样式
        class MyHeaderRenderer extends JLabel implements TableCellRenderer {

            /**
             * 定制渲染模式
             * @param table 表格对象
             * @param value 单元格内容
             * @param isSelected 单元格是否被选择
             * @param hasFocus 单元格是否被聚焦
             * @param row 该行
             * @param column 该列
             * @return 该组件对象
             */
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                // 设置表头文字
                this.setFont(new Font("黑体", Font.BOLD, 14));
                this.setText(value == null ? "" : value.toString());
                this.setOpaque(true);
                this.setBackground(table.getBackground());

                // 设置表头尺寸
                switch (column) {
                    case 0 -> this.setPreferredSize(new Dimension(50, 40));
                    case 1 -> this.setPreferredSize(new Dimension(100, 40));
                    case 2 -> this.setPreferredSize(new Dimension(200, 40));
                    case 3, 4 -> this.setPreferredSize(new Dimension(180, 40));
                    case 5 -> this.setPreferredSize(new Dimension(157, 40));
                    default -> {}
                }

                return this;
            }
        }

        // 表格所有行数据
        Object[][] rowData = {
                {1, "张三", 80, 80, 80, 0},
                {2, "John", 70, 80, 90, 0},
                {3, "Sue", 70, 70, 70, 0},
                {4, "Jane", 80, 70, 60, 0},
                {5, "Joe_05", 80, 70, 60, 0},
                {6, "Joe_06", 80, 70, 60, 0},
                {7, "Joe_07", 80, 70, 60, 0},
                {8, "Joe_08", 80, 70, 60, 0},
                {9, "Joe_09", 80, 70, 60, 0},
                {10, "Joe_10", 80, 70, 60, 0},
                {11, "Joe_11", 80, 70, 60, 0},
                {12, "Joe_12", 80, 70, 60, 0},
                {13, "Joe_13", 80, 70, 60, 0},
                {14, "Joe_14", 80, 70, 60, 0},
                {15, "Joe_15", 80, 70, 60, 0},
                {16, "Joe_16", 80, 70, 60, 0},
                {17, "Joe_17", 80, 70, 60, 0},
                {18, "Joe_18", 80, 70, 60, 0},
                {19, "Joe_19", 80, 70, 60, 0},
                {20, "Joe_20", 80, 70, 60, 0}
        };

        // 创建表格模型，并添加数据
        MyTableModel myTableModel = new MyTableModel(0);
        myTableModel.addRows(rowData);
        this.setModel(myTableModel);

        // 创建一个表格，初始化属性
        this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  // 设置不拉伸
        this.setFocusable(true);
        this.setOpaque(true);
        this.setShowGrid(false);
        this.setIntercellSpacing(new Dimension(0, 1));  // 设置只保留水平网格线

        // 定制鼠标事件
        this.addMouseListener(new MouseAdapter() {

            /**
             * 设置鼠标移出表格的事件处理
             * @param e 事件对象
             */
            @Override
            public void mouseExited(MouseEvent e) {
//                System.out.println("鼠标退出");
                currentRow = -1;
                repaint();
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {

            /**
             * 设置鼠标移动时的事件处理
             * @param e 事件对象
             */
            @Override
            public void mouseMoved(MouseEvent e) {
                currentRow = rowAtPoint(e.getPoint());
//                System.out.println("鼠标在第" + currentRow + "行");
                repaint();
            }
        });

        // 设置单元格渲染模式
        MyTableCellRenderer myTableCellRenderer = new MyTableCellRenderer();
        OperatePanelRenderer operatePanelRenderer = new OperatePanelRenderer();
        for (int i = 0; i < 6; i++) {
            TableColumn tableColumn = this.getColumnModel().getColumn(i);
            if (i == 5) tableColumn.setCellRenderer(operatePanelRenderer);
            else tableColumn.setCellRenderer(myTableCellRenderer);
        }

        // 设置排序模式
        TableRowSorter<MyTableModel> rowSorter = new TableRowSorter<>(myTableModel);
        rowSorter.setSortable(5, false);
        rowSorter.setComparator(0, (Comparator<Integer>) Integer::compare);
        this.setRowSorter(rowSorter);

        // 设置表格内容颜色
        this.setForeground(Color.BLACK);  // 字体颜色
        this.setBackground(Color.WHITE);
        this.setFont(new Font("微软雅黑", Font.PLAIN, 14));  // 字体样式

        // 设置表头
        MyHeaderRenderer myHeaderRenderer = new MyHeaderRenderer();
        for (int i = 0; i < 6; i++) {
            TableColumn tableColumn = this.getColumnModel().getColumn(i);
            tableColumn.setHeaderRenderer(myHeaderRenderer);
        }
        this.getTableHeader().setResizingAllowed(false);  // 设置不允许手动改变列宽
        this.getTableHeader().setReorderingAllowed(false);  // 设置不允许拖动重新排序各列

        // 设置行高
        this.setRowHeight(40);

        // 设置列宽
        this.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.getColumnModel().getColumn(3).setPreferredWidth(180);
        this.getColumnModel().getColumn(4).setPreferredWidth(180);
        this.getColumnModel().getColumn(5).setPreferredWidth(157);

        // 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
        this.setPreferredScrollableViewportSize(new Dimension(880, 530));

    }

}

/**
 * 滚动面板类
 * @author Jackie
 */
class MyScrollPane extends JScrollPane {

    private MyTable myTable;

    /**
     * 滚动条UI类
     * @author Jackie
     */
    class MyScrollBarUI extends BasicScrollBarUI {

        /**
         * 滚动条监听器类
         * @author Jackie
         */
        class MyScrollBarListener extends TrackListener {

            /**
             * 处理鼠标释放事件
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseReleased(MouseEvent e) {
//                System.out.println("鼠标释放");
                super.mouseReleased(e);
                Rectangle r = getThumbBounds();
                // 如果鼠标释放时，鼠标在滑块内，视为鼠标悬停；否则，视为鼠标未进入窗口
                if (getThumbBounds().contains(e.getPoint())){
                    thumbColor = Color.GRAY;
                }
                else {
                    thumbColor = Color.LIGHT_GRAY;
                }
                scrollbar.repaint(r);
            }

            /**
             * 处理鼠标按下事件
             * @param e 鼠标事件对象
             */
            @Override
            public void mousePressed(MouseEvent e) {
//                System.out.println("鼠标按下");
                thumbColor = Color.DARK_GRAY;
                super.mousePressed(e);
            }

            /**
             * 处理鼠标进入事件
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseEntered(MouseEvent e) {
//                System.out.println("鼠标进入");
                Rectangle r = getThumbBounds();
                // 如果鼠标进入时不在滑块范围内，不变色
                if (getThumbBounds().contains(e.getPoint())){
                    thumbColor = Color.GRAY;
                    scrollbar.repaint(r);
                }
            }

            /**
             * 处理鼠标退出事件
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseExited(MouseEvent e) {
//                System.out.println("鼠标退出");
                super.mouseExited(e);
                if (isDragging) return;  // 鼠标拖动时移出窗口不变颜色
                Rectangle r = getThumbBounds();
                thumbColor = Color.LIGHT_GRAY;
                scrollbar.repaint(r);
            }
        }

        /**
         * 初始化控件颜色
         */
        @Override
        protected void configureScrollBarColors() {
            super.configureScrollBarColors();
            trackColor = Color.WHITE;
            thumbColor = Color.LIGHT_GRAY;
            thumbHighlightColor = Color.WHITE;
            thumbLightShadowColor = Color.WHITE;
            thumbDarkShadowColor = Color.WHITE;
        }

        /**
         * 重绘滑块
         * @param g 图形类对象
         * @param c 控件类对象
         * @param thumbBounds 滑块矩形类
         */
        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            if(thumbBounds.isEmpty() || !scrollbar.isEnabled()) {
                return;
            }

            Graphics2D g2d = (Graphics2D)g;

            int w = thumbBounds.width;
            int h = thumbBounds.height;

            g2d.translate(thumbBounds.x, thumbBounds.y);

            g2d.setColor(thumbColor);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.fillRoundRect(0, 0, w - 1, h - 1, 10, 10);

            g2d.translate(-thumbBounds.x, -thumbBounds.y);
        }

        /**
         * 初始化UI
         * @param c 控件类
         */
        @Override
        public void installUI(JComponent c) {
            super.installUI(c);

            // 去掉按钮
            scrollbar.remove(decrButton);
            scrollbar.remove(incrButton);
            scrollbar.setOpaque(true);
            scrollbar.setBackground(Color.WHITE);
            scrollbar.repaint();
        }

        /**
         * 初始化基本属性
         */
        @Override
        protected void installDefaults() {
            super.installDefaults();

            scrollBarWidth = 10;
        }

        /**
         * 创建滑轨监听器
         * @return 返回滑轨监听器对象
         */
        @Override
        protected TrackListener createTrackListener() {
            return new MyScrollBarListener();
        }
    }

    /**
     * 初始化界面
     */
    public MyScrollPane(){
        super();
        setupUI();
    }

    /**
     * 空实现，去掉边框
     * @param g 图形对象
     */
    @Override
    protected void paintBorder(Graphics g) {}

    /**
     * 初始化界面属性
     */
    private void setupUI(){
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(880, 530));
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        myTable = new MyTable();
        this.setViewportView(myTable);
        this.getVerticalScrollBar().setUI(new MyScrollBarUI());
    }

}

class MyPanel extends JPanel {

    public MyPanel(){
        super();
        setupUI();
    }

    private void setupUI(){
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(880, 530));

        MyScrollPane myScrollPane = new MyScrollPane();
        this.add(myScrollPane);
    }

}

public class tableTest {

    public static void main(String[] args) {
        JFrame jf = new JFrame("测试窗口");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setBounds(100, 100, 900, 675);

        // 设置 内容面板 到 窗口
        MyPanel myPanel = new MyPanel();
        jf.add(myPanel);

        jf.setVisible(true);
    }

}
