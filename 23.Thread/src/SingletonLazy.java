public class SingletonLazy {
    //懒汉模式（线程不安全）
    private SingletonLazy(){

    }
    private static SingletonLazy singletonLazy = null;
    public static SingletonLazy getInstance(){
        if(singletonLazy == null){
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }
}
