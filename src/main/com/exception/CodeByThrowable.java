package main.com.exception;

import java.io.File;
import java.io.FileInputStream;

/**
 * Throwable类
 */
public class CodeByThrowable {
    public static void main(String[] args) {
//        Throwable是类，Exception和Error都继承了该类
//        所以在捕捉的时候，也可以使用Throwable进行捕捉
//        异常分Error和Exception
//        Exception里又分运行时异常和可查异常。

//        File f = new File("d:/LOL.exe");
//        try {
//            new FileInputStream(f);
//            //使用Throwable进行异常捕捉
//        } catch (Throwable t) {
//            // TODO Auto-generated catch block
//            t.printStackTrace();
//        }

//        在方法声明上，可以抛出指定的异常，比如FileNotFoundException
//        那么能否抛出Throwable这个类？
//        这个方法的调用者又该如何处理？

//        可以抛出Throwable这个类，但catch的时候必须也是Throwable类型
    }
}
