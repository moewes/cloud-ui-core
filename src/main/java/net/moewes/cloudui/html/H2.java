package net.moewes.cloudui.html;

import net.moewes.cloudui.UiComponent;

@SuppressWarnings("unused")
public class H2 extends UiComponent {

    public H2() {
        this("");
    }

    public H2(String text) {
        super("h2");
        getElement().setInnerHtml(text);
    }

    public void setText(String text) {
        getElement().setInnerHtml(text);
    }
}
