import java.util.Collections;
import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        while(sc.hasNext("#")) {
            String line = sc.nextLine();
            String[] arr = line.split(" ");
            Collections.addAll(set, arr);
        }
        sc.close();
        System.out.println(set.size());
    }
}