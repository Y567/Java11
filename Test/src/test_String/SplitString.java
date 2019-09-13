package test_String;

/**
 * 分割字符串
 * public String[] split(String regex):将字符串按字符串分割为若干个部分
 *注意事项：
 * split方法的参数其实是一个正则表达式
 * 现在需要知道：如果要按"."分割
 * 需要写成"\\."
 */
public class SplitString {
    public static void main(String[] args) {
        String s = "AAAA,BBBB,CCCC";
        String[] s1 = s.split("A");
        for(int i = 0;i < s1.length;i++){
            System.out.println(s1[i]);
        }
        System.out.println(s1.length);
    }
}
