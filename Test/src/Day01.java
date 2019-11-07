public class Day01 {
    //快排
    public static void quickSort(int[] a,int begin,int end){
        int i = begin;
        int j = end;
        int key = a[i];
        while(i < j){
            while(i < j && a[j] <= key){
                j--;
            }
            if(i < j){
                a[i++] = a[j];
            }
            while(i < j && a[i] >= key){
                i++;
            }
            if(i < j){
                a[j--] = a[i];
            }
        }
        a[i] = key;
        if(begin < i-1){
            quickSort(a,begin,i-1);
        }
        if(end > i+1){
            quickSort(a,i+1,end);
        }
    }
    public int findKth(int[] a, int n, int K) {
        // write code here
        quickSort(a,0,n-1);
        return a[K-1];
    }

    public static void main(String[] args) {
        int[] a = {9,1,6,4,2,1};
        quickSort(a,0, a.length-1);
        System.out.println(new Day01().findKth(a,a.length,2));

        //字符比较相等
        char c = 'c';
/*        char[] c2 = {'a','b','c'};*/
        String s = "abc";
        System.out.println(c==s.charAt(2));
/*        System.out.println(c==c2[2]);*/
    }
}
