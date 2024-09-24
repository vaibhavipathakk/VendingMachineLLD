package org.example.modals;

import java.util.List;

public class Inventory {
    private List<InventoryShelf> inventoryShelves;

    public Inventory(List<InventoryShelf> inventoryShelves) {
        this.inventoryShelves = inventoryShelves;
    }

    public List<InventoryShelf> getInventoryShelves() {
        return inventoryShelves;
    }

    public void setInventoryShelves(List<InventoryShelf> inventoryShelves) {
        this.inventoryShelves = inventoryShelves;
    }
}
