package tech.btzstudio.president.room;

import org.springframework.stereotype.Service;
import tech.btzstudio.president.infra.persistence.PersistenceDuplicatedException;
import tech.btzstudio.president.infra.persistence.PlayerInMemoryStorage;
import tech.btzstudio.president.infra.persistence.RoomInMemoryStorage;
import tech.btzstudio.president.infra.server.request.RoomReachingRequest;
import tech.btzstudio.president.infra.server.response.RoomReachingResponse;
import tech.btzstudio.president.room.domain.Room;
import tech.btzstudio.president.room.domain.RoomHandler;
import tech.btzstudio.president.room.domain.RoomPlayer;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

@Service
public class RoomCreationHandler implements RoomHandler {

    private final RoomInMemoryStorage roomStorage;
    private final PlayerInMemoryStorage playerStorage;

    public RoomCreationHandler (RoomInMemoryStorage roomStorage, PlayerInMemoryStorage playerStorage) {
        this.roomStorage = roomStorage;
        this.playerStorage = playerStorage;
    }

    @Override
    public boolean supports (RoomReachingRequest request) {
        return request.isNew();
    }

    @Override
    public CompletableFuture<RoomReachingResponse> handle (RoomReachingRequest request) {
        var playerSupplier = this.playerStorage.findById(request.playerId());

        return playerSupplier.thenCompose(player ->
            player.map(value ->
                CompletableFuture.completedFuture(new Room(request.name(), Collections.singleton(new RoomPlayer(value, true)))))
            .orElseGet(() -> CompletableFuture.failedFuture(new RoomOperationFailureException("player:not-found"))))
                .thenApply(room -> {
                    this.roomStorage.save(room);
                    return room;
            })
            .thenApply(room -> new RoomReachingResponse(RoomReachingResponse.Event.ROOM_CREATION, room))
        ;
    }
}
