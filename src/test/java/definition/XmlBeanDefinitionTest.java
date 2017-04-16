package definition;

import org.junit.Assert;
import org.junit.Test;
import resource.UrlResourceLoder;

import java.util.Map;

/**
 * Created by clxy on 2017/4/16.
 */
public class XmlBeanDefinitionTest {
    @Test
    public void Test() throws Exception{
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new UrlResourceLoder());
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
        Map<String,BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
        Assert.assertTrue(registry.size() > 0);

    }
}
