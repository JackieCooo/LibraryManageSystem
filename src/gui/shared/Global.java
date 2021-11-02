package gui.shared;

import java.util.Stack;

/**
 * 全局数据类
 * @author Jackie
 */
public final class Global {

    public static Stack<Integer> prePage = new Stack<>();  // 记录之前的所有页码
    public static int curPage = 0;  // 记录当前页码
    public static Stack<Integer> nexPage = new Stack<>();  // 记录之后的所有页码
    public static int thisFrame = 0;  // 记录当前正在显示的窗口下标，0. 登录窗口，1. 用户窗口，2. 管理窗口

    /**
     * 更新页码关系
     * @param index 当前页码
     */
    public static void pageChange(int index){
        prePage.push(curPage);
        curPage = index;
    }

}
