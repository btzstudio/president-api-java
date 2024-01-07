package tech.btzstudio.president.room;

import org.springframework.stereotype.Service;
import tech.btzstudio.president.infra.persistence.Storable;
import tech.btzstudio.president.room.domain.Room;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

@Service
public class RoomSupplier implements Supplier<Collection<Room>> {

    private final Storable<Room, UUID> roomStorage;

    public RoomSupplier (Storable<Room, UUID> roomStorage) {
        this.roomStorage = roomStorage;
    }

    @Override
    public Collection<Room> get () {
        try {
            return this.roomStorage.findAll().get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
