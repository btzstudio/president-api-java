package tech.btzstudio.president.auth.player;

public class ForbiddenPlayerException extends RuntimeException {
    public ForbiddenPlayerException (String message) {
        super(message);
    }
}
