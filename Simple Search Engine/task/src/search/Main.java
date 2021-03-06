package search;
import java.util.*;
import java.io.*;

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
    static HashMap<String, ArrayList<Integer>> peopleMap = new HashMap<>();
    static Scanner scanner;
    static Menu menu;
    static FileReader dataFile;

    public static void setMenu() {
        scanner = new Scanner(System.in);
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

    public static void loadList(String file) {
        try {
            int index = 0;
            dataFile = new FileReader(file);
            scanner = new Scanner(dataFile);
            while (scanner.hasNext()) {
                peopleList.add(scanner.nextLine());
                for (String name : peopleList.get(index).split(" ")) {
                    if (peopleMap.containsKey(name.toLowerCase())) {
                        peopleMap.get(name.toLowerCase()).add(index);
                    } else {
                        ArrayList<Integer> nameIndex = new ArrayList<>();
                        nameIndex.add(index);
                        peopleMap.put(name.toLowerCase(), nameIndex);
                    }
                }
                index++;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void executeSearch() {
        System.out.println("Enter a name or email to search all suitable people.");
        String searchField = scanner.nextLine().toLowerCase();
        if (peopleMap.containsKey(searchField)) {
            peopleMap.get(searchField).forEach(index -> System.out.println(peopleList.get(index)));
        } else {
            System.out.println("No matching people found.");
        }
    }

    public static void main(String[] args) {
        String filePath = args[1];
        loadList(filePath);
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