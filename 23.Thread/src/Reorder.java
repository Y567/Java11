public class Reorder{
    private static int a1 = 0;
    private static int a2 = 0;
    private static int a3 = 0;
    private static int a4 = 0;
    private static int a5 = 0;
    private static int a6 = 0;
    private static int a7 = 0;
    private static int a8 = 0;
    private static int a9 = 0;
    private static int a10 = 0;
    private static int a11 = 0;
    private static int a12 = 0;
    private static int a13 = 0;

    public static class Set extends Thread{
        @Override
        public void run() {
            a1 = 1;
            a2 = 2;
            a3 = 3;
            a4 = 4;
            a5 = 5;
            a6 = 6;
            a7 = 7;
            a8 = 8;
            a9 = 9;
            a10 = 10;
            a11 = 11;
            a12 = 12;
            a13 = 13;
        }
    }

    public static class Print extends Thread{
        @Override
        public void run() {
            System.out.println(a1);
            System.out.println(a2);
            System.out.println(a3);
            System.out.println(a4);
            System.out.println(a5);
            System.out.println(a6);
            System.out.println(a7);
            System.out.println(a8);
            System.out.println(a9);
            System.out.println(a10);
            System.out.println(a11);
            System.out.println(a12);
            System.out.println(a13);
        }
    }

    public static void main(String[] args) {
        new Set().start();
        new Print().start();
    }

}
