package tech.btzstudio.president.player;

import org.springframework.stereotype.Service;
import tech.btzstudio.president.infra.persistence.Storable;
import tech.btzstudio.president.player.domain.Player;
import tech.btzstudio.president.player.request.PlayerCreationRequest;
import tech.btzstudio.president.player.response.PlayerResponse;

import java.util.UUID;

@Service
public class PlayerService {

    private final Storable<Player, UUID> playerStorage;

    public PlayerService (Storable<Player, UUID> playerStorage) {
        this.playerStorage = playerStorage;
    }

    public PlayerResponse createPlayer(PlayerCreationRequest request) {
        var player = this.playerStorage.save(new Player(request.name())).resultNow();
        return new PlayerResponse(player.getName());
    }
}
