package net.moewes.cloud.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UiElement {

  private final String tag;
  private String id;
  private String value;
  private String innerHtml;
  private List<UiElement> children;
  private List<String> events;
  private Map<String, String> attributes;

  public UiElement(String tag) {
    this.tag = tag;
    this.id = this.getClass().getName();
  }

  public void add(UiElement component) {
    if (children == null) {
      children = new ArrayList<>();
    }
    children.add(component);
    //component.setId(getId() + "_" + children.size());
  }

  public void addEvent(String event) {
    if (events == null) {
      events = new ArrayList<>();
    }
    events.add(event);
  }

  public void setAttribute(String key, String value) {
    if (attributes == null) {
      attributes = new HashMap<>();
    }
    attributes.put(key, value);
  }
}
