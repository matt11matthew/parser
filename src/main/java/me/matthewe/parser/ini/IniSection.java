package me.matthewe.parser.ini;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Matthew E on 1/24/2018.
 */
public class IniSection {
    private String name;
    private Map<String, Object> keyValues;

    public IniSection(String name) {
        this.name = name;
        this.keyValues = new HashMap<>();
    }

    public <O extends Object> O get(String key, Class<O> oClass) {
        return (O) keyValues.get(key);
    }

    public void addKeyValue(IniKeyValue keyValue) {
        keyValues.put(keyValue.getKey(), keyValue.getValue());
    }

    public String getName() {
        return name;
    }
}
