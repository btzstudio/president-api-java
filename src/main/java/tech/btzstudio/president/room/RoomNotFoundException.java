package tech.btzstudio.president.room;

public class RoomNotFoundException extends Exception {
    public RoomNotFoundException (String roomId) {
        super(String.format("The room \"%s\" has been not found.", roomId));
    }
}
