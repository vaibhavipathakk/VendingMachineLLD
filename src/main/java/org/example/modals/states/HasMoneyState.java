package org.example.modals.states;

import java.util.List;
import org.example.interfaces.State;
import org.example.modals.Item;
import org.example.modals.VendingMachine;
import org.example.modals.enums.Coin;

public class HasMoneyState implements State {
    public HasMoneyState() {
        System.out.println("Machine is in HasMoney State");
    }

    public HasMoneyState(VendingMachine machine) {
        System.out.println("Machine is in HasMoney State");
        machine.setVendingMachineState(new SelectionState());
    }
    public void clickOnInsertCoinButton(VendingMachine machine){
        System.out.println("In HasMoney State");
    }

    public void clickOnSelectProductButton(VendingMachine machine){
        System.out.println("Next step is to click on Product selection state.");
        machine.setVendingMachineState(new SelectionState());
    }
    public void insertCoin(VendingMachine machine, Coin coin){
        System.out.println("Accepted the coin of value : " + coin.getMonetoryValue());
        machine.setCoins(List.of(coin));
    }
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("In HasMoney State");
    }
    public int getChange(int returnChangeAmount) throws Exception {
        throw new Exception("In HasMoney State");
    }
    public List<Coin> returnFullRefund(VendingMachine machine){
        return machine.getCoins();
    }

    public void dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("In HasMoney State");
    }

    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("In HasMoney State");
    }
}
