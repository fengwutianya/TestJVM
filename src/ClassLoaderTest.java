import java.io.IOException;
import java.io.InputStream;

/**
 * Created by xuan on 17-3-15.
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) return super.loadClass(name);

                    byte[] bytes = new byte[is.available()];
                    is.read(bytes);

                    return defineClass(name, bytes, 0, bytes.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
        Object object = myLoader.loadClass("ClassLoaderTest").newInstance();
        System.out.println(object.getClass());
        //loaded by different class loader, then different instanceof
        System.out.println(object instanceof ClassLoaderTest);
        System.out.println(object.getClass().getClassLoader());
        Object object1 = new ClassLoaderTest();
        System.out.println(object1.getClass().getClassLoader());
    }
}
