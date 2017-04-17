package aop;

/**
 * Created by clxy on 2017/4/17.
 */
public abstract class AbstractAopProxy implements AopProxy{
    protected AdvisedSupport advised;

    public AbstractAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }
}
