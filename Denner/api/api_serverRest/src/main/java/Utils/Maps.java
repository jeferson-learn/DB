package Utils;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

public class Maps {

    public static Map<String, Object> mapObject(String key, Object object) {
        Map<String, Object> createObject = new HashMap<String, Object>();
        createObject.put(key, object);
        return createObject;
    }

    @JsonPropertyOrder({"email","password"})
    public static Map<String, String> mapObjectString() {
        Map<String, String> createString = new HashMap<String, String>();
        createString.put("email", "jeferson1@teste.com");
        createString.put("password", "123456");
        return createString;
    }
}
