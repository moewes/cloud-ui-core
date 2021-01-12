package net.moewes.cloud.ui;

import java.util.Map;
import java.util.Optional;

public class UiEvent {

    private final Map<String, Object> parameter;
    private final String eventname;

    public UiEvent(String eventname, Map<String, Object> parameter) {
        this.eventname = eventname;
        this.parameter = parameter;
    }

    public Optional<Object> getParameter(String key) {
        return Optional.ofNullable(parameter.get(key));
    }

    public boolean hasParameter(String key) {
        return parameter.containsKey(key);
    }

    public String getEventname() {
        return eventname;
    }
}
