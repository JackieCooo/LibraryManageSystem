package gui.admin.components;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import gui.admin.panels.BookManagePanel;
import gui.frames.BookFrame;
import gui.shared.ParentAvailable;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.Vector;

/**
 * 管理端操作表格类
 * @author Jackie
 */
public class OperateTable extends JTable implements ParentAvailable<BookManagePanel> {


    /**
     * 设置父级
     * @param obj 父级对象
     */
    @Override
    public void setParentPanel(BookManagePanel obj) {
        parent = obj;
    }

    /**
     * 获取父级
     * @return 返回父级对象
     */
    @Override
    public BookManagePanel getParentPanel() {
        return parent;
    }

    /**
     * 表格控制按钮类
     * @author Jackie
     */
    class TableBtn extends JButton {

        private BufferedImage btnIcon;

        /**
         * 初始化按钮
         * @param btnIconUrl 未被按下按钮的图标路径
         */
        public TableBtn(String btnIconUrl){
            super();
            setupIcons(btnIconUrl);
            setupUI();
        }

        /**
         * 初始化图标
         */
        private void setupIcons(String btnIconUrl){
            try {
                btnIcon = ImageIO.read(new File(btnIconUrl));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * 初始化按钮属性
         */
        private void setupUI(){
            this.setPreferredSize(new Dimension(30, 30));
            this.setText(null);
            this.setBorderPainted(false);

            UIDefaults btnDefaults = new UIDefaults();
            btnDefaults.put("Button.backgroundPainter", (Painter<JComponent>)(g2d, c, w, h) -> {
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g2d.drawImage(btnIcon, 0, 0, null);
            });
            this.putClientProperty("Nimbus.Overrides", btnDefaults);
            this.putClientProperty("Nimbus.Overrides.InheritDefaults", false);

        }
    }

    /*变量定义*/
    private int currentRow = -1;  // 记录鼠标当前悬停的行
    private Point currentPoint = null;  // 记录当前鼠标所在点
    private final Color focusColor = Color.LIGHT_GRAY;  // 鼠标悬停颜色
    private final int[] colWidth = {50, 100, 150, 100, 150, 180};  // 每列的列宽
    private final int colHeight = 40;  // 每列的列高
    private BookManagePanel parent;  // 父级

    /**
     * 初始化界面
     */
    public OperateTable(){
        super();
        setupUI();
    }

    /**
     * 初始化界面属性
     */
    private void setupUI(){

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
             * 设置单元格内容除最后一列外不可编辑
             * @param row 行
             * @param column 列
             * @return false（不能编辑）
             */
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == colWidth.length - 1;
            }
        }

        // 定制普通单元格渲染模式
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

        // 定制控制面板
        abstract class MyControlPanel extends JPanel {

            private TableBtn alterBtn;
            private TableBtn deleteBtn;

            /**
             * 初始化界面
             */
            public MyControlPanel(){
                super();
                setupUI();
                setupListener();
            }

            /**
             * 初始化界面属性
             */
            private void setupUI(){
                this.setOpaque(true);
                this.setPreferredSize(new Dimension(colWidth[colWidth.length - 1], colHeight));
                this.setLayout(new FormLayout("right:d:grow,center:20px:noGrow,left:d:grow", "center:d:grow"));
                CellConstraints cc = new CellConstraints();

                alterBtn = new TableBtn("icons/Alter_30px.png");
                this.add(alterBtn, cc.xy(1, 1));

                deleteBtn = new TableBtn("icons/Delete_30px.png");
                this.add(deleteBtn, cc.xy(3, 1));
            }

            /**
             * 获取修改按钮
             * @return 返回修改按钮对象
             */
            public TableBtn getAlterBtn() {
                return alterBtn;
            }

            /**
             * 获取删除按钮
             * @return 返回删除按钮对象
             */
            public TableBtn getDeleteBtn() {
                return deleteBtn;
            }

            /**
             * 初始化监听器
             */
            abstract void setupListener();
        }

        // 定制操作面板渲染及编辑模式
        class OperatePanelRendererAndEditor extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {

            private Vector<MyControlPanel> controlPanels;

