package tech.btzstudio.president.turn.action;

import tech.btzstudio.president.room.domain.ActionType;
import tech.btzstudio.president.room.domain.Game;
import tech.btzstudio.president.turn.action.domain.Action;

public interface Actionable {
    boolean supports(final ActionType action);
    void handle(final Action action, final Game game);
}
