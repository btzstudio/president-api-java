package tech.btzstudio.president.event.domain.room;

import tech.btzstudio.president.event.domain.Event;

import java.util.Collection;

public class RoomDestroyed implements Event {

    @Override
    public String getName () {
        return "room-destroyed";
    }

    public Collection<Event> next () {
        return null;
    }
}
