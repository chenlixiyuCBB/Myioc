package aop;

import java.lang.reflect.Method;

/**
 * Created by clxy on 2017/4/17.
 */
public interface MethodMatcher {

    /** 用于匹配执行的方法是否需要拦截
     *
     * @param method
     * @param targetClass
     * @return
     */
    boolean matches(Method method,Class targetClass);
}
