/**
 * -Xss128k
 * Created by xuan on 2017/3/8 0008.
 */
public class StackSOF {
    private int stackLength = 1;
    public void stackLeak() {
        stackLength++;
        System.out.println(stackLength);
        stackLeak();
    }

    public static void main(String[] args) {
        new StackSOF().stackLeak();
    }
}
