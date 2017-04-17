package aop;

/**
 * Created by clxy on 2017/4/17.
 */

/** 切点类
 *
 */
public interface PointCut {
    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();

}
