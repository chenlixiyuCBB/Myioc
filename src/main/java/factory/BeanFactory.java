package factory;

/**
 * Created by clxy on 2017/4/16.
 */

/** 在获取到beanDefinition的情况下
 * 获取Bean的实例
 */
public interface BeanFactory {
    /** 获取bean，内部其实是调用beanDefinition的getBean方法
     *
     * @param name
     * @return
     * @throws Exception
     */
    Object getBean(String name) throws Exception;
}
