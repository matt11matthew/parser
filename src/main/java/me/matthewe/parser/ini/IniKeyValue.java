package me.matthewe.parser.ini;

/**
 * Created by Matthew E on 1/24/2018.
 */
public class IniKeyValue {
    private String key;
    private Object value;

    public IniKeyValue(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}
