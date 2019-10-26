import java.lang.reflect.Field;

public class GetFields {
    /**
     * 通过获取成员变量
     */
    public static void main(String[] args) throws Exception {
        Persion persion = new Persion("阿狗",21,"男","189231231231");
        Class<? extends Persion> persionClass = persion.getClass();
        //只获取public 修饰的变量
        Field[] fields = persionClass.getFields();
        for (Field field:fields){
            //年龄未获取
            System.out.println(field);
        }

        System.out.println("==================");
        //获取所有的变量忽略修饰符
        Field[] declaredFields = persionClass.getDeclaredFields();
        for(Field declared:declaredFields){
            //都获取了
            System.out.println(declared);
        }

        System.out.println("===================");
        //获取了封装age成员变量的Field对象，可以通过该对象对Persion对象的私有成员变量进行改变
        Field age = persionClass.getDeclaredField("age");
        //忽略’访问‘安全检查(暴力反射)
        age.setAccessible(true);
        //改变值
        Object o = age.get(persion);
        System.out.println(o);


    }
}
