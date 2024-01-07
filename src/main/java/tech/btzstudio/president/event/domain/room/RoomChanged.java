package tech.btzstudio.president.event.domain.room;

import tech.btzstudio.president.event.domain.Event;

import java.util.Collection;
import java.util.List;

public class RoomChanged implements Event {

    @Override
    public String getName () {
        return "room-changed";
    }

    @Override
    public Collection<Event> next () {
        return List.of(
            new RoomChanged(),
            new RoomDestroyed(),
            new RoomLeft(),
            new RoomJoined(),
            new RoomDestroyed()
        );
    }
}
