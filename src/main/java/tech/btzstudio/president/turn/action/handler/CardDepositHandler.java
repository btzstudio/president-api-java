package tech.btzstudio.president.turn.action.handler;

import tech.btzstudio.president.room.domain.Game;
import tech.btzstudio.president.room.domain.ActionType;
import tech.btzstudio.president.turn.action.domain.Action;
import tech.btzstudio.president.turn.action.Actionable;

public class CardDepositHandler implements Actionable {

    @Override
    public boolean supports (ActionType action) {
        return false;
    }

    @Override
    public void handle (Action action, Game game) {

    }
}
