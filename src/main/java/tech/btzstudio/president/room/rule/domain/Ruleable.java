package tech.btzstudio.president.room.rule.domain;

import tech.btzstudio.president.room.domain.Game;
import tech.btzstudio.president.player.domain.Player;
import tech.btzstudio.president.turn.action.domain.Action;

public interface Ruleable {
    boolean supports(String name);
    Action handle(Game game, Player player);
}
