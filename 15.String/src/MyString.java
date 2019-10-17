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

    private final char[] value;

    public MyString(char[] value) {
        this.value =  value.clone();
    }

    //利用一个静态属性模拟常量池
    private static List<MyString> constPool = new ArrayList<>();

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    //忽略大小写比较
    public boolean equalsIgnoreCase(MyString o){
        if(o == null){
            return false;
        }
        if(o.value.length != value.length){
            return false;
        }
        for (int i = 0; i < value.length; i++) {
            char a = Character.toUpperCase(value[i]);
            char b = Character.toUpperCase(o.value[i]);
            if(a != b){
                return false;
            }
        }
        return true;
    }
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
    //final修饰的变量内部可以被改变，只是引用不能再指向其他地方
/*    public static final char[] value = {'1','2'};*/
    public static void main(String[] args) {
/*        value[0] = '2';
        System.out.println(value);*/
    }
}
