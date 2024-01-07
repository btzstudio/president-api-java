package tech.btzstudio.president.event.domain;

import java.util.Collection;

public interface Event {

    String getName();

    Collection<? extends Event> next();
}
