package tech.btzstudio.president.auth;

import org.springframework.stereotype.Component;
import tech.btzstudio.president.infra.persistence.Storable;
import tech.btzstudio.president.player.domain.Player;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Component
public class AuthService {

    private final Storable<Player, UUID> sessionsStorage;

    public AuthService (Storable<Player, UUID> sessionsStorage) {
        this.sessionsStorage = sessionsStorage;
    }

    public CompletableFuture<Player> createSession() {
        var player = new Player("lo");

        return this.sessionsStorage.save(player)
            .thenCompose(n -> CompletableFuture.completedFuture(player)
        );
    }
}
