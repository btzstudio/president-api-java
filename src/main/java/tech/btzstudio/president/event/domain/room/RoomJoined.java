package tech.btzstudio.president.event.domain.room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import tech.btzstudio.president.event.domain.Event;
import tech.btzstudio.president.room.domain.Room;

import java.util.Collection;
import java.util.List;

public class RoomJoined implements Event {

    @Override
    public String getName () {
        return "room-joined";
    }

    @Override
    public Collection<Event> next () {
        return List.of(new RoomChanged(), new RoomDestroyed(), new RoomLeft());
    }

    @Getter
    @AllArgsConstructor
    public static class With {
        private final Room room;
    }
}
