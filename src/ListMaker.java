import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListMaker {
    private static List<String> itemList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean keepRunning = true;
        while (keepRunning) {
            displayMenu();
            String choice = SafeInput.getRegExString(scanner, "Enter your choice", "[AaDdPpQq]");
            switch (choice.toLowerCase()) {
                case "a":
                    addItem();
                    break;
                case "d":
                    deleteItem();
                    break;
                case "p":
                    printList();
                    break;
                case "q":
                    keepRunning = !SafeInput.getYNConfirm(scanner, "Are you sure you want to quit?");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter again.");
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("List: " + itemList);
        System.out.println("Choose an option:");
        System.out.println("A – Add an item to the list");
        System.out.println("D – Delete an item from the list");
        System.out.println("P – Print (i.e. display) the list");
        System.out.println("Q – Quit the program");
    }

    private static void addItem() {
        String item = SafeInput.getNonZeroLenString(scanner, "Enter item to add");
        itemList.add(item);
    }

    private static void deleteItem() {
        if(itemList.isEmpty()) {
            System.out.println("The list is empty. No items to delete.");
        } else {
            printNumberedList();
            int index = SafeInput.getRangedInt(scanner, "Enter item number to delete", 1, itemList.size()) - 1;
            itemList.remove(index);
        }
    }

    private static void printList() {
        System.out.println("Current List: " + itemList);
    }

    private static void printNumberedList() {
        for(int i = 0; i < itemList.size(); i++) {
            System.out.println((i + 1) + ". " + itemList.get(i));
        }
    }
}
