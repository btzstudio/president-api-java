package tech.btzstudio.president.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import tech.btzstudio.president.event.domain.Event;
import tech.btzstudio.president.event.domain.Publishable;

@Component
public class EventPublisher {

    private final ApplicationEventPublisher publisher;

    public EventPublisher (ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publish(Publishable event) {
        this.publisher.publishEvent(event);
    }
}
