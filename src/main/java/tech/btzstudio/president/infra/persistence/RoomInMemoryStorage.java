package tech.btzstudio.president.infra.persistence;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import tech.btzstudio.president.room.domain.Room;

import java.util.*;
import java.util.concurrent.CompletableFuture;

@Service
@ApplicationScope
public class RoomInMemoryStorage implements Storable<Room, UUID> {

    private final SortedSet<Room> rooms = new TreeSet<>(Comparator.comparing(Room::getModifiedAt));

    @Override
    public CompletableFuture<Optional<Room>> findById (UUID roomId) {
        return CompletableFuture.completedFuture(
            this.rooms.stream().filter(room -> room.getId().equals(roomId)).findFirst()
        );
    }

    @Override
    public CompletableFuture<Void> save (Room room) {
        var alreadyExists = this.rooms.stream()
            .map(Room::getName)
            .anyMatch(name -> name.equals(room.getName()))
        ;

        if (alreadyExists) {
            return CompletableFuture.failedFuture(
                new PersistenceDuplicatedException("player:duplicated:name")
            );
        }

        this.rooms.add(room);
        return CompletableFuture.allOf();
    }

    @Override
    public CompletableFuture<Void> remove (UUID roomId) {
        this.rooms.removeIf(room -> room.getId().equals(roomId));
        return CompletableFuture.allOf();
    }

    @Override
    public CompletableFuture<Collection<Room>> findAll () {
        return CompletableFuture.completedFuture(this.rooms);
    }
}
