package org.example.modals.states;

import java.util.ArrayList;
import java.util.List;
import org.example.interfaces.State;
import org.example.modals.Item;
import org.example.modals.VendingMachine;
import org.example.modals.enums.Coin;

public class IdleState implements State {

    public IdleState() {
        System.out.println("Machine is in Idle State");
    }

    public IdleState(VendingMachine machine) {
        System.out.println("Machine is in Idle State");
        machine.setCoins(new ArrayList<>());
    }
    public void clickOnInsertCoinButton(VendingMachine machine){
        machine.setVendingMachineState(new HasMoneyState());
    }

    public void clickOnSelectProductButton(VendingMachine machine) throws Exception {
        throw new Exception("In Idle State");
    }
    public void insertCoin(VendingMachine machine, Coin coin){
        System.out.println("In Idle State");
        machine.getCoins().add(coin);
    }
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("In Idle State");
    }
    public int getChange(int returnChangeAmount) throws Exception {
        throw new Exception("In Idle State");
    }
    public List<Coin> returnFullRefund(VendingMachine machine) throws Exception {
        throw new Exception("In Idle State");
    }

    public void dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("In Idle State");
    }

    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        machine.getInventory().getInventoryShelves().stream()
                .filter(inventoryShelf -> inventoryShelf.getCode() == codeNumber)
                .forEach(inventoryShelf -> inventoryShelf.setItem(item));
    }
}
