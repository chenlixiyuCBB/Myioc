package factory;

import bean.BeanReference;
import bean.PropertyValue;
import definition.BeanDefinition;
import ext.BeanFactoryAware;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by clxy on 2017/4/16.
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception{
        //此为扩展点，允许后续扩展
        if (bean instanceof BeanFactoryAware) {
            ((BeanFactoryAware) bean).setBeanFactory(this);
        }

       for(PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValueList()){
            Object value = propertyValue.getValue();

            if(value instanceof BeanReference){
                BeanReference beanReference = (BeanReference) value;

                value =  getBean(beanReference.getName());
            }

            try {
                Method method = bean.getClass().getDeclaredMethod(
                        "set"+ propertyValue.getName().substring(0,1).toUpperCase()
                        + propertyValue.getName().substring(1)
                        ,value.getClass()
                );
                method.setAccessible(true);
                method.invoke(bean,value);
            }
            catch (NoSuchMethodException e){
                Field field = bean.getClass().getDeclaredField(propertyValue.getName());

                field.setAccessible(true);
                field.set(bean,value);
            }
       }


    }
}
