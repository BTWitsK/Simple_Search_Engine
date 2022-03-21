package search;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = List.of(scanner.nextLine().split(" "));
        String searchFor = scanner.nextLine();
        System.out.println(words.contains(searchFor) ? String.valueOf(words.indexOf(searchFor) + 1) : "Not found");
    }
}