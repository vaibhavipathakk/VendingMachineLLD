package org.example.modals.states;

import java.util.List;
import org.example.interfaces.State;
import org.example.modals.InventoryShelf;
import org.example.modals.Item;
import org.example.modals.VendingMachine;
import org.example.modals.enums.Coin;

public class SelectionState implements State {
    public SelectionState() {
        System.out.println("Machine is in Selection State");
    }

    public SelectionState(VendingMachine machine) {
        System.out.println("Machine is in Selection State");
    }
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("In Selection State");
    }

    public void clickOnSelectProductButton(VendingMachine machine) throws Exception {
        return;
    }
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("Cannot inset coins in Selection State");
    }
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        // get product using entered code
        Item item = machine.getInventory().getInventoryShelves()
                .stream()
                .filter(inventoryShelf -> inventoryShelf.getCode() == codeNumber)
                .findFirst()
                .map(InventoryShelf::getItem)
                .orElseThrow(Exception::new);

        //total amount paid by user
        int amountPaidByUser = 0;
        for (Coin coin : machine.getCoins()) {
            amountPaidByUser += coin.getMonetoryValue();
        }

        if (amountPaidByUser < item.getPrice()) throw new RuntimeException("Insufficient amount paid");
        else {
            if ( amountPaidByUser > item.getPrice()) {
                getChange(amountPaidByUser - item.getPrice());
            }
            machine.setVendingMachineState(new DispenseState(machine, codeNumber));
        }
    }
    public int getChange(int returnChangeAmount) throws Exception {
        System.out.println("Collect the extra amount paid from the tray: " + returnChangeAmount);
        return returnChangeAmount;
    }
    public List<Coin> returnFullRefund(VendingMachine machine){
        return machine.getCoins();
    }

    public void dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("In Selection State");
    }

    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("In Selection State");
    }
}
