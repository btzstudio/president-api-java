package tech.btzstudio.president.room.domain;

public enum ActionType {

    DISPATCHING("dispatching"),
    PLAY("play"),
    PASS("pass"),
    SKIPPED("skipped");

    private final String type;

    ActionType (String type) {
        this.type = type;
    }

    public String getType () {
        return type;
    }
}
