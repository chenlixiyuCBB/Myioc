package ext;

/**
 * Created by clxy on 2017/4/17.
 */

/** proxyCreator的接口
 * 在beanFactory中被保存，先于所有bean被加载
 * 是织入AOP的关键点
 * proxyCreator创建所有proxy
 */
public interface BeanPostProcessor {
    Object postProcessorBeforInitializiton(Object bean,String beanName) throws Exception;

    Object postProcessorAfterInitializition(Object bean,String beanName) throws Exception;
}
