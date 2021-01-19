package net.moewes.cloudui.html;

import net.moewes.cloudui.UiComponent;

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
