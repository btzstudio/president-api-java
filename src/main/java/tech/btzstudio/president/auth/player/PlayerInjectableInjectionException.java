package tech.btzstudio.president.auth.player;

public class PlayerInjectableInjectionException extends Exception {
    public PlayerInjectableInjectionException () {
        super("Unable to find \"player\" field on request attributes list.");
    }
}
