package bean;

/**
 * Created by clxy on 2017/4/15.
 */
public class BeanReference {
    private String name;

    private Object bean;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Object getBean() {
        return bean;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
