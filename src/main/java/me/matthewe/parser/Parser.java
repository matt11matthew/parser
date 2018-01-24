package me.matthewe.parser;

/**
 * Created by Matthew E on 1/24/2018.
 */
public interface Parser<V> {
    V parse(String string);
}
