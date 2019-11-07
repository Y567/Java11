public class ThreadTest {
    private static class ThreadDemo1 extends Thread {
        @Override
        public void run() {
            long sum = 0;
            for (int i = 1; i <= 1000000; i++) {
                sum+=i;
            }
            System.out.println("第一题:"+sum);
        }
    }
    private static class ThreadDemo2 implements Runnable {
        @Override
        public void run() {
            long sum = 0;
            for (int i = 1; i <= 1000001; i+=2) {
                sum+=i;
            }
            System.out.println("第二题:"+sum);
        }
    }

    private static class ThreadDemo3 implements Runnable{

        @Override
        public void run() {
            long sum = 0;
            for (int i = 1; i <= 100000; i++) {
                sum+=(i*i);
            }
            System.out.println("第三题:"+sum);
        }
    }

    public static void main(String[] args) {
        ThreadDemo2 runnable = new ThreadDemo2();
        Thread thread = new Thread(runnable);
        new ThreadDemo1().start();
        thread.start();
        //第三题的线程
        ThreadDemo3 threadDemo3 = new ThreadDemo3();
        new Thread(threadDemo3).start();
    }

}
