package tech.btzstudio.president.room;

import org.springframework.stereotype.Service;
import tech.btzstudio.president.event.EventPublisher;
import tech.btzstudio.president.event.domain.Publishable;
import tech.btzstudio.president.event.domain.room.RoomCreated;
import tech.btzstudio.president.event.domain.room.RoomJoined;
import tech.btzstudio.president.infra.persistence.Storable;
import tech.btzstudio.president.player.domain.Player;
import tech.btzstudio.president.room.domain.Room;
import tech.btzstudio.president.room.domain.RoomPlayer;
import tech.btzstudio.president.room.request.RoomApplicationRequest;
import tech.btzstudio.president.room.request.RoomCreationRequest;

import java.util.Collections;
import java.util.UUID;

@Service
public class RoomService {

    private final Storable<Room, UUID> roomStorage;
    private final EventPublisher publisher;

    public RoomService (Storable<Room, UUID> roomStorage, EventPublisher publisher) {
        this.roomStorage = roomStorage;
        this.publisher = publisher;
    }

    public Room createRoom(RoomCreationRequest request, Player player) {
        var room = new Room(request.getName(), Collections.singleton(new RoomPlayer(player, true)));
        this.roomStorage.save(room).resultNow();
        this.publisher.publish(new Publishable(new RoomCreated.With(room)));
        return room;
    }

    public Room joinRoom(RoomApplicationRequest request, Player player, UUID roomId) throws RoomNotFoundException, InvalidRoomPasswordException {
        var room = this.roomStorage.findById(roomId)
            .resultNow()
            .orElseThrow(() -> new RoomNotFoundException(roomId.toString()))
        ;

        if (room.isPrivate() && !room.getPassword().equals(request.password())) {
            throw new InvalidRoomPasswordException();
        }

        room.addPlayer(player);
        this.publisher.publish(new Publishable(new RoomJoined.With(room)));

        return room;
    }
}
