package test9_8;

import java.util.Map;
import java.util.TreeMap;

/**
 * Map的常用方法使用
 */
public class NewTest {
    //优化
    public static Map<Integer,Integer> calcCount2(int[] nums){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int n:nums){
            int i = map.getOrDefault(n,0);
            map.put(n,i+1);
        }
        return map;
    }
    public static Map<Integer,Integer> calcCount(int[] nums){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                int t = map.get(nums[i]);
                map.put(nums[i],t++);
            }else{
                map.put(nums[i],1);
            }
        }
        return map;
    }
    public static void main(String[] args) {
        Map<String,String> map = new TreeMap<>();
        String oldValue = map.put("小博哥","18342563917");
        System.out.println(oldValue);
        System.out.println(map.containsKey("小博哥"));
        System.out.println(map.containsValue("房子"));
        map.put("雨涵","231312");
        map.put("漆","22343412");
        map.put("asdq漆","223412");
        map.put("凌dwqfqw凌漆","3412");
        map.put("凌漆","43412");
        map.put("凌","343412");
        String o = map.getOrDefault("小博哥","查无此人");
        System.out.println(o);
        System.out.println(map.get("雨涵"));
    }
}
