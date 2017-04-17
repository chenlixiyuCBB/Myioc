package aop;

/**
 * Created by clxy on 2017/4/17.
 */

/** 被代理对象的信息
 *
 */
public class TargetSource {
    private Object target;

    private Class<?> targetClass;

    private Class<?>[] interfaces;

    public TargetSource(Object target, Class<?> targetClass, Class<?>[] interfaces) {
        this.target = target;
        this.targetClass = targetClass;
        this.interfaces = interfaces;
    }

    public Object getTarget() {
        return target;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public Class<?>[] getInterfaces() {
        return interfaces;
    }
}
