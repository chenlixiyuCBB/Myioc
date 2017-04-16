package definition;

/**
 * Created by clxy on 2017/4/14.
 */

/** 获取bean的定义
 *
 */
public interface BeanDefinitionReader {
    void loadBeanDefinitions(String location) throws Exception;
}
