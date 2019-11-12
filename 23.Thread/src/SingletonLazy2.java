public class SingletonLazy2 {
    //懒汉模式（线程安全）
    private SingletonLazy2(){

    }

    private static SingletonLazy2 singletonLazy2 = null;
    //在加锁和释放锁的时候保证可见性问题（更新主内存的数据到工作内存）
    public static synchronized SingletonLazy2 getInstance(){

        if(singletonLazy2 == null){
            singletonLazy2 = new SingletonLazy2();
        }
        return singletonLazy2;
    }
}
