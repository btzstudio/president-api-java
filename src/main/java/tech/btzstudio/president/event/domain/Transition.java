package tech.btzstudio.president.event.domain;

import java.util.Collection;

public record Transition(Event event, Collection<? extends Event> next) {
}
