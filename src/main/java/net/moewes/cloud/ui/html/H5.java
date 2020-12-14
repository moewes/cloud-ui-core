package net.moewes.cloud.ui.html;

import net.moewes.cloud.ui.UiComponent;

public class H5 extends UiComponent {

  public H5() {
    this("");
  }

  public H5(String text) {
    super("h5");
    getElement().setInnerHtml(text);
  }

  public void setText(String text) {
    getElement().setInnerHtml(text);
  }
}
