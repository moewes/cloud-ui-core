package net.moewes.cloudui.html;

import net.moewes.cloudui.UiComponent;

@SuppressWarnings("unused")
public class H3 extends UiComponent {

    public H3() {
        this("");
    }

    public H3(String text) {
        super("h3");
        getElement().setInnerHtml(text);
    }

    public void setText(String text) {
        getElement().setInnerHtml(text);
    }
}
