package tech.btzstudio.president.event.response;

import lombok.Getter;
import tech.btzstudio.president.event.domain.Event;

import java.util.Collection;

@Getter
public class WithEventResponse<T> {
    private final T payload;
    private final Collection<? extends Event> observables;

    public WithEventResponse (T payload, Event event) {
        this.payload = payload;
        this.observables = event.next();
    }
}
