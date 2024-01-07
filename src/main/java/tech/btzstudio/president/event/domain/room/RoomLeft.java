package tech.btzstudio.president.event.domain.room;

import tech.btzstudio.president.event.domain.Event;

import java.util.Collection;
import java.util.List;

public class RoomLeft implements Event {

    @Override
    public String getName () {
        return "room-left";
    }

    @Override
    public Collection<Event> next () {
        return List.of(
            new RoomLeft(),
            new RoomChanged(),
            new RoomJoined(),
            new RoomDestroyed()
        );
    }
}
