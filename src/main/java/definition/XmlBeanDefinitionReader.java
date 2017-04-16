package definition;

import bean.BeanReference;
import bean.PropertyValue;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import resource.ResourceLoader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * Created by clxy on 2017/4/15.
 */

/** 处理xml文件并装载bean，此时并未加载bean实体
 *
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {
    public XmlBeanDefinitionReader( ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    public void loadBeanDefinitions(String location) throws Exception {
        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();

        doLoadBeanDefinitions(inputStream);

    }

    protected  void doLoadBeanDefinitions(InputStream inputStream) throws Exception {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();

        Document doc = documentBuilder.parse(inputStream);

        registerBeanDefinitions(doc);
        inputStream.close();
    }

    /** 处理<beans>标签
     *
     * @param doc
     */
    protected void registerBeanDefinitions(Document doc){
        //获取<beans>标签
        Element root = doc.getDocumentElement();

        parseBeanDefinitions(root);
    }

    /** 处理<bean>标签
     *
     * @param root
     */
    protected void parseBeanDefinitions(Element root){
        NodeList nodeList = root.getChildNodes();
        //获取<bean>标签
        for(int i = 0;i<nodeList.getLength();i++){
            Node node = nodeList.item(i);

            if(node instanceof Element){
                Element ele = (Element) node;

                processBeanDefinition(ele);
            }
        }
    }

    /** 生成并且注册BeanDefinition
     *
     * @param ele
     */
    protected void processBeanDefinition(Element ele){
        String name = ele.getAttribute("id");
        String className = ele.getAttribute("class");

        BeanDefinition beanDefinition = new BeanDefinition();
        processProperties(beanDefinition,ele);

        beanDefinition.setClassName(className);
        getRegistry().put(name,beanDefinition);


    }

    /** 解析<property>标签
     *
     * @param beanDefinition
     * @param ele
     */
    protected void processProperties(BeanDefinition beanDefinition,Element ele){
        NodeList propertyValues = ele.getChildNodes();

        for (int i = 0; i < propertyValues.getLength(); i++) {
            Node node = propertyValues.item(i);

            if(node instanceof Element){
                Element element = (Element) node ;

                String name = element.getAttribute("name");
                String value = element.getAttribute("value");

                if(value != null && value.length() > 0){
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name,value));
                }
                else {
                    String ref = element.getAttribute("ref");

                    if(ref == null || ref.length() == 0){
                        throw new IllegalArgumentException("Configuration problem: <property> element for property '"
                                + name + "' must specify a ref or value");
                    }
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name,new BeanReference(ref)));
                }
            }
        }
    }
}
