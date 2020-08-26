package Utils;

import java.util.HashMap;
import java.util.Map;

public class Maps {

    public static Map<String, Object> objectMap(String key, Object object){
        Map<String, Object> createObject = new HashMap<String, Object>();
        createObject.put(key, object);
        return createObject;
    }

}
