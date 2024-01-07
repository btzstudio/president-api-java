package tech.btzstudio.president.infra.server.response;

import tech.btzstudio.president.room.domain.Room;

public record RoomReachingResponse(Event event, Room room) {

    public enum Event {
        ROOM_CREATION("new"),
        ROOM_REACHING("reach");

        final String name;

        Event (String name) {
            this.name = name;
        }

        @Override
        public String toString () {
            return this.name;
        }
    }
}
