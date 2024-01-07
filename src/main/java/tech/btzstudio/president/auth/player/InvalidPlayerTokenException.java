package tech.btzstudio.president.auth.player;

public class InvalidPlayerTokenException extends Exception {

    public InvalidPlayerTokenException () {
    }

    public InvalidPlayerTokenException (Throwable cause) {
        super("The given player has been not found..", cause);
    }
}
