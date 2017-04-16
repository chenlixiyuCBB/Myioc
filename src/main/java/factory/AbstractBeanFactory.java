package factory;

/**
 * Created by clxy on 2017/4/16.
 */

import definition.BeanDefinition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** 定义了IoC容器的结构
 * 有一个HashMap来存储BeanDefinition
 */
public abstract class AbstractBeanFactory implements BeanFactory{
      private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

      private List<String> beanDefinitionNames = new ArrayList<String>();

    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        //bean未定义
        if(beanDefinition == null){
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }
        Object bean = beanDefinition.getBean();
        //如果bean还未装载，则装载bean
        if(bean == null){
            bean = doCreatBean(beanDefinition);

            //TODO
            //AOP
        }

        return bean;
    }
    protected Object doCreatBean(BeanDefinition beanDefinition)throws Exception{
        Object bean = createBeanInstance(beanDefinition);
        beanDefinition.setBean(bean);
        //注入bean的属性,交给子类来实现
        applyPropertyValues(bean,beanDefinition);

        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition)throws Exception{
        return beanDefinition.getClassType().newInstance();

    }

    protected abstract void applyPropertyValues(Object bean,BeanDefinition beanDefinition)throws Exception;

    public void preInstantiateSingletons() throws Exception{
        Iterator it = this.beanDefinitionNames.iterator();
        while (it.hasNext()) {
            String beanName = (String) it.next();
            getBean(beanName);
        }
    }

    public List<Object> getBeanForType(Class classType)throws Exception{
        List<Object> list = new ArrayList<Object>();

        for(String beanDefinitionName : beanDefinitionNames){
            if(classType.isAssignableFrom(beanDefinitionMap.get(beanDefinitionName).getClassType())){
                list.add(getBean(beanDefinitionName));
            }
        }
        return list;
    }

    public void registerBeanDefinition(String name,BeanDefinition beanDefinition){
        beanDefinitionMap.put(name,beanDefinition);
        beanDefinitionNames.add(name);
    }


}
