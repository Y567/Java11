public class SynchronizedDemo {
    public synchronized void method(){
        for (int i = 0; i < 100000; i++) {
            System.out.println(Thread.currentThread().getName()+" " + i);
        }
    }

    //静态方法属于类

    public static void test(){
        System.out.println("dfwsvwefgweg");
    }
    public void method1(){
        //跟引用
        synchronized (this){

        }
    }

    public synchronized void method3(){
        for (int i = 0; i < 100000; i++) {
            System.out.println("我是method3");
        }
    }


    public synchronized void method2(){
        for (int i = 0; i < 100000; i++) {
            System.out.println("我是method2");
        }
    }

    public static class MyThread extends Thread{
        private SynchronizedDemo synchronizedDemo;

        public MyThread(SynchronizedDemo synchronizedDemo){
            this.synchronizedDemo = synchronizedDemo;
        }

        @Override
        public void run() {
//            //原子性
//            synchronizedDemo.method();
            //锁对象
            synchronizedDemo.method2();
        }
    }

    public static void main(String[] args) {
        //实现原子性
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        MyThread myThread = new MyThread(synchronizedDemo);
//        myThread.start();
//        synchronizedDemo.method();
        System.out.println("==============");
        //锁对象说明
        myThread.start();
        synchronizedDemo.method3();


   }
}
