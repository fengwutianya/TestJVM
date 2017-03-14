import sun.misc.Launcher;

/**
 * Created by xuan on 2017/3/14 0014.
 */
public class TestClassLoader {
    public static void main(String[] args) {
        Class<?> clazz = new TestClassLoader().getClass();
        System.out.println(clazz);
        ClassLoader classLoader = clazz.getClassLoader();
        System.out.println(classLoader.getClass());
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent.getClass());
        ClassLoader grandparent = parent.getParent();
        System.out.println(grandparent);
    }
}
