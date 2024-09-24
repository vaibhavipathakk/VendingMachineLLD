package org.example.modals;

import org.example.modals.Item;

public class InventoryShelf {
    private Item item;
    private final int code;
    private boolean isSoldOut;

    public InventoryShelf(Item item, int code, boolean isSoldOut) {
        this.item = item;
        this.code = code;
        this.isSoldOut = isSoldOut;
    }

    public Item getItem() {
        return item;
    }

    public int getCode() {
        return code;
    }

    public boolean getIsSoldOut() {
        return isSoldOut;
    }

    public void setSoldOut(boolean soldOut) {
        isSoldOut = soldOut;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
