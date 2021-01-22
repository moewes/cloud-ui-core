package net.moewes.cloudui;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class UiPropertyArray extends ArrayList<UiPropertyObject> implements UiProperty {

    @Override
    public String toJson() {

        String result = "[" +
                stream().map(UiPropertyObject::toJson).collect(Collectors.joining(",")) + "]";
        return result;
    }
}
