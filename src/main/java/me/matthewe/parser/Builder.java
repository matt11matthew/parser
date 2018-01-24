package me.matthewe.parser;

import java.util.function.Supplier;

/**
 * Created by Matthew E on 1/24/2018.
 */
public interface Builder {
    void add(ParserType type, Supplier<Parser> supplier);
}
