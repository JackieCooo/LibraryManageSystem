package gui.components;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Comparator;
import java.util.Vector;

/**
 * 书库操作面板类
 * @author Jackie
 */
public class BookRepoOperateTable extends JTable {


    private int currentRow = -1;  // 记录鼠标当前悬停的行
    private Point currentPoint = null;  // 记录当前鼠标所在点
    private final Color focusColor = Color.LIGHT_GRAY;  // 鼠标悬停颜色

    /**
     * 初始化界面
     */
    public BookRepoOperateTable(){
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
                return column == 5;
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

            private TableControlBtn borrowBtn;
            private TableControlBtn collectBtn;

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
                this.setPreferredSize(new Dimension(150, 30));
                this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));

                collectBtn = new TableControlBtn("icons/Uncollected.png", "icons/Collected.png");
                this.add(collectBtn);

                borrowBtn = new TableControlBtn("icons/Unborrowed.png", "icons/Borrowed.png");
                this.add(borrowBtn);
            }

            /**
             * 获取借阅按钮
             * @return 按钮对象
             */
            public TableControlBtn getBorrowBtn() {
                return borrowBtn;
            }

            /**
             * 获取收藏按钮
             * @return 按钮对象
             */
            public TableControlBtn getCollectBtn() {
                return collectBtn;
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
                            this.getBorrowBtn().addActionListener(e -> {
//                                System.out.println("借阅按钮按下");
                                getBorrowBtn().toggleStatus();
                                stopCellEditing();
//                                System.out.println(getBorrowBtn().isHasBeenSet());
                            });
                            this.getCollectBtn().addActionListener(e -> {
//                                System.out.println("收藏按钮按下");
                                getCollectBtn().toggleStatus();
                                stopCellEditing();
//                                System.out.println(getCollectBtn().isHasBeenSet());
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
                currentPoint = e.getPoint();
                currentRow = rowAtPoint(currentPoint);
//                System.out.println("鼠标在第" + currentRow + "行");
                repaint();
            }
        });

        // 设置单元格渲染模式
        MyTableCellRenderer myTableCellRenderer = new MyTableCellRenderer();
        OperatePanelRendererAndEditor operatePanelRendererAndEditor = new OperatePanelRendererAndEditor();
        for (int i = 0; i < 6; i++) {
            TableColumn tableColumn = this.getColumnModel().getColumn(i);
            if (i == 5) {
                tableColumn.setCellRenderer(operatePanelRendererAndEditor);
                tableColumn.setCellEditor(operatePanelRendererAndEditor);
            }
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
