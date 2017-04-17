package ext;

import factory.AbstractBeanFactory;

/**
 * Created by clxy on 2017/4/16.
 */

/** 实现本接口的bean可以获取容器的控制权
 * 后续扩展使用
 */
public interface BeanFactoryAware {
    void setBeanFactory(AbstractBeanFactory beanFactory) throws Exception;
}
