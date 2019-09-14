package test_9_14;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyQueue {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        int[] a = new int[10];
        System.out.println("长度为"+a.length);
        arrayList.add("3");
        arrayList.add("9");
        arrayList.add("5");
        arrayList.remove("3");
        System.out.println(arrayList);
    }
}
