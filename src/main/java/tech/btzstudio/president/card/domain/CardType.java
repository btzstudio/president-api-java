package tech.btzstudio.president.card.domain;

public enum CardType {

    SPADER("spader"),
    HEART("heart"),
    DIAMOND("diamond"),
    CLUB("club");

    private final String type;

    CardType (String type) {
        this.type = type;
    }

    public String getType () {
        return type;
    }
}
