package net.moewes.cloud.ui.html;

import net.moewes.cloud.ui.UiComponent;

@SuppressWarnings("unused")
public class H1 extends UiComponent {

    public H1() {
        this("");
    }

    public H1(String text) {
        super("h1");
        getElement().setInnerHtml(text);
    }

    public void setText(String text) {
        getElement().setInnerHtml(text);
    }
}
