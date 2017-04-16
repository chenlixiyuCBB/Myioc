package resource;

import java.net.URL;

/**
 * Created by clxy on 2017/4/14.
 */
public class UrlResourceLoder implements ResourceLoader {

    public Resource getResource(String location) {
        URL url = this.getClass().getClassLoader().getResource(location);

        return new UrlResource(url);
    }
}
