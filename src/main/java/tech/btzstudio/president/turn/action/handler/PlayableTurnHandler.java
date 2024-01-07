package tech.btzstudio.president.turn.action.handler;

import tech.btzstudio.president.room.domain.Game;
import tech.btzstudio.president.room.domain.ActionType;
import tech.btzstudio.president.room.rule.domain.Ruleable;
import tech.btzstudio.president.turn.action.Actionable;
import tech.btzstudio.president.turn.action.domain.Action;

import java.util.Set;

public class PlayableTurnHandler implements Actionable {

    private Set<Ruleable> rules;

    public PlayableTurnHandler (Set<Ruleable> rules) {
        this.rules = rules;
    }

    @Override
    public boolean supports (ActionType action) {
        return true;
    }

    @Override
    public void handle (Action action, Game game) {
        this.rules.forEach(rule -> {

        });
    }
}
