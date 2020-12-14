package net.moewes.cloud.ui.html;

import net.moewes.cloud.ui.UiComponent;

public class Button extends UiComponent {

  public Button() {
    this("");
  }

  public Button(String text) {
    super("button");
    getElement().setInnerHtml(text);
  }

  public void setText(String text) {
    getElement().setInnerHtml(text);
  }
}
