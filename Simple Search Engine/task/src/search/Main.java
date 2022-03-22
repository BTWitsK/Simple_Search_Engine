package search;
import java.util.*;

public class Main {
    enum Menu {
        SEARCH(1),
        PRINT(2),
        EXIT(0);
        final int choice;
        Menu(int input) {
            this.choice = input;
        }
    }
    static ArrayList<String> peopleList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static Menu menu;

    public static void setMenu() {
        System.out.print("""
                === Menu ===
                1. Find a person
                2. Print all people
                0. Exit
                """);

        int choice = Integer.parseInt(scanner.nextLine());
        for (Menu option : Menu.values()) {
            if (option.choice == choice) {
                menu = option;
            }
        }
    }

    public static void loadList(int inputLines) {
        System.out.println();
        System.out.println("Enter all people:");
        for (int i = 0; i < inputLines; i++) {
            peopleList.add(scanner.nextLine());
        }
    }

    public static void executeSearch() {
        ArrayList<String> tempList = new ArrayList<>();
        System.out.println("Enter a name or email to search all suitable people.");
        String searchField = scanner.nextLine().toLowerCase();

        peopleList.forEach(line -> { if (line.toLowerCase().contains(searchField)) tempList.add(line); });

        if (!tempList.isEmpty()) {
            tempList.forEach(System.out::println);
        } else {
            System.out.println("No matching people found.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of people:");
        loadList(Integer.parseInt(scanner.nextLine()));
        System.out.println();

        do {
            setMenu();
            try {
                switch (menu) {
                    case SEARCH -> executeSearch();
                    case PRINT -> {
                        System.out.println("=== List of people ===");
                        peopleList.forEach(System.out::println);
                    }
                    case EXIT -> System.out.println("\nBye!");
                }
            } catch(NullPointerException e) {
                System.out.println("Incorrect option! Try again");
            }
        } while (menu != Menu.EXIT);
    }
}