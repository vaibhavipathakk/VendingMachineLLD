package org.example.modals.enums;

public enum Coin {
    ONE (1),
    FIVE (5),
    TEN (10),
    FIFTY (50),
    HUNDRED (100);

    private int monetoryValue;

    Coin(int monetoryValue) {
        this.monetoryValue = monetoryValue;
    }

    public int getMonetoryValue() {
        return monetoryValue;
    }
}
