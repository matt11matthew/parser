package me.matthewe.parser.ini;

import me.matthewe.parser.Parser;
import me.matthewe.parser.utilities.IntegerUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Matthew E on 1/24/2018.
 */
public class IniParser implements Parser<Ini> {
    private final Pattern KEY_VALUES = Pattern.compile("\\s*([^=]*)=(.*)");
    private final Pattern SECTION = Pattern.compile("\\s*\\[([^]]*)]\\s*");

    public IniParser() {
    }

    @Override
    public Ini parse(String string) {
        Ini ini = new Ini();
        Map<String, IniSection> iniSectionMap = new HashMap<>();
        IniSection currentSection = null;
        for (String line : string.split("\n")) {
            Matcher keyValueMatcher = KEY_VALUES.matcher(line);
            Matcher sectionMatcher = SECTION.matcher(line);
            if (sectionMatcher.matches()) {
                currentSection = new IniSection(sectionMatcher.group(1).trim());
                iniSectionMap.put(currentSection.getName(), currentSection);
            }
            if (currentSection != null && (keyValueMatcher.matches())) {
                String key = keyValueMatcher.group(1).trim();
                String value = keyValueMatcher.group(2).trim();
                Object newValue;
                if (IntegerUtil.isInteger(value)) {
                    newValue = Integer.parseInt(value.trim());
                } else {
                    newValue = value;
                }
                currentSection.addKeyValue(new IniKeyValue(key, newValue));
                iniSectionMap.remove(currentSection.getName());
                iniSectionMap.put(currentSection.getName(), currentSection);
            }
        }
        ini.setSections(new ArrayList<>(iniSectionMap.values()));
        return ini;
    }
}
