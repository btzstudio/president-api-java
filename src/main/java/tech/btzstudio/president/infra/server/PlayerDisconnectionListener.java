package tech.btzstudio.president.infra.server;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.DisconnectListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import tech.btzstudio.president.infra.persistence.Storable;
import tech.btzstudio.president.player.domain.Player;

import java.util.UUID;

@Component
@Log4j2
@Primary
public class PlayerDisconnectionListener implements DisconnectListener {
    private final Storable<Player, UUID> sessionStorage;

    public PlayerDisconnectionListener (Storable<Player, UUID> sessionStorage) {
        this.sessionStorage = sessionStorage;
    }

    @Override
    public void onDisconnect (SocketIOClient client) {
        PlayerDisconnectionListener.log.info("deco");
        this.sessionStorage.findById(client.getSessionId())
            .thenAccept(player ->
                player
                    .map(Player::getSessionId)
                    .ifPresent(this.sessionStorage::remove)
            )
        ;
    }
}
