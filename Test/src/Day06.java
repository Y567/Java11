import java.util.HashMap;
import java.util.Scanner;

public class Day06 {
    public static int BigCountBinary(String s){
        HashMap<Integer,Integer> map = new HashMap<>();
        String[] s1 = s.split(" ");
        for (String s2 : s1) {
            int i = Integer.parseInt(s2);
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for (Integer integer : map.keySet()) {
            if(map.get(integer)>=s1.length/2){
                return integer;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
//        System.out.println(BigCountBinary(s));
//
//        int x = 5>>2;
//        int y = x>>>2;
//        System.out.println(y);



    }
}
