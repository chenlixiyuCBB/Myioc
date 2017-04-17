package aop;

/**
 * Created by clxy on 2017/4/17.
 */

/** 切面类
 *
 */
public interface PointcutAdvisor extends Advisor{
    PointCut getPointCut();
}
