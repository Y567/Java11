import java.util.*;

public class Day02 {
        public static int[] a;
        public static int i = 0;
        static {
            a = new int[10];
        }
        public static void cal(int n){
            int blank = n;
            int drink;
            int count = 0;
            while(blank > 2){
                drink = blank / 3;
                blank = blank - drink * 3 + drink;
                count += drink;
            }
            if(blank == 2){
                count++;
            }
            a[i++] = count;
        }


        //数组的逆序对
        public int count(int[] A, int n) {
            // write code here
            int count = 0;
            if(n == 0){
                return 0;
            }
            for(int i = 0;i < n-1;i++){
                for(int j = i+1;j < n;j++){
                    if(A[i] > A[i+1]){
                        count++;
                    }
                }
            }
            return count;
        }
        public static void main(String[] args){
//            Scanner sc = new Scanner(System.in);
//            int n = sc.nextInt();
//            cal(n);
//            System.out.println(a[0]);
        }
}
