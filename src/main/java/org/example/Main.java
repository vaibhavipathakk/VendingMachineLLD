package org.example;

import java.util.ArrayList;
import java.util.List;
import org.example.interfaces.State;
import org.example.modals.Inventory;
import org.example.modals.Item;
import org.example.modals.VendingMachine;
import org.example.modals.enums.Coin;
import org.example.modals.enums.ItemType;
import org.example.modals.InventoryShelf;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome to Vending Machine!");

        VendingMachine vendingMachine = new VendingMachine();
        try{

            System.out.println("----->>>---Filling up the Inventory---<<<-----");
            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);

            State vendingMachineState = vendingMachine.getVendingMachineState();
            vendingMachineState.clickOnInsertCoinButton(vendingMachine);

            vendingMachineState = vendingMachine.getVendingMachineState();
            vendingMachineState.insertCoin(vendingMachine, Coin.FIFTY);

            System.out.println("----->>>---Click on product selection button---<<<-----");
            vendingMachineState.clickOnSelectProductButton(vendingMachine);
            vendingMachineState = vendingMachine.getVendingMachineState();
            vendingMachineState.chooseProduct(vendingMachine, 102);

            System.out.println("----->>>---Items currently available in Vending Machine---<<<-----");
            displayInventory(vendingMachine);


        }catch (Exception e) {
            System.out.println("Exception Occurred : " + e.getMessage());
            displayInventory(vendingMachine);
        }

    }

    private static void displayInventory(VendingMachine vendingMachine) {
        int shelfSize = 6;
        for (int i = 0; i < shelfSize; ++i ) {
            System.out.println("Item with code : "
                                       + (i+100) + " - "
                                       + vendingMachine.getInventory().getInventoryShelves().get(i).getItem().getItemType()
                                       + ", Price : "
                                       + vendingMachine.getInventory().getInventoryShelves().get(i).getItem().getPrice()
                                       + ", Out of Stock : " + vendingMachine.getInventory().getInventoryShelves().get(i).getIsSoldOut());
        }

    }

    private static void fillUpInventory(VendingMachine vendingMachine) {

        int shelfSize = 6;
        List<InventoryShelf> inventoryShelves = new ArrayList<>();
        for (int i = 0; i < shelfSize; ++i ) {
            Item item = new Item();
            if (i < 3) {
                item.setItemType(ItemType.COKE);
                item.setPrice(20);
            } else {
                item.setItemType(ItemType.CHIPS);
                item.setPrice(10);
            }
            InventoryShelf inventoryShelf = new InventoryShelf(item, 100+i, false);
            inventoryShelves.add(inventoryShelf);
        }
        Inventory inventory = new Inventory(inventoryShelves);
        vendingMachine.setInventory(inventory);
    }
}