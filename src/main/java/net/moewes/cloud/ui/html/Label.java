package net.moewes.cloud.ui.html;

import net.moewes.cloud.ui.UiComponent;

public class Label extends UiComponent {

  public Label() {
    this("");
  }

  public Label(String text) {
    super("label");
    getElement().setInnerHtml(text);
  }

  public void setText(String text) {
    getElement().setInnerHtml(text);
  }
}
