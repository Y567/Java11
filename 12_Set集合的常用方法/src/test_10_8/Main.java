package test_10_8;

import java.util.TreeSet;

/**
 * Set（TreeSet常用方法）
 */
public class Main {
    public static void main(String[] args) {
        //增加
        TreeSet<String> strings = new TreeSet<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        //下面的是白加，set集合内元素不重复
        strings.add("4");
        System.out.println(strings);
        //删除
        strings.remove("2");
        System.out.println(strings);
        //判断包含
        System.out.println(strings.contains("4"));
        //返回大小
        System.out.println(strings.size());
    }
}
