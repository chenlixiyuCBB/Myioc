package resource;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by clxy on 2017/4/16.
 */
public class ResourceLoaderTest {
    @Test
    public void Test() throws IOException{
        ResourceLoader resourceLoader = new UrlResourceLoder();
        Resource resource = resourceLoader.getResource("tinyioc.xml");
        InputStream inputStream = resource.getInputStream();
        Assert.assertNotNull(inputStream);
    }
}
