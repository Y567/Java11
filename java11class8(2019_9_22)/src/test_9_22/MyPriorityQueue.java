package test_9_22;

public class MyPriorityQueue {
    private int[] array;
    private int size;

    public MyPriorityQueue() {
        array = new int[16];
        size = 0;
    }

    //入队列
    public void offer(int element){
        array[size++] = element;
        Heap.shiftUpSmall(array,size-1);
    }

    //出队列
    public int poll(){
        int element = array[0];
        array[0] = array[--size];
        Heap.shiftDownSmall(array,size,0);
        return element;
    }

    //
    public static void main(String[] args) {
        MyPriorityQueue myPriorityQueue = new MyPriorityQueue();
        myPriorityQueue.offer(7);
        myPriorityQueue.offer(9);
        myPriorityQueue.offer(5);
        System.out.println(myPriorityQueue.poll());
        myPriorityQueue.offer(3);
        myPriorityQueue.offer(7);

//        //java中的优先级队列(PriorityQueue默认是小堆，compareTo返回小的排前面)
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//        priorityQueue.add(7);
//        priorityQueue.add(9);
//        priorityQueue.add(5);
//        System.out.println(priorityQueue.poll());
//        System.out.println(priorityQueue.poll());
    }

}
