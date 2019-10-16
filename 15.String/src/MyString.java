import java.util.ArrayList;
import java.util.List;

/**字符串的不可变性：
 * 好处：
 * 1.易缓存  2.线程安全  3.hash易缓存
 * String 里返回值为String的方法均为生成新的String
 * StringBuffer线程安全
 * StringBuilder属于异步操作，线程不安全
 */
public class MyString {
    //利用一个静态属性模拟常量池
    private static List<MyString> constPool = new ArrayList<>();

    //String = "hello"类型的的加入常量池
    public static MyString literal(MyString s){
        int i = constPool.indexOf(s);
        if(i == -1){
            constPool.add(s);
            return s;
        }
        return constPool.get(i);
    }

    //String = new String("  ")类型的加入常量池
    public MyString intern(){
        //看该字符串是否已经在常量池
        int i = constPool.indexOf(this);
        if(i != -1){
            constPool.add(this);
            return this;
        }
        return constPool.get(i);
    }
    public static void main(String[] args) {

    }
}
