package aop;

import ext.BeanFactoryAware;
import ext.BeanPostProcessor;
import factory.AbstractBeanFactory;


/**
 * Created by clxy on 2017/4/17.
 */
public class AdvisorAutoProxyCreator implements BeanFactoryAware, BeanPostProcessor {
    private AbstractBeanFactory beanFactory;

    public void setBeanFactory(AbstractBeanFactory beanFactory) throws Exception {
        this.beanFactory = beanFactory;
    }

    public Object postProcessorBeforInitializiton(Object bean, String beanName) throws Exception {
        return bean;
    }

    public Object postProcessorAfterInitializition(Object bean, String beanName) throws Exception {

        //TODO 还未完成proxy的初始化逻辑
        return bean;
    }

}
