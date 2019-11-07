package test_String;
import java.util.*;

public class Day01{
    public static boolean isCanReverse(String s){
        if(s==null||s.length() == 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] c = s.toCharArray();
        for(char i:c){
            stack.push(i);
        }
        for(char i:c){
            char temp = stack.pop();
            String s1 = String.valueOf(i);
            String s2 = String.valueOf(temp);
            if(!s1.equals(s2)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();
        int count = 0;
        StringBuffer sb = new StringBuffer(A);
        StringBuffer sb2 = new StringBuffer(B);
        for(int i = 0;i <= A.length();i++){
            StringBuffer temp = new StringBuffer(sb);
            temp.insert(i,sb2.toString());
//            System.out.println(temp);
            if(isCanReverse(temp.toString())){
                count++;
            }
        }
        System.out.println(count);
    }
}