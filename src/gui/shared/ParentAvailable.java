package gui.shared;

/**
 * 父级可提供接口
 * @author Jackie
 */
public interface ParentAvailable<T> {

    /**
     * 设置父级
     * @param obj 父级对象
     */
    void setParentPanel(T obj);

    /**
     * 获取父级
     * @return 返回父级对象
     */
    T getParentPanel();

}
