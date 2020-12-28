package net.moewes.cloud.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import lombok.Getter;


public class UiComponent {

    private final String tag;
    @Getter
    private String id;
    private List<UiComponent> children = new ArrayList<>();
    private UiElement uiElement;
    private UiBinder binder;
    private Consumer<String> eventHandler;

    public UiComponent() {
        this("div");
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
        children.add(component);
        component.setId(getId() + "_" + children.size());
        getElement().add(component.getElement());
    }

    public void add(UiComponent... components) {
        Arrays.stream(components).forEach(this::add);
    }

    public void remove(UiComponent component) {
        children.remove(component);
        getElement().remove(component.getElement());
    }

    public UiElement getElement() {
        return uiElement;
    }

    public UiElement render() {

        if (children != null) {
            children.stream().forEach(UiComponent::render);
        }
        getValuesFromBinder();
        if (uiElement.getValue() == null) {
            uiElement.setValue(getEmptyValue());
        }
        return uiElement;
    }

    protected String getEmptyValue() {
        return "";
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

    public void setId(String id) {
        this.id = id;
        getElement().setId(getId());

        children.forEach(child -> {
            child.setId(getId() + child.getId());
        });
    }
}