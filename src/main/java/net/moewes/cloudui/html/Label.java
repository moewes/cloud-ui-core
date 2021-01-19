package net.moewes.cloudui.html;

import net.moewes.cloudui.UiComponent;

@SuppressWarnings("unused")
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
