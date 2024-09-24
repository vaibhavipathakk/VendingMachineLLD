package org.example.modals.states;

import java.util.List;
import org.example.interfaces.State;
import org.example.modals.InventoryShelf;
import org.example.modals.Item;
import org.example.modals.VendingMachine;
import org.example.modals.enums.Coin;

public class DispenseState implements State {
    public DispenseState() {
        System.out.println("Machine is in Dispense State");
    }

    public DispenseState(VendingMachine machine, int codeNumber) {
        System.out.println("Machine is in Dispense State");
        dispenseProduct(machine, codeNumber);
    }

    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("In Dispense State");
    }

    public void clickOnSelectProductButton(VendingMachine machine) throws Exception {
        throw new Exception("In Dispense State");
    }
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("In Dispense State");
    }
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("In Dispense State");
    }
    public int getChange(int returnChangeAmount) throws Exception {
        throw new Exception("In Dispense State");
    }
    public List<Coin> returnFullRefund(VendingMachine machine) throws Exception {
        throw new Exception("In Dispense State");
    }

    public void dispenseProduct(VendingMachine machine, int codeNumber){

        Item dispensedItem =  machine.getInventory().getInventoryShelves().stream()
                .filter(inventoryShelf -> inventoryShelf.getCode() == codeNumber)
                .findFirst()
                .map(InventoryShelf::getItem)
                .orElseThrow(IllegalArgumentException::new);
        machine.getInventory().getInventoryShelves().stream()
                .filter(inventoryShelf -> inventoryShelf.getCode() == codeNumber)
                .forEach(inventoryShelf -> inventoryShelf.setSoldOut(true));
        System.out.println("Dispense Product on the tray : " + dispensedItem.getItemType().toString());
        machine.setVendingMachineState(new IdleState());
    }

    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("In Dispense State");
    }
}
