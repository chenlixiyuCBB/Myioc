package resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by clxy on 2017/4/14.
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
