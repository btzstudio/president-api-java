package tech.btzstudio.president.card.domain;

public enum CardPower {

    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    HEIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    AS(14),
    TWO(25);

    private final int power;

    CardPower(int power) {
        this.power = power;
    }

    public int getPower () {
        return power;
    }
}
