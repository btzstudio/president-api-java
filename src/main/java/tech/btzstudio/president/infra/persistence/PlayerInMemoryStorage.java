package tech.btzstudio.president.infra.persistence;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import tech.btzstudio.president.player.domain.Player;

import java.util.*;
import java.util.concurrent.CompletableFuture;

@Service
@Log4j2
@ApplicationScope
public class PlayerInMemoryStorage implements Storable<Player, UUID> {

    private final Set<Player> players = new HashSet<>();

    @Override
    public CompletableFuture<Optional<Player>> findById (UUID sessionId) {
        PlayerInMemoryStorage.log.info("looking for {} into..", sessionId);
        PlayerInMemoryStorage.log.info(this.players);
        return CompletableFuture.completedFuture(
            this.players.stream().filter(player -> player.getSessionId().equals(sessionId)).findFirst()
        );
    }

    @Override
    public CompletableFuture<Player> save (Player player) {
        PlayerInMemoryStorage.log.info("save...");
        this.players.add(player);
        PlayerInMemoryStorage.log.info(this.players);
        return CompletableFuture.completedFuture(player);
    }

    @Override
    public CompletableFuture<Void> remove (UUID sessionId) {
        PlayerInMemoryStorage.log.info("remove...");
        this.players.removeIf(player -> player.getSessionId().equals(sessionId));
        PlayerInMemoryStorage.log.info(this.players);

        return CompletableFuture.allOf();
    }

    @Override
    public CompletableFuture<Collection<Player>> findAll () {
        return CompletableFuture.completedFuture(this.players);
    }
}
