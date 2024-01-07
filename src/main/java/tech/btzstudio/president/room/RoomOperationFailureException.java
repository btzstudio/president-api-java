package tech.btzstudio.president.room;

public class RoomOperationFailureException extends Exception {
    public RoomOperationFailureException (String message, Throwable cause) {
        super(message, cause);
    }

    public RoomOperationFailureException (String message) {
        super(message);
    }
}
