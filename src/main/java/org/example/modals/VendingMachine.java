package org.example.modals;

import java.util.List;
import org.example.interfaces.State;
import org.example.modals.enums.Coin;
import org.example.modals.states.IdleState;

public class VendingMachine {
    private State vendingMachineState;
    private Inventory inventory;

    private List<Coin> coins;

    public VendingMachine(){
        this.vendingMachineState = new IdleState();
    }


    public List<Coin> getCoins() {
        return coins;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public State getVendingMachineState() {
        return vendingMachineState;
    }

    public void setVendingMachineState(State vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }
}
