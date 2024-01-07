package tech.btzstudio.president.turn;

import tech.btzstudio.president.player.domain.Player;
import tech.btzstudio.president.turn.action.domain.Action;

import java.util.Set;

public class Turn {

    private Player winner;

    private Set<Action> actions;
}
