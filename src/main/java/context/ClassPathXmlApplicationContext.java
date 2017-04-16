package context;

import definition.BeanDefinition;
import definition.XmlBeanDefinitionReader;
import factory.AbstractBeanFactory;
import factory.AutowireCapableBeanFactory;
import resource.UrlResourceLoder;

import java.util.Map;

/**
 * Created by clxy on 2017/4/16.
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext{
    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        // 默认是自动装载bean
        this(configLocation, new AutowireCapableBeanFactory());

    }
    public ClassPathXmlApplicationContext(String configLocation,AbstractBeanFactory beanFactory) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        loadBeanDefinition(beanFactory);
    }

    protected void loadBeanDefinition(AbstractBeanFactory beanFactory) throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new UrlResourceLoder());

        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);

        for(Map.Entry<String, BeanDefinition> entry : xmlBeanDefinitionReader.getRegistry().entrySet()){
            beanFactory.registerBeanDefinition(entry.getKey(),entry.getValue());
        }


    }
}
