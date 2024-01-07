package tech.btzstudio.president.infra.server;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.ConnectListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import tech.btzstudio.president.auth.AuthService;
import tech.btzstudio.president.auth.WebSocketAuthorizationListener;
import tech.btzstudio.president.infra.persistence.Storable;
import tech.btzstudio.president.player.domain.Player;

import java.util.Optional;
import java.util.UUID;

@Component
@Primary
@Log4j2
public class PlayerConnectionListener implements ConnectListener {

    private final Storable<Player, UUID> sessionStorage;
    private final AuthService authService;

    public PlayerConnectionListener (Storable<Player, UUID> sessionStorage, AuthService authService) {
        this.sessionStorage = sessionStorage;
        this.authService = authService;
    }

    @Override
    public void onConnect (SocketIOClient client) {
        var headers  = client.getHandshakeData().getHttpHeaders();
        Optional.ofNullable(headers.getAsString(""))
            .ifPresent(token -> {
//                this.authService.findSession(UUID.fromString(token))
//                    .thenAccept(player -> {
//                        if (player.isEmpty()) {
//                            this.sessionStorage.save(new Player(client.getSessionId())).resultNow();
//                        }
                      }
                );
    }
}
