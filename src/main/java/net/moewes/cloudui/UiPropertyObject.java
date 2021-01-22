package net.moewes.cloudui;

import java.util.HashMap;
import java.util.stream.Collectors;

// TODO JavaDoc
public class UiPropertyObject extends HashMap<String, String> implements UiProperty {

    @Override
    public String toJson() {

        String collect = keySet().stream().map(key -> {
            String value = get(key);
            return "\"" + key + "\" : " + value;
        }).collect(Collectors.joining(","));
        return "{" + collect + "}";
    }
}
