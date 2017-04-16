package definition;

import resource.ResourceLoader;

import java.util.HashMap;

/**
 * Created by clxy on 2017/4/15.
 */

/** beanDefinition的抽象工厂，规定了提取beanDefinition的流程
 *
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{
    private HashMap<String,BeanDefinition> registry = new HashMap<String,BeanDefinition>();

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader( ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public HashMap<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
