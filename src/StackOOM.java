/**
 * VM Args: -Xss2m
 * Created by xuan on 2017/3/8 0008.
 */
public class StackOOM {
    private void dontStop() {
        while (true){

        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        new StackOOM().stackLeakByThread();
    }
}
