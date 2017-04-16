package context;

import factory.AbstractBeanFactory;

/**
 * Created by clxy on 2017/4/16.
 */
public abstract class AbstractApplicationContext implements ApplicationContext {
    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;

    }
    public void refresh()throws Exception{
        loadBeanDefinition(beanFactory);

        onRefresh();
    }

    /** 加载bean定义，交由具体实现类来完成
     *
     * @param beanFactory
     * @throws Exception
     */
    protected abstract void loadBeanDefinition(AbstractBeanFactory beanFactory)throws Exception;

    /** 以单例模式装载bean
     *
     * @throws Exception
     */
    protected void onRefresh() throws Exception{
        beanFactory.preInstantiateSingletons();
    }
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }
}
