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
    private List<UiEventDefinition> events;
    private Set<UiElementAttribute> attributes;
    private Set<UiElementAttribute> properties;

    /**
     * default constructor
     *
     * @param tag tag of the web component or html element
     */
    public UiElement(String tag) {
        this.tag = tag;
    }

    /**
     * add a child element to the DOM tree
     *
     * @param element
     */
    public void add(UiElement element) {
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(element);
    }

    public void addEvent(UiEventDefinition event) {
        if (events == null) {
            events = new ArrayList<>();
        }
        events.add(event);
    }

    /**
     * removes a child element from the DOM tree
     *
     * @param element the element to remove
     */
    public void remove(UiElement element) {
        if (children != null) {
            children.remove(element);
        }
    }

    /**
     * sets an attribute of the web component that is represented with this instance
     *
     * @param key   name of the attribute
     * @param value value as string
     */
    public void setAttribute(String key, String value) {
        if (attributes == null) {
            attributes = new HashSet<>();
        }
        attributes.add(new UiElementAttribute(key, value));
    }

    /**
     * sets a property of the HTMLElement that is represented with this instance
     *
     * @param name  name of the property
     * @param value value of the property as a json string
     */
    public void setProperty(String name, String value) {
        if (properties == null) {
            properties = new HashSet<>();
        }
        properties.add(new UiElementAttribute(name, value));
    }
}
