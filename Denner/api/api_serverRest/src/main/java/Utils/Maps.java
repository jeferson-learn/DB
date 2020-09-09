package Utils;

import java.util.HashMap;
import java.util.Map;

public class Maps {

    public static Map<String, Object> mapObject(String key, Object object) {
        Map<String, Object> createObject = new HashMap<String, Object>();
        createObject.put(key, object);
        return createObject;
    }

    public static Map<String, String> mapObjectString() {
        Map<String, String> createString = new HashMap<String, String>();
        createString.put("email", "fulano@qa.com");
        createString.put("password", "teste");
        return createString;
    }
}
