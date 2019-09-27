package test9_8;


import java.util.*;

public class Main {
    static class B{
        int n = 9;

    }
    public static void main(String[] args) {
        Collection<String> s = new ArrayList<>();
        System.out.println("集合的长度"+s.size());
        System.out.println("集合是否为空"+s.isEmpty());
        s.add("小博哥的");
        s.add("快乐生活");
        s.add("就是睡觉");
        System.out.println("========================");
        System.out.println("集合的长度"+s.size());
        System.out.println("集合是否为空"+s.isEmpty());
        System.out.println("集合内容如下：");
        System.out.println(s);
        for (String t:s
             ) {
            System.out.println(t);
        }
        System.out.println("======================");


        System.out.println("开始下一个表演");
        Map<String,String> map = new HashMap<>();
        System.out.println(map);
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println("================");
        System.out.println(map.get("小博哥"));
        System.out.println(map.getOrDefault("小博哥","小方方"));
        System.out.println(map.containsKey("小博哥"));
        System.out.println(map.containsValue("最帅"));
        System.out.println("===============");
        map.put("小博哥","最帅");
        map.put("小博儿","最帅");
        map.put("小博博","最帅");
        map.put("1","xiaobo");
        map.put("2","xiaobo");
        map.put("3","xiaobo");
        map.put("4","xiaobo");
        map.put("5","xiaobo");
        map.put("6","xiaobo");
        map.put("7","xiaobo");

        System.out.println("map集合的内容如下");
        System.out.println(map);
        for (Map.Entry<String,String> entry: map.entrySet()
             ) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }


        System.out.println("=================");
        List<String> list = new ArrayList<>(10);
        System.out.println(list.size());
        list.add("小博哥");
        System.out.println(list.size());
        System.out.println(list.get(0));
        list.set(0,"小洋子");
        System.out.println(list);
        System.out.println(list.contains("小洋"));
        System.out.println(list.indexOf("小洋子"));
    }
}


class A{
    public static void main(String[] args) {
        //需要写
        Main.B c = new Main.B();
    }
}