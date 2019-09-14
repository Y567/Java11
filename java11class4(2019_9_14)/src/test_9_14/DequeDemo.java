package test_9_14;

import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {
    //其实可以直接用实现类实现所有的功能LinkedList
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("茶饭");
        deque.addFirst("不死");
        deque.addLast("打豆豆");
        deque.addLast("睡觉");
        System.out.println(deque.getFirst());
        System.out.println(deque.removeFirst());//出队列
        System.out.println(deque.getFirst());
        System.out.println(deque.removeLast());//尾部出队列
        System.out.println(deque.getLast());
    }
}
