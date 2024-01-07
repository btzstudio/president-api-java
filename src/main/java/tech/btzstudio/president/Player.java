package tech.btzstudio.president;

import tech.btzstudio.president.turn.action.Actionable;

import java.util.Set;

public class Player {

    private final PlayContextResolver contextResolver;
    private final Set<Actionable> handlers;

    public Player (PlayContextResolver contextResolver, Set<Actionable> turnHandlers) {
        this.contextResolver = contextResolver;
        this.handlers = turnHandlers;
    }

    public void play(PlayRequest request) {
        var action = this.contextResolver.apply(request.payload());

        for (Actionable handler : this.handlers) {
            if (handler.supports(action.type())) {
                handler.handle(action, request.context().room().getCurrentGame());
            }
        }
    }
}
