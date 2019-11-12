public class Singleton {
    /**
     * 饿汉模式（没有线程安全问题，因为早就示例话好了，直接读取即可）
     */

    //不让外部调用
    private Singleton(){

    }

    private static Singleton singleton = new Singleton();

    public static Singleton getInstance(){
        return singleton;
    }
}
