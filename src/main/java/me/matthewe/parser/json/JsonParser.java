package me.matthewe.parser.json;


import me.matthewe.parser.Parser;
import org.json.JSONObject;

/**
 * Created by Matthew E on 1/24/2018.
 */
public class JsonParser implements Parser<JSONObject> {
    @Override
    public Json parse(String string) {
        return (Json) new JSONObject(string);
    }
}
