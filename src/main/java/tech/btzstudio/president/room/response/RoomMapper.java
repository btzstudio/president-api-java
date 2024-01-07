package tech.btzstudio.president.room.response;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tech.btzstudio.president.room.domain.Room;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    Collection<RoomResponse> toResponses(Collection<Room> rooms);

    RoomResponse toResponse(Room room);
}
