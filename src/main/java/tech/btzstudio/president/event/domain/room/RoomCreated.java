package tech.btzstudio.president.event.domain.room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import tech.btzstudio.president.event.domain.Event;
import tech.btzstudio.president.room.domain.Room;

import java.util.Collection;
import java.util.List;

@Getter
public class RoomCreated implements Event {

    @Override
    public String getName () {
        return "room-created";
    }

    @Override
    public Collection<Event> next () {
        return List.of(
            new RoomJoined(),
            new RoomDestroyed(),
            new RoomLeft(),
            new RoomChanged()
        );
    }

    @Getter
    @AllArgsConstructor
    public static class With {
        private final Room room;
    }
}
