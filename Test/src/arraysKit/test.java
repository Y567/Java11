package arraysKit;

import java.util.Arrays;

/**
 * java.util.Arrays是一个数组相关的工具包，里面提供了大量静态方法，用来实现数组常见操作。
 * public static String toString(数组)，将数组转换为字符串
 *输出格式为[元素1，元素2......]
 * 2.public static void sort(数组)，按照默认升序对数组排序
 * 字符串也可以排序
 */
public class test {
    public static void main(String[] args) {
        int[] arrays = {10,20,30};
        String str = Arrays.toString(arrays);
        System.out.println(str);

        int[] a2 = {3,2,1};
        Arrays.sort(a2);
        System.out.println(a2);
    }

}
