import java.lang.reflect.Constructor;

public class GetConstructor {
    /*
    获取构造方法
     */
    public static void main(String[] args) throws Exception {
        Persion persion = new Persion();
        Class<? extends Persion> persionClass = persion.getClass();
        Constructor<? extends Persion> declaredConstructor = persionClass.getDeclaredConstructor(String.class, int.class, String.class, String.class);
        Persion persion1 = declaredConstructor.newInstance("张三", 39, "男", "1312434");
        System.out.println(persion1);
        System.out.println("==============");
        //对于空参构造方法class里有方法简化
        Persion persion2 = persionClass.newInstance();
        System.out.println(persion2);
        System.out.println("==============");
        //未简化
        Constructor<? extends Persion> declaredConstructor1 = persionClass.getDeclaredConstructor();
        Persion persion3 = declaredConstructor1.newInstance();
        System.out.println(persion3);


    }
}
