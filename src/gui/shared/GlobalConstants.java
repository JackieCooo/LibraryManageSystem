package gui.shared;

import java.util.Stack;

public final class GlobalConstants {

    public static Stack<Integer> prePage = new Stack<>();  // 记录之前的所有页码
    public static int curPage = 0;  // 记录当前页码
    public static Stack<Integer> nexPage = new Stack<>();  // 记录之后的所有页码

}
