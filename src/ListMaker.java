import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    private static ArrayList<String> list = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final String menu = "A - Add  D - Delete  P - Print  Q - Quit";
        boolean done = false;
        String cmd = "";

        do {
            cmd = SafeInput.getRegExString(scanner, menu, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();

            switch(cmd) {
                case "A":
                    addToList();
                    break;
                case "D":
                    deleteFromList();
                    break;
                case "P":
                    displayList();
                    break;
                case "Q":
                    done = true;
                    break;
                default:
                    System.out.println("Invalid command. Please enter a valid command.");
            }
        } while (!done);
    }

    private static void addToList() {
        System.out.println("Enter the item to be added:");
        String item = scanner.nextLine();
        list.add(item);
    }

    private static void deleteFromList() {
        displayList();
        int index = SafeInput.getRangedInt(scanner, "Enter the number of the item to delete", 1, list.size());
        list.remove(index - 1);
    }

    private static void displayList() {
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        if(list.size() != 0) {
            for(int i = 0; i < list.size(); i++) {
                System.out.printf("%3d%35s\n", i+1, list.get(i));
            }
        } else {
            System.out.println("+++     List is empty     +++");
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++");
    }
}