package tech.btzstudio.president.room.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.btzstudio.president.player.domain.Player;
import tech.btzstudio.president.room.rule.domain.Ruleable;

import java.util.*;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    public Room (String name, Set<RoomPlayer> players) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.players = players;
        this.createdAt = new Date();
        this.modifiedAt = new Date();
    }

    private UUID id;

    private Date createdAt;

    private Date modifiedAt;

    private String name;

    private String password;

    private Set<RoomPlayer> players;

    private Collection<Ruleable> rules;

    private Stack<Game> games;

    public Game getCurrentGame()
    {
        return games.peek();
    }

    public boolean isPrivate() {
        return Optional.ofNullable(this.password).isPresent();
    }

    public Room addPlayer(Player player) {
        this.players.add(new RoomPlayer(player, false));
        return this;
    }
}
