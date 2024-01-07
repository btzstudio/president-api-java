package tech.btzstudio.president.room;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import tech.btzstudio.president.auth.player.PlayerRestricted;
import tech.btzstudio.president.auth.player.PlayerInjectable;
import tech.btzstudio.president.event.domain.room.RoomCreated;
import tech.btzstudio.president.event.domain.room.RoomJoined;
import tech.btzstudio.president.event.response.WithEventResponse;
import tech.btzstudio.president.player.domain.Player;
import tech.btzstudio.president.room.request.RoomCreationRequest;
import tech.btzstudio.president.room.request.RoomApplicationRequest;
import tech.btzstudio.president.room.response.RoomMapper;
import tech.btzstudio.president.room.response.RoomResponse;

import java.util.Collection;
import java.util.UUID;

@RestController
public class RoomController {

    private final RoomSupplier roomSupplier;
    private final RoomMapper roomMapper;
    private final RoomService roomService;

    public RoomController (RoomSupplier roomSupplier, RoomMapper roomMapper, RoomService roomService) {
        this.roomSupplier = roomSupplier;
        this.roomMapper = roomMapper;
        this.roomService = roomService;
    }

    @GetMapping(value = "/rooms")
    @ResponseStatus(HttpStatus.OK)
    public Collection<RoomResponse> listRooms() {
        var rooms = this.roomSupplier.get();
        return this.roomMapper.toResponses(rooms);
    }

    @PlayerRestricted
    @PostMapping(value = "/rooms")
    @ResponseStatus(HttpStatus.CREATED)
    public WithEventResponse<RoomResponse> createRoom(@PlayerInjectable Player player, RoomCreationRequest request) {
        var room = this.roomService.createRoom(request, player);
        return new WithEventResponse<>(this.roomMapper.toResponse(room), new RoomCreated());
    }

    @PlayerRestricted
    @PostMapping(value = "/rooms/{roomId}/players")
    @ResponseStatus(HttpStatus.OK)
    public WithEventResponse<RoomResponse> joinRoom(@PlayerInjectable Player player, @PathVariable UUID roomId, RoomApplicationRequest request) {
        try {
            var room = this.roomService.joinRoom(request, player, roomId);
            return new WithEventResponse<>(this.roomMapper.toResponse(room), new RoomJoined());
        } catch (RoomNotFoundException e) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (InvalidRoomPasswordException e) {
            throw new HttpClientErrorException(HttpStatus.FORBIDDEN, e.getMessage());
        }
    }
}
