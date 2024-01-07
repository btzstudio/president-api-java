package tech.btzstudio.president.room.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.btzstudio.president.player.domain.Player;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoomPlayer {
    private Player player;
    private boolean isOwner;
}
