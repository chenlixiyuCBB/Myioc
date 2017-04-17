package aop;

/**
 * Created by clxy on 2017/4/17.
 */
public interface ClassFilter {
    /** 用于筛选目标class
     *
     * @param targetClass
     * @return
     */
    boolean matches(Class targetClass);
}
