package test_9_14;

import java.util.LinkedList;

public class LinkedListDemo {
    //可以将linkedList当一般队列，也可以当双端队列
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        //单向队列
        linkedList.add("会长");
        linkedList.add("阿狗");
        linkedList.add("百川");


        //这里调用的是单向队列的方法
        System.out.println(linkedList.peek());
        System.out.println(linkedList.removeLast());
//        //这里有可以在头部出队列，调用的是双端队列的方法
//        System.out.println(linkedList.removeFirst());
//        System.out.println(linkedList.removeFirst());
//        System.out.println(linkedList.removeFirst());

    }
}
