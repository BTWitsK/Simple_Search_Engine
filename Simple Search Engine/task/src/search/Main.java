package search;
import java.util.*;

public class Main {
    static ArrayList<String> peopleList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void loadList(int inputLines) {
        System.out.println("Enter all people:");
        for (int i = 0; i < inputLines; i++) {
            peopleList.add(scanner.nextLine());
        }
    }

    public static void executeSearch(int numberOfQueries) {
        ArrayList<String> tempList = new ArrayList<>();
        for (int i = 0; i < numberOfQueries; i++) {
            System.out.println("Enter data to search people:");
            String searchField = scanner.nextLine().toLowerCase();

            peopleList.forEach(line -> { if (line.toLowerCase().contains(searchField)) tempList.add(line); });

            if (!tempList.isEmpty()) {
                System.out.println("Found people:");
                tempList.forEach(System.out::println);
                tempList.clear();
            } else {
                System.out.println("No matching people found.");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of people:");
        loadList(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter the number of search queries:");
        executeSearch(Integer.parseInt(scanner.nextLine()));
    }
}