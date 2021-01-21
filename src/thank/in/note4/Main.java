package thank.in.note4;

/**
 * @author Administrator
 */
public class Main {
    /**
     * 虽然没有goto,但是有一个能实现goto的方法
     */
    public static void main(String[] args) {
        /**
         * 在循环的时候使用
         */
        end:
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            break end;
        }

    }
}
