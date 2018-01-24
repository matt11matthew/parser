package me.matthewe.parser.example;

import me.matthewe.parser.ParserFactory;
import me.matthewe.parser.ParserType;
import me.matthewe.parser.ini.Ini;
import me.matthewe.parser.ini.IniParser;
import me.matthewe.parser.json.Json;
import me.matthewe.parser.json.JsonParser;

/**
 * Created by Matthew E on 1/24/2018.
 */
public class ApplicationExample {

    public static void main(String[] args) {
        ParserFactory factory = ParserFactory.factory(builder -> {
            builder.add(ParserType.INI, IniParser::new);
            builder.add(ParserType.JSON, JsonParser::new);
        });
        IniParser iniParser = (IniParser) factory.create(ParserType.INI);
        JsonParser jsonParser = (JsonParser) factory.create(ParserType.JSON);

        Ini ini = iniParser.parse("[Hello]\nTest=Hello");
        String helloString = ini.get("Hello", "Test", String.class);

        Json json = jsonParser.parse("{\n\"HelloWorld\": \"Test\"\n}");
        String helloWorldString = json.getString("HelloWorld");


    }
}
