public class SynVisible {

    private static int n = 0;

    public static class MyThread extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                synchronized (SynVisible.class){
                    n--;
                }
            }
        }
    }
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        for (int i = 0; i < 100000; i++) {
            synchronized (SynVisible.class){
                n++;
            }
        }


        try {
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(n);
        }

    }
}
