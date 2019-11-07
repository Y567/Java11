public class Buddy {
    /**
     * 实现逻辑处理
     */
    public static int U = 20;  //最大分区
    public static int L = 10;   //最小分区
    public static double M = Math.pow(2,20)/1024; //内存大小
    public static Node root = new Node(U); //目前未分配所以内存是最大的
    //返回一个适合的K值
    public static int intFitSize(int size){
        int i = U;
        while(i > L && size > Math.pow(2,L)/1024 && size < Math.pow(2,U)/1024){
            if(size < Math.pow(2,i)/1024 && size > Math.pow(2,i-1)/1024){
                return i;
            }else{
                i--;
            }
        }
        return i;
    }


/*    //寻找空闲分区
    public static int intSearchFitChunk(int K){
        Node cur = root;
        while(cur != null){
            if(Math.pow(2,K) < cur.size){

            }
        }
    }*/
    //分配内存
/*    public static int intAllocate(int size){
        if(size > M){
            //大于最大内存，拒绝
            return -1;
        }
        int K = intFitSize(size);

    }*/



    public static void main(String[] args) {
        int i = new Buddy().intFitSize(256);
        System.out.println(i);
        System.out.println(M);
    }
}
