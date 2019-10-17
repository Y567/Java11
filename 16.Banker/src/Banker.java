import java.util.Scanner;


/**
 * 银行家算法的简单示例
 */
public class Banker {
    //进程数
    private static final int N = 4;
    //资源种类数
    private static final int M = 3;
    //表示总资源的向量
    private static final int[] resource = {9,3,6};
    //每个进程对资源的最大需求矩阵
    private static final int[][] claim = {{3,2,2},{6,1,3},{3,1,4},{4,2,2}};


    //每个进程已拥有的资源矩阵
    private static int[][] allocate = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};
    //每个进程仍需要的资源数目矩阵
    private static int[][] need = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};
    //当前状态下，剩余资源数目
    private static int[] available = {9,3,6};
    //表示第几个进程的请求资源数目（一共四个进程）
    private static int[][] request = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};

    //请求数据的方法
    private static void inputRequest(int i){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入该进程的请求资源数据：");
        for(int j = 0;j < request[i-1].length;j++){
            request[i-1][j] = input.nextInt();
        }
    }

    //向量比较,返回true，表示a可接受b,反之不能接受
    private static boolean vectorOfCompare(int[] a,int[] b){
        for (int i = 0; i < a.length; i++) {
            if(a[i] < b[i]){
                return false;
            }
        }
        return true;
    }
    //约束比较
    private static boolean matrixOfCompare(int[][] allocate,int[][] claim,int i,int j){
        int sum1 = 0; //将来存储的是系统为第i个进程对第j种资源的需求已分配的数目
        int sum2 = claim[i-1][j-1]; //第i个进程对第j种资源的最大需求总量
        for(int x = 0;x < allocate[j-1].length;x++){
            sum1 += allocate[x][j-1];
        }
        return sum1 <= sum2;
    }

    //判断resource矩阵是否为小于0了
    private static boolean refuseOrReceive(int i){
        //判断剩余的资源数是否可以接受第i个进程对所有资源的需求，以及已分配的资源是否大于了其对应的资源总数
        return vectorOfCompare(available, request[i - 1]) && matrixOfCompare(allocate, claim, i, 1)
                && matrixOfCompare(allocate, claim, i, 2) && matrixOfCompare(allocate, claim, i, 3);
    }

    //资源矩阵重新洗牌(因为是请求引起的变化),i表示第几个进程的请求
    private static void refresh(int[] request,int i){
        //allocate矩阵的变化
        for (int j = 0; j < allocate[i-1].length; j++) {
            allocate[i-1][j] += request[j];
        }
        //need的变化
        for (int j = 0; j < need[i-1].length; j++) {
            need[i-1][j] = claim[i-1][j] - allocate[i-1][j];
        }
        //available的变化
        for (int j = 0; j < available.length; j++) {
            //这是一样的这样计算也可以
            available[j] -= request[j];
        }
    }

    //输出矩阵
    private static void print(){
        //Allocate矩阵
        System.out.println("Allocate矩阵：");
        for (int[] i : allocate) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        //Need矩阵
        System.out.println("Need矩阵：");
        for(int[] i : need){
            for(int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }

        //Available矩阵
        System.out.println("Available矩阵：");
        for(int i : available){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    //回滚矩阵数据
    private static void rollBack(int[] request,int i){
        //allocate矩阵的变化
        for (int j = 0; j < allocate[i-1].length; j++) {
            allocate[i-1][j] -= request[j];
        }
        //need的变化
        for (int j = 0; j < need[i-1].length; j++) {
            need[i-1][j] = claim[i-1][j] - allocate[i-1][j];
        }
        //available的变化
        for (int j = 0; j < available.length; j++) {
            available[j] += request[j];
        }
    }
    //i表示第i个进程发出的请求，返回为1表示接受该请求，返回0表示拒绝
    public static int banker(int i){
        //先输入请求数据
        inputRequest(i);
        //洗牌
        refresh(request[i-1],i);
        //判断是否能接受
        if(refuseOrReceive(i)){
            print();
            return 1;
        }else{
            rollBack(request[i-1],i);
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            System.out.println("请输入是哪一个进程的请求：");
            int i = in.nextInt();
            if(banker(i) == 1){
                System.out.println("第"+i+"个进程的"+"请求系统可以接受！");
            }else{
                System.out.println("第"+i+"个进程的"+"请求系统不能接受！");
            }
            System.out.println("请选择是否继续发出请求？(1:继续 2:退出)");
            int select = in.nextInt();
            if(1 == select){
                //
            }else{
                flag = false;
            }
        }
    }
}
