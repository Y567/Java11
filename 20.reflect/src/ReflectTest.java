import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectTest {
    /*
    利用反射实现一个小案例（可以创建任意对象和执行其方法）
     */

    public static void main(String[] args) throws Exception {
        //获取properties对象
        Properties properties = new Properties();
        //获取Class目录下的配置文件，先获得类加载器（类加载器可以知道文件路径）
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        //加载配置文件
        properties.load(is);
        //获取配置文件内的数据
        String className = properties.getProperty("className");
        String method = properties.getProperty("method");

        //加载类进入内存
        Class<?> cls = Class.forName(className);
        //创建对象
        Object o = cls.newInstance();
        //获取方法
        Method method1 = cls.getMethod(method);
        //执行方法
        method1.invoke(o);
    }
}
