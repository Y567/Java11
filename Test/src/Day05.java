import java.util.Arrays;
import java.util.Scanner;

public class Day05 {
    public static int search(int key,int[] a){
        int count = 0;
        for(int i = 0;i < a.length;i++){
            if(a[i] == key){
                count++;
            }
        }
        return count;
    }
    public static int totalSelect(int a[]){
        Arrays.sort(a);
        int count = 0;
        int result = 0;
        for(int i = 0;i < a.length;i++){
            if(a[i]+result==40) {
                count++;
            }else if(a[i]+result<40){
                result+=a[i];
                int search = search(40 - (a[i] + result), a);
                if(search!=0){
                    count+=search;
                }
            }else{
                continue;
            }
        }
        return count;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        int[] a = new int[sum];
        while(sum > 0){
            a[sum-1] = in.nextInt();
            sum--;
        }
        System.out.println(totalSelect(a));
    }
}
