package tech.btzstudio.president;

import tech.btzstudio.president.turn.action.domain.Action;

import java.util.function.Function;

public class PlayContextResolver implements Function<PlayerPayload, Action> {

    @Override
    public Action apply (PlayerPayload playerPayload) {
        return null;
    }
}
