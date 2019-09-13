package test_String;

/**字符串相关转换方法
 * public char[] toCharArray():
 * public byte[] getBytes():获取当前字符串的底层字节数组
 * public String replace(charSequence oldString,charSequence newString)
 * 将所有出现的老字符串替换为新的字符串，反hi替换后的结果字符串
 *备注：charSequence的意思是可以接受字符串，可以当作字符串用
 */
public class Test {
    public static void main(String[] args) {
        //转换为字符数组
        char[] result = "Hello".toCharArray();
        System.out.println(result[1]);

        //转换为字节数组
        byte[] by = "Hello".getBytes();
        for (int i = 0; i < by.length; i++) {
            System.out.println(by[i]);
        }

        //替换字符串
        String s = "I LOVE YOU";
        String s2 = s.replace("LOVE","闸种");
        System.out.println(s2);
    }

}
