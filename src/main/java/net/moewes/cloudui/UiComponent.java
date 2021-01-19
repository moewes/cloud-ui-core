package net.moewes.cloudui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

import lombok.Getter;


/**
 * represents a node/element
 */
public class UiComponent {

    @Getter
    private String id;
    private final List<UiComponent> children = new ArrayList<>();
    private final UiElement uiElement;
    private UiBinder binder;
    private final Map<String, Consumer<UiEvent>> eventHandlerList = new HashMap<>();

    /**
     * constructor creates a div
     */
    public UiComponent() {
        this("div");
    }

    /**
     * default constructor
     *
     * @param tag html element or web component
     */
    public UiComponent(String tag) {
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

    /**
     * adds a child element
     *
     * @param component child component
     */
    public void add(UiComponent component) {
        children.add(component);
        component.setId(getId() + "_" + children.size());
        getElement().add(component.getElement());
    }

    /**
     * adds multiple child components
     *
     * @param components child components
     */
    public void add(UiComponent... components) {
        Arrays.stream(components).forEach(this::add);
    }

    /**
     * remove a child component
     *
     * @param component the component to remove
     */
    public void remove(UiComponent component) {
        children.remove(component);
        getElement().remove(component.getElement());
    }

    /**
     * @return UiElement of the component
     */
    public UiElement getElement() {
        return uiElement;
    }

    public UiElement render() {

        children.forEach(UiComponent::render);

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
        } else {
            for (UiComponent item : children) {
                Optional<UiComponent> x = item.getComponentWithId(id);
                if (x.isPresent()) {
                    return x;
                }
            }
            return Optional.empty();
        }
    }

    public <T extends UiEvent> void addEventListener(String event, Consumer<T> function) {

        eventHandlerList.put(event, (Consumer<UiEvent>) function);
        getElement().addEvent(event);
    }

    public void handleEvent(UiEvent event) {

        Consumer<UiEvent> uiEventConsumer = eventHandlerList.get(event.getEventname());
        if (uiEventConsumer != null) {
            uiEventConsumer.accept(event);
        }
    }

    public void setId(String id) {
        this.id = id;
        getElement().setId(getId());

        children.forEach(child -> child.setId(getId() + child.getId()));
    }
}