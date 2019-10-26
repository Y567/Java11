import java.lang.reflect.Method;

public class getMethods {
    /*
    获取成员方法
     */
    public static void main(String[] args) throws Exception {
        Persion persion = new Persion();
        Class<? extends Persion> persionClass = persion.getClass();
        Method eat = persionClass.getMethod("eat");
        Method eat2 = persionClass.getMethod("eat",String.class);
        eat.invoke(persion);//Method对象的方法，用来执行方法
        eat2.invoke(persion,"阿坤");

    }
}
