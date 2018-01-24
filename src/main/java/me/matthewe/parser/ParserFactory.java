package me.matthewe.parser;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by Matthew E on 1/24/2018.
 */
public interface ParserFactory {
    Parser<?> create(ParserType type);

    static ParserFactory factory(Consumer<Builder> consumer) {
        Map<ParserType, Supplier<Parser>> map = new HashMap<>();
        consumer.accept(map::put);
        return type -> map.get(type).get();
    }
}
