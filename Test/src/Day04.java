import java.util.*;

public class Day04 {

    //第一题
    public static int totalD(int n){
        int count = 0;
        boolean flag = false;
        for(int i = 0;i <= n / 8;i++){    //代表每8个
            for(int j = 0;j <= n / 6;j++){ //代表每6个
                if((i*8+j*6)==n){
                    flag = true;
                    if(count==0){
                        count=i+j;
                    }else if(count > i+j){
                        count=i+j;
                    }else{
                        continue;
                    }
                }
            }
        }
        return flag==true?count:-1;
    }
    //第二题
    //删除方法
    public static String deleteBySecondString(String a,String b){

        char[] charB = b.toCharArray();
        for (char c : charB) {
            //可能产生大量字符串常量
            a = a.replace(c,',');
        }
        String[] split = a.split(",");
        StringBuffer sb = new StringBuffer();
        for (String s : split) {
            sb.append(s);
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        for (int i = 1; i < 101; i++) {

            System.out.println(totalD(i));

        }



 /*       Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        System.out.println(deleteBySecondString(a,b));*/
    }
}
