package context;

import com.test.HelloWorldService;
import org.junit.Test;

/**
 * Created by clxy on 2017/4/16.
 */
public class ApplicationContextTest {

    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");

        // OutputService outputService = (OutputService) applicationContext.getBean("outputService");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");

        // Assert.assertNotNull(helloWorldService);
        helloWorldService.helloWorld();
    }
}
