package test_9_14;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    //对队列的简单使用（一般队列)
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("打豆");
        queue.add("123");
        queue.add("asd");
        queue.add("'''''");

        System.out.println(queue.isEmpty());
        System.out.println(queue.element());
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }
}
