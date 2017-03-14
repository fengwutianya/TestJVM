import org.junit.Test;

/**
 * Created by xuan on 2017/3/14 0014.
 */
public class TryCatchFinallyWithReturn {
    public int inc() {
        int i;
        try {
            i = 1;
            int j = 5/0;
            return i;
        } catch (Exception e) {
            i = 7;
            return i;
        } finally {
            i = 11;
            return i;
            //finally中有return的话，无论如何会把locals里面的返回值修改掉
            //所以返回的肯定是3
            //如果没有return的话，i=3只是修改了i的值，并没有修改返回值
        }
    }

    public static void main(String[] args) {
        int i = new TryCatchFinallyWithReturn().inc();
        System.out.println(i);
    }
}
