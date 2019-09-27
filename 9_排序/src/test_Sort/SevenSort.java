package test_Sort;

import java.util.Arrays;
import java.util.Random;

public class SevenSort {
    //插入排序（在有序区间可以利用折半查找优化）
    public static void insertSort(int[] array){
        //从1开始是因为我们默认第一个元素是有序的
        for(int i = 1;i < array.length;i++){
            //这里用变量记住这个要进行插入的数据
            int key = array[i];
            //j表示有序区间的最后一个下标（从后往前比较）
            int j = i - 1;
            //如果有序区间的元素大那么有序区间向后移动，让key进行插入。（这就是为什么要用key记住插入的数据
            // 防止被移动的有序元素覆盖掉）
            for(; j >= 0 && array[j] > key;j--){
                array[j+1] = array[j];
            }
            //j+1才是真正要插入的地方
            array[j+1] = key;
        }
    }

    //测试排序时间
    public static long testTime(){
        int[] test = new int[10000];
        Random r = new Random();
        for (int i = 0; i < 10000; i++) {
            test[i] = r.nextInt(10000);
        }
        long start = System.currentTimeMillis();
        shellSort(test);
        long end = System.currentTimeMillis();
        return end-start;
    }

    //分组交换的插入排序(gap表示间隙)
    public static void insertSortWithGap(int[] array,int gap){
        //这里交换的思想与直接插入排序一样，只是跳着比较，不是一个个比较，排完后，数组近似有序
        for(int i = 1;i < array.length;i++){
            int key = array[i];
            int j = i - gap;
            //同样的这里写大于是为了保证稳定性
            for(; j >= 0 && array[j] > key;j-=gap){
                array[j+gap] = array[j];
            }
            array[j+gap] = key;
        }
    }

    //希尔排序
    public static void shellSort(int[] array){
        int gap = array.length;
        while(true){
            gap= (gap / 3) + 1;//这里也可以写gap = gap / 2;  这是很多人总结出来分的间隔最适合的(也就是跳跃的步骤)
            insertSortWithGap(array,gap);
            //如果gap==1说明排序方法以及按照一个个的比较排序过了，则说明数组已经处于有序了
            //所以直接跳出即可
            if(1 == gap){
                break;
            }
        }
    }

    //直接选择排序
    public static void selectSort(int[] array){
        //这里写成i < array.length - 1;因为当你排完前面的序，最后一个就默认有序了，所以遍历到倒数第二个就结束了
        for (int i = 0; i < array.length-1; i++) {
            int minIndex = i;
            for(int j = i+1;j < array.length - 1;j++){
                //小于号保证了稳定性
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            swap(array,i,minIndex);
        }
    }

    private static void swap(int[] array, int i, int minIndex) {
        int t = array[minIndex];
        array[minIndex] = array[i];
        array[i] = t;
    }


    //选择排序的双向排序没有写(完成)
    public static void selectSort2(int[] array){
        int left = 0;
        int right = array.length - 1;
        while(left <= right){
            int minIndex = left;
            int maxIndex = left;
            for(int i = left + 1;i <= right;i++){
                if(array[i] < array[minIndex]){
                    minIndex = i;
                }
                if(array[i] > array[maxIndex]){
                    maxIndex = i;
                }
            }
            swap(array,left,minIndex);
            if(maxIndex == left){
                maxIndex = minIndex;
            }
            swap(array,right,maxIndex);
            left++;
            right--;
        }
    }

    //向下调整大堆
    public static void shiftDownBig(int[] array,int i,int size){
        while(2 * i + 1 < size){
            //这里默认为左孩子最大
            int max = 2 * i + 1;
            if(max + 1 < size && array[max] < array[max + 1]){
                max = max + 1;
            }
            if(array[i] >= array[max]){
                return;
            }
            swap(array,i,max);
            i = max;
        }
    }
    //堆排序
    public static void heapSort(int[] array){
        //建大堆
        creatBigHeap(array);
        //将最大的元素放在数组后面（这里i控制的是循环次数不要多想，比如n个元素只需要9次调整就可有序；）
        //和选择排序有点类似
        for(int i = 0; i < array.length - 1;i++){
            //因为大堆的首元素就是数组中的最大值，所以直接交换(永远和无序区间最后一个交换)
            swap(array,0,array.length-i-1);
            //交换完毕后可能会破坏堆的完整性所以需要调整
            shiftDownBig(array,0,array.length-i-1);
        }
    }

    private static void creatBigHeap(int[] array) {
        for(int i = (array.length-2) / 2;i >= 0;i--){
            shiftDownBig(array,i,array.length);
        }
    }

    //快速排序(填坑+挖坑)
    public static void quickSort(int[] array,int low,int high){
        int left = low;
        int right = high;
        //key为基准值
        int key = array[low];
        while(left < right){
            while(left < right && array[right] > key){
                right--;
            }
            if(left < right){
                array[left++] = array[right];
            }
            while(left < right && array[left] < key){
                left++;
            }
            if(left < right){
                array[right--] = array[left];
            }
            array[left] = key;
            if(low < left - 1){
                quickSort(array,low,left-1);
            }
            if(high > left + 1){
                quickSort(array,left+1,high);
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {9,5,2,7,12,2,4,6,9,23};
        //拷贝数组(拷贝一份完整的数组)
        int[] b = a.clone();
//        //选择排序
//        selectSort(b);
//        //选择排序优化
//        selectSort2(b);
//        //插入排序
//        insertSort(b);
//        //堆排序
//        heapSort(b);
        //快排
        quickSort(b,0,b.length-1);
        System.out.println(Arrays.toString(b));
        System.out.println("插入排序时间"+testTime()+"毫秒");
    }
}
