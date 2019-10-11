import java.util.Set;
import java.util.TreeSet;

/**
 * 宝石和石头(Set集合实现)
 */
public class NumsJewelsInStones {
    public static int numsJewIsInStones(String J,String S){
        Set<Character> set = new TreeSet<>();
        char[] jewels = J.toCharArray();
        int count = 0;
        for(char c : jewels){
            set.add(c);
        }
        for(int i = 0;i < S.length();i++){
            char c = S.charAt(i);
            //如果石头集合里发现了宝石，计数器加一
            if(set.contains(c)){
                count++;
            }
        }
        return count;
    }
}
