package definition;

import bean.PropertyValues;

/**
 * Created by clxy on 2017/4/14.
 */

public class BeanDefinition {
    private Object bean;

    private String ClassName;

    private Class ClassType;

    private PropertyValues propertyValues= new PropertyValues();

    public Object getBean() {
        return bean;
    }

    public String getClassName() {
        return ClassName;
    }

    public Class getClassType() {
        return ClassType;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public void setClassName(String className) {
        ClassName = className;
        try{
            ClassType = Class.forName(className);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void setClassType(Class classType) {
        ClassType = classType;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
