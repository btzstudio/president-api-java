package tech.btzstudio.president.player.domain;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Player {

    private final UUID sessionId;

    private final String name;

    public Player(final String name) {
        this.sessionId = UUID.randomUUID();
        this.name = name;
    }

    public Player (final UUID sessionId, final String name) {
        this.sessionId = sessionId;
        this.name = name;
    }
}
