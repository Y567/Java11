public class ThreadTest2 {
    /**
     * 中断线程
     */
    private static class Worker extends Thread{
        private volatile boolean quit = false;

        //1.利用共享标记中断线程(这种方式不及时，不能立即停止)
        //2.interrupt()也不能立即停止   可以从异常中惊醒，也可以是条件不满足退出
        public void setQuit(boolean quit){
            this.quit = true;
        }

        @Override
        public void run() {
            while(!quit){
                System.out.println("正在转账");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("停止");
        }
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //停止线程
        worker.setQuit(true);
        //注意等真的结束在输出
        try {
            worker.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("已通知");
    }
}
