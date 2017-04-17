package aop;

/**
 * Created by clxy on 2017/4/17.
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** 基于JDK的动态代理
 *
 */
public class JdkDynamicAopProxy extends AbstractAopProxy implements InvocationHandler{
    public JdkDynamicAopProxy(AdvisedSupport advised) {
        super(advised);
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(getClass().getClassLoader(),
                advised.getTargetSource().getInterfaces(),
                this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
