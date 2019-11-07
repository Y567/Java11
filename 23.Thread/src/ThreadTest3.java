public class ThreadTest3 {
    public static class Zhangsan implements Runnable{

        @Override
        public void run() {
            while(true){
                System.out.println("1");
            }
        }
    }

    public static class Lisi implements Runnable{

        @Override
        public void run() {
            while(true){
                System.out.println("2");
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Zhangsan());
        Thread thread1 = new Thread(new Lisi());
        thread.start();
        thread1.start();
    }
}
