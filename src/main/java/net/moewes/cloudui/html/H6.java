package net.moewes.cloudui.html;

import net.moewes.cloudui.UiComponent;

@SuppressWarnings("unused")
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
