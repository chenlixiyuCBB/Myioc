package bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clxy on 2017/4/14.
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<PropertyValue>();

    public PropertyValues() {
    }

    public List<PropertyValue> getPropertyValueList(){return propertyValueList;}

    public void addPropertyValue(PropertyValue propertyValue){
        propertyValueList.add(propertyValue);
    }
}
