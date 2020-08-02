package net.moewes.cloud.ui;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class UiBinder {

  private Supplier<?> getter;
  private Consumer<Object> setter;
  private UiComponent component;
  private Object model;

  public void bind(UiComponent component, Object model, Supplier<?> getter,
      Consumer<Object> setter) {

    this.getter = getter;
    this.setter = setter;
    this.model = model;
    this.component = component;
    component.bind(this);
  }

  public void setValue() {

    Object o = getter.get();
    component.setValue(o.toString());
  }

  public void getValue() {
    setter.accept(component.getValue());
  }
}
