package net.moewes.cloud.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import lombok.Getter;
import lombok.Setter;


public class UiComponent {

  private final String tag;
  @Getter
  @Setter
  private String id;
  private List<UiComponent> children;
  private UiElement uiElement;
  private UiBinder binder;
  private Consumer<String> eventHandler;

  public UiComponent() {
    this.tag = "div";
    this.id = this.getClass().getName();
    uiElement = new UiElement(tag);
    uiElement.setId(this.getId());
  }

  public UiComponent(String tag) {
    this.tag = tag;
    this.id = this.getClass().getName();
    uiElement = new UiElement(tag);
    uiElement.setId(this.getId());
  }

  public void bind(UiBinder binder) {
    this.binder = binder;
  }

  public void unbind() {
    binder = null;
  }

  public void add(UiComponent component) {
    if (children == null) {
      children = new ArrayList<>();
    }
    children.add(component);
    component.setId(getId() + "_" + children.size());
    component.getElement().setId(component.getId());
    getElement().add(component.getElement());
  }

  public UiElement getElement() {
    return uiElement;
  }

  public UiElement render() {

    if (children != null) {
      children.stream().forEach(UiComponent::render);
    }
    getValuesFromBinder();
    return uiElement;
  }

  private void getValuesFromBinder() {
    if (binder != null) {
      binder.setValue(); // FIXME Name
    }
  }

  public void setValue(String value) {
    getElement().setValue(value);
  }

  public void setValuesWithBinder() {
    if (binder != null) {
      binder.getValue(); // FIXME Name
    }
  }

  public String getValue() {
    return getElement().getValue();
  }


  public void setInnerHtml(String content) {
    getElement().setInnerHtml(content);
  }

  public Optional<UiComponent> getComponentWithId(String id) {
    if (this.getId().equals(id)) {
      System.out.println("found id " + id);
      return Optional.of(this);
    } else if (children != null) {
      for (UiComponent item : children) {
        Optional<UiComponent> x = item.getComponentWithId(id);
        if (x.isPresent()) {
          return x;
        }
      }
      return Optional.empty();
    } else {
      return Optional.empty();
    }
  }

  public void addEventListener(String event, Consumer<String> function) {
    this.eventHandler = function;
    getElement().addEvent(event);
  }

  public void handleEvent(String click) {
    if (eventHandler != null) {
      eventHandler.accept(click);
    }
  }
}