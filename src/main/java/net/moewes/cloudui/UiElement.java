package net.moewes.cloudui;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UiElement {

    private final String tag;
    private String id;
    private String value;
    private boolean hasInput;
    private String innerHtml;
    private List<UiElement> children;
    private List<String> events;
    private Set<UiElementAttribute> attributes;

    public UiElement(String tag) {
        this.tag = tag;
        this.id = this.getClass().getName();
    }

    public void add(UiElement element) {
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(element);
    }

    public void addEvent(String event) {
        if (events == null) {
            events = new ArrayList<>();
        }
        events.add(event);
    }

    public void remove(UiElement element) {
        if (children != null) {
            children.remove(element);
        }
    }

    public void setAttribute(String key, String value) {
        if (attributes == null) {
            attributes = new HashSet<>();
        }
        attributes.add(new UiElementAttribute(key, value));
    }
}
