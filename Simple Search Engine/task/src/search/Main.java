package search;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        String searchFor = scanner.nextLine();
        boolean found = false;
        int index = 0;

        for (int i = 0; i < words.length; i++) {
            if (searchFor.equals(words[i])) {
                index = i;
                found = true;
                break;
            }
        }

        String result = found ? String.valueOf(index + 1) : "Not found";
        System.out.println(result);

    }
}
