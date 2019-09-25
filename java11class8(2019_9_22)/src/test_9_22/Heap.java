package test_9_22;

import java.util.Arrays;

public class Heap {

    //交换
    public static void swap(int[] array,int index1,int index2){
        int t = array[index1];
        array[index1] = array[index2];
        array[index2] = t;
    }
    //向下调整小堆
    public static void shiftDownSmall(int[] array,int i,int size){
        while(2 * i + 1 < size){
            //i写成1
            int min = 2 * i +1;
            if(min + 1 < size && array[min] > array[min+1]){
                min = min+1;
            }
            if(array[i] <= array[min]){
                break;
            }
            swap(array, i, min);
            i = min;
        }
    }


    //向下调整大堆
    public static void shiftDownBig(int[] array,int i,int size){
        while(2 * i +1 < size){
            int max = 2 * i +1;
            //比两个都大，那就比两个孩子中最大的大
            if(max + 1 < size && array[max] < array[max+1]){
                max = max+1;
            }
            if(array[i] >= array[max]){
                break;
            }
            swap(array,i,max);
            i = max;
        }
    }

    //建小堆
    public static void createSmallHeap(int[] array,int size){
        for(int i = (size-2)/2;i >= 0;i--){
            shiftDownSmall(array,i,size);
        }
    }

    //向上调整
    public static void shiftUpSmall(int[] array,int i){
        while(i != 0){
            int parent = (i - 1) / 2;
            if(array[parent] > array[i]){
                break;
            }
            swap(array,i,parent);
            i = parent;
        }
    }

    //建大堆
    public static void creatBigHeap(int[] array,int size){
        for(int i = (size-2)/2;i >= 0;i--){
            shiftDownBig(array,i,size);
        }
    }
    public static void main(String[] args) {
        int[] array = {39,15,3,18,40,5,6,51,52,70};
        int[] test = {8,7,4,2,2,7,0,8,4};
//        creatBigHeap(test,test.length);
//        System.out.println(Arrays.toString(test));
        //建小堆成功
        createSmallHeap(array,array.length);
        System.out.println(Arrays.toString(array));
    }
}
