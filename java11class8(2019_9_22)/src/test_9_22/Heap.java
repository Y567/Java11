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
    public static void shiftDownSmall(int[] array,int size,int index){
        int left = 2*index+1;
        while(left < size){
            int right = left + 1;
            int min = left;
            if(left < size){
                if(right < size){
                    if(array[left] > array[right]){
                        min = right;
                    }
                }
            }
            if(array[index] > array[min]){
                swap(array,index,min);
                index = min;
                left = 2 * index + 1;
            }
            if(left > size){
                break;
            }
        }
    }


    //向下调整大堆
    public static void shiftDownBig(int[] array,int size,int index){
        int left = 2*index+1;
        while(left < size){
            int right = left + 1;
            int max = left;
            if(left < size){
                if(right < size){
                    if(array[left] < array[right]){
                        max = right;
                    }
                }
            }
            if(array[index] < array[max]){
                swap(array,index,max);
                index = max;
                left = 2 * index + 1;
            }
            if(left > size){
                break;
            }
        }
    }

    //建小堆
    public static void createSmallHeap(int[] array,int size){
        for(int i = (size-2)/2;i >= 0;i--){
            shiftDownSmall(array,size,i);
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
    public static void creatHeapBig(int[] array,int size){
        for(int i = (size-2)/2;i >= 0;i--){
            shiftDownSmall(array,size,i);
        }
    }
    public static void main(String[] args) {
        int[] array = {39,15,3,18,40,5,6,51,52,70};
        int[] test = {8,7,4,2,2,7,0,8,4};
//        createSmallHeap(test,test.length);
          shiftDownSmall(array,array.length,0);
          System.out.println(Arrays.toString(array));
//        System.out.println(Arrays.toString(test));
    }
}
