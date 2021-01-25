package net.moewes.cloudui;

import java.util.List;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UiEventDefinition {

    private final String eventName;
    private final List<UiEventAttributeMapping> attributeMappings;
}
