package definition;

/**
 * Created by clxy on 2017/4/14.
 */
public interface BeanDefinitionReader {
    void loadBeanDefinitions(String location) throws Exception;
}