            /**
             * 初始化属性
             */
            public OperatePanelRendererAndEditor(){
                super();
                setupUI();
            }

            /**
             * 初始化所有操作按钮
             */
            private void setupUI(){
                controlPanels = new Vector<>();
                for (int i = 0; i < 20; i++) {
                    this.controlPanels.add(new MyControlPanel() {
                        @Override
                        void setupListener() {
                            this.getAlterBtn().addActionListener(e -> {
//                                System.out.println("借阅按钮按下");
                                new BookFrame(getParentPanel().getParentPanel().getParentPanel(), true).setVisible(true);
                                stopCellEditing();
                            });
                            this.getDeleteBtn().addActionListener(e -> {
//                                System.out.println("收藏按钮按下");
                                stopCellEditing();
                            });
                        }
                    });
                }
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

                MyControlPanel thisPanel = this.controlPanels.get(row);

                // 设置行悬停特效
                if (currentRow == row){
                    thisPanel.setBackground(focusColor);
                }
                else{
                    thisPanel.setBackground(table.getBackground());
                }

                return thisPanel;
            }

            /**
             * 定制编辑状态时的模式
             * @param table 表格对象
             * @param value 单元格内容
             * @param isSelected 单元格是否被选择
             * @param row 该行
             * @param column 该列
             * @return 该组件对象
             */
            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

                MyControlPanel thisPanel = this.controlPanels.get(row);

                if (currentRow == row){
                    thisPanel.setBackground(focusColor);
                }
                else{
                    thisPanel.setBackground(table.getBackground());
                }

                return thisPanel;
            }

            /**
             * 返回当前单元格的内容
             * @return 空对象
             */
            @Override
            public Object getCellEditorValue() {
                return null;
            }
        }

        // 定制普通表头样式
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
                this.setPreferredSize(new Dimension(colWidth[column], colHeight));

