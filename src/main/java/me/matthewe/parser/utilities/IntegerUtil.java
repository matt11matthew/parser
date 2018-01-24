package me.matthewe.parser.utilities;

/**
 * Created by Matthew E on 1/24/2018.
 */
public class IntegerUtil {
    public static boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
