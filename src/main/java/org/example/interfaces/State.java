package org.example.interfaces;

import java.util.List;
import org.example.modals.Item;
import org.example.modals.VendingMachine;
import org.example.modals.enums.Coin;

public interface State {
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception;
    public void clickOnSelectProductButton(VendingMachine machine) throws Exception;
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception;
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception;
    public int getChange(int returnChangeAmount) throws Exception;
    public List<Coin> returnFullRefund(VendingMachine machine) throws Exception;
    public void dispenseProduct(VendingMachine machine, int codeNumber) throws Exception;
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception;
}
