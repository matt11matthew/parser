package me.matthewe.parser.ini;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matthew E on 1/24/2018.
 */
public class Ini {
    private List<IniSection> sections;

    public Ini() {
        this.sections = new ArrayList<>();
    }

    public <O extends Object> O get(String section, String key, Class<O> oClass, O defaultO) {
        for (IniSection iniSection : sections) {
            if (iniSection.getName().equals(section)) {
                return iniSection.get(key, oClass);
            }
        }
        return defaultO;
    }

    public <O extends Object> O get(String section, String key, Class<O> oClass) {
        return get(section, key, oClass, null);
    }

    public void setSections(List<IniSection> sections) {
        this.sections = sections;
    }

    public List<IniSection> getSections() {
        return sections;
    }
}
