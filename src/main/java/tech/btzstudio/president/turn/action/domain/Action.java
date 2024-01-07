package tech.btzstudio.president.turn.action.domain;

import tech.btzstudio.president.player.domain.Player;
import tech.btzstudio.president.room.domain.ActionType;

public record Action(ActionType type, Player owner) {
}
