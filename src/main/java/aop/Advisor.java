package aop;

import org.aopalliance.aop.Advice;

/**
 * Created by clxy on 2017/4/17.
 */

/** 通知接口
 *
 */
public interface Advisor {
    Advice getAdvice();
}
