package net.moewes.cloudui;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UiEventAttributeMapping {

    private String fieldName;
    private boolean isHtmlElement;
}