                return this;
            }
        }

        // 定制控制面板的表头
        class OpHeaderRenderer extends JPanel implements TableCellRenderer {

            /**
             * 初始化界面
             */
            public OpHeaderRenderer(){
                super();
                setupUI();
            }

            /**
             * 初始化界面属性
             */
            private void setupUI(){

                // 定制添加按钮
                class OpBtn extends JButton {

                    private BufferedImage btnIcon;

                    /**
                     * 初始化界面
                     */
                    public OpBtn(){
                        super();
                        setupIcon();
                        setupUI();
                    }

                    /**
                     * 初始化图标
                     */
                    private void setupIcon(){
                        try {
                            btnIcon = ImageIO.read(new File("icons/Add_30px.png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    /**
                     * 初始化界面属性
                     */
                    private void setupUI(){
                        this.setPreferredSize(new Dimension(30, 30));
                        this.setText(null);
                        this.setBorderPainted(false);

                        UIDefaults btnDefaults = new UIDefaults();
                        btnDefaults.put("Button.backgroundPainter", (Painter<JComponent>)(g2d, c, w, h) -> {
                            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                            g2d.drawImage(btnIcon, 0, 0, null);
                        });
                        this.putClientProperty("Nimbus.Overrides", btnDefaults);
                        this.putClientProperty("Nimbus.Overrides.InheritDefaults", false);
                    }
                }

                CellConstraints cc = new CellConstraints();
                this.setLayout(new FormLayout("right:d:grow,center:20px:noGrow", "center:d:grow"));
                OpBtn opBtn = new OpBtn();
                this.add(opBtn, cc.xy(1, 1));
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
                this.setPreferredSize(new Dimension(colWidth[column], colHeight));
                this.setOpaque(true);
                this.setBackground(table.getBackground());

                return this;
            }

        }

        // 表格所有行数据（测试内容）
        Object[][] rowData = {
                {1, "张三", 80, 80, 0, 0},
                {2, "John", 70, 80, 0, 0},
                {3, "Sue", 70, 70, 0, 0},
                {4, "Jane", 80, 70, 0, 0},
                {5, "Joe_05", 80, 70, 0, 0},
                {6, "Joe_06", 80, 70, 0, 0},
                {7, "Joe_07", 80, 70, 0, 0},
                {8, "Joe_08", 80, 70, 0, 0},
                {9, "Joe_09", 80, 70, 0, 0},
                {10, "Joe_10", 80, 70, 0, 0},
                {11, "Joe_11", 80, 70, 0, 0},
                {12, "Joe_12", 80, 70, 0, 0},
                {13, "Joe_13", 80, 70, 0, 0},
                {14, "Joe_14", 80, 70, 0, 0},
                {15, "Joe_15", 80, 70, 0, 0},
                {16, "Joe_16", 80, 70, 0, 0},
                {17, "Joe_17", 80, 70, 0, 0},
                {18, "Joe_18", 80, 70, 0, 0},
                {19, "Joe_19", 80, 70, 0, 0},
                {20, "Joe_20", 80, 70, 0, 0}
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
        this.setBorder(null);
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
                currentPoint = null;
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
                Point p = e.getPoint();
                currentPoint = p;
                currentRow = rowAtPoint(currentPoint);
//                System.out.println("鼠标在" + currentPoint);
                if ((p.x >= 600 && p.x <= 630) || (p.x >= 650 && p.x <= 680)) {
                    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
                else {
                    setCursor(Cursor.getDefaultCursor());
                }
                repaint();
            }
        });

        // 设置单元格渲染模式
        MyTableCellRenderer myTableCellRenderer = new MyTableCellRenderer();
        OperatePanelRendererAndEditor operatePanelRendererAndEditor = new OperatePanelRendererAndEditor();
        for (int i = 0; i < colWidth.length; i++) {
            TableColumn tableColumn = this.getColumnModel().getColumn(i);
            if (i == colWidth.length - 1) {
                tableColumn.setCellRenderer(operatePanelRendererAndEditor);
                tableColumn.setCellEditor(operatePanelRendererAndEditor);
            }
            else tableColumn.setCellRenderer(myTableCellRenderer);
        }

        // 设置排序模式
        TableRowSorter<MyTableModel> rowSorter = new TableRowSorter<>(myTableModel);
        rowSorter.setSortable(colWidth.length - 1, false);
        rowSorter.setComparator(0, (Comparator<Integer>) Integer::compare);
        this.setRowSorter(rowSorter);

        // 设置表格内容颜色
        this.setForeground(Color.BLACK);  // 字体颜色
        this.setBackground(Color.WHITE);
        this.setFont(new Font("微软雅黑", Font.PLAIN, 14));  // 字体样式

        // 设置表头
        MyHeaderRenderer myHeaderRenderer = new MyHeaderRenderer();
        OpHeaderRenderer opHeaderRenderer = new OpHeaderRenderer();
        for (int i = 0; i < colWidth.length; i++) {
            TableColumn tableColumn = this.getColumnModel().getColumn(i);
            if (i == colWidth.length - 1) tableColumn.setHeaderRenderer(opHeaderRenderer);
            else tableColumn.setHeaderRenderer(myHeaderRenderer);
        }
        this.getTableHeader().setResizingAllowed(false);  // 设置不允许手动改变列宽
        this.getTableHeader().setReorderingAllowed(false);  // 设置不允许拖动重新排序各列
        this.getTableHeader().addMouseListener(new MouseAdapter() {

            /**
             * 鼠标点击添加书籍信息
             * @param e 鼠标事件对象
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                Point p = e.getPoint();
                if (p.x >= 680 && p.x <= 710 && p.y >= 5 && p.y <= 35){
//                    System.out.println("添加按钮按下");
                    new BookFrame(getParentPanel().getParentPanel().getParentPanel(), true).setVisible(true);
                }
            }
        });

        this.getTableHeader().addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Point p = e.getPoint();
//                System.out.println("鼠标在" + p);
                if (p.x >= 680 && p.x <= 710 && p.y >= 5 && p.y <= 35){
                    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
                else {
                    setCursor(Cursor.getDefaultCursor());
                }
            }
        });

        // 设置行高
        this.setRowHeight(colHeight);

        // 设置列宽
        for (int i = 0; i < colWidth.length; i++) {
            this.getColumnModel().getColumn(i).setPreferredWidth(colWidth[i]);
        }

        // 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
        this.setPreferredScrollableViewportSize(new Dimension(730, 520));

    }
}
