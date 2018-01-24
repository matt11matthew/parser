**Parser**

Maven
```

```

Examples
```
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

```
