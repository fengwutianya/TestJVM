/**
 * -Xss128k
 * Created by xuan on 2017/3/8 0008.
 */
public class StackSOF {
    private static int stackLength = 1;
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        try {
            new StackSOF().stackLeak();
        } catch (Throwable e) {
            System.out.println(stackLength);
            throw e;
        }
    }
}
