public class Main {
    /**
     * Class的三种获取方式
     * 1.源代码阶段获取
     * 2.class对象阶段获取
     * 3.运行时获取
     */

    public static void main(String[] args) throws Exception {

        //1.源代码阶段获取
        Class persion = Class.forName("Persion");
        System.out.println(persion);
        System.out.println("==============");
        //2.class对象阶段获取
        Class<Persion> persionClass = Persion.class;
        System.out.println(persionClass);
        System.out.println("==============");
        //3.运行时获取
        Persion persion1 = new Persion();
        Class<? extends Persion> persion1Class = persion1.getClass();
        System.out.println(persion1Class);
        //这三个对象是同一个引用




    }
}
