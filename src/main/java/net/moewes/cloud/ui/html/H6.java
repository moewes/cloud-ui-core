package net.moewes.cloud.ui.html;

import net.moewes.cloud.ui.UiComponent;

public class H6 extends UiComponent {

  public H6() {
    this("");
  }

  public H6(String text) {
    super("h6");
    getElement().setInnerHtml(text);
  }

  public void setText(String text) {
    getElement().setInnerHtml(text);
  }
}
