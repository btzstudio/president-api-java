package tech.btzstudio.president.room;

public class InvalidRoomPasswordException extends Exception {
    public InvalidRoomPasswordException () {
        super("The room password is invalid.");
    }
}
