package test;

public class Example1 {
    private static class Persion<T>{
        T name;
        //泛型类中不能定义静态属性和静态方法以及静态内部类
        /*
         static T age;
         static T getNamee(){}
         static class Node{}这三个都不行
         */
        //泛型的静态方法调用
        public static <E> void swap(E[] e, int i, int j){
            //交换

        }
    }

    public static void main(String[] args) {
        Persion<String> p = new Persion<>();
        p.name = "sdas";
        Persion<Integer> p1 = new Persion<>();
        System.out.println(p.name);
        System.out.println(p1.name);
        //
        Integer[] e = new Integer[10];
        Persion.<Integer>swap(e,1,2);
    }
}
