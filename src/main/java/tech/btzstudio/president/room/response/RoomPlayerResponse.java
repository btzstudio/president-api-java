package tech.btzstudio.president.room.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import tech.btzstudio.president.player.response.PlayerResponse;

@Data
@Getter
@AllArgsConstructor
public class RoomPlayerResponse {
    private PlayerResponse player;
    private boolean isOwner;
}
