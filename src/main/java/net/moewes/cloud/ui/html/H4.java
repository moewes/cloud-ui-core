package net.moewes.cloud.ui.html;

import net.moewes.cloud.ui.UiComponent;

public class H4 extends UiComponent {

  public H4() {
    this("");
  }

  public H4(String text) {
    super("h4");
    getElement().setInnerHtml(text);
  }

  public void setText(String text) {
    getElement().setInnerHtml(text);
  }
}
