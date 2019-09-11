package test_arraylist;


import java.util.ArrayList;

/**
 * ArrayList常用方法
 * 1.public boolean add(E e)向集合中添加元素
 * 2.public E get(int index):读取指定下标的元素
 * 3.pubic E remove(int index):删除指定下标的元素，并返回
 * 4.public int size():获取集合的长度
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list);

        //添加元素,ArrayList的添加一定会成功，所以可接受可不接受
        //但是其他的集合不一定
        list.add("曹操");
        list.add("汪");
        list.add("五六七");

        //获取元素，和数组一样，下标0开始
        System.out.println(list.get(1));


        //删除元素
        String whoRemoved = list.remove(3);
        System.out.println("被删除的是"+whoRemoved);

        //获取集合的长度
        int size = list.size();
        System.out.println("集合的长度"+size);

    }
}
