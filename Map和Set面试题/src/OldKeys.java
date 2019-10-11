import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 坏键盘
 */

public class OldKeys {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String right = input.nextLine();
        String wrong = input.nextLine();

        Set<Character> set = new TreeSet<>();
        for(char c:wrong.toCharArray()){
            set.add(c);
        }

        Set<Character> written = new TreeSet<>();
        for(char c:right.toCharArray()){
            if(!set.contains(c)){
                c = Character.toUpperCase(c);
//                if(c >= 'a' && c <= 'z'){
//                    c += ('A'-'a');
//                }
                if(!written.contains(c)){
                    System.out.print(c);
                    written.add(c);
                }
            }
        }
    }
}
