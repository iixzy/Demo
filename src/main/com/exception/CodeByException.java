package main.com.exception;

import com.sun.xml.internal.ws.api.model.CheckedException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

/**
 * 异常类
 */
public class CodeByException {

//    异常定义：
//    导致程序的正常流程被中断的事件，叫做异常

    public static void main(String[] args) {
//        比如要打开d盘的LOL.exe文件，这个文件是有可能不存在的
//        Java中通过 new FileInputStream(f) 试图打开某文件，就有可能抛出文件不存在异常FileNotFoundException
//        如果不处理该异常，就会有编译错误

        File f= new File("d:/LOL.exe");
        //试图打开文件LOL.exe，会抛出FileNotFoundException，如果不处理该异常，就会有编译错误
        //所以要捕获异常
        try {
            new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        罗列出学习到目前为止，都接触过了哪些异常，分别在什么情况下会出现
        /*算数异常,空指针异常,下标越界异常,文件没有找到异常,类型转换异常*/

//        异常处理常见手段： try catch finally throws

//        try catch
//        1.将可能抛出FileNotFoundException 文件不存在异常的代码放在try里
//        2.如果文件存在，就会顺序往下执行，并且不执行catch块中的代码
//        3. 如果文件不存在，try 里的代码会立即终止，程序流程会运行到对应的catch块中
//        4. e.printStackTrace(); 会打印出方法的调用痕迹，如此例，会打印出异常开始于CodeByException的第24行，
//          这样就便于定位和分析到底哪里出了异常

//        使用异常的父类进行catch
//        FileNotFoundException是Exception的子类，使用Exception也可以catch住FileNotFoundException

//        多异常捕捉办法1
//        有的时候一段代码会抛出多种异常，比如
//        new FileInputStream(f); FileNotFoundException
//        Date d = sdf.parse("2016-06-03"); 详情见日期类

//        这段代码，会抛出 文件不存在异常 FileNotFoundException 和 解析异常ParseException
//                解决办法之一是分别进行catch 如下

//        catch (FileNotFoundException e) {
//            System.out.println("d:/LOL.exe不存在");
//            e.printStackTrace();
//        } catch (ParseException e) {
//            System.out.println("日期格式解析错误");
//            e.printStackTrace();
//        }

//        多异常捕捉办法2
//        另一个种办法是把多个异常，放在一个catch里统一捕捉

//        catch (FileNotFoundException | ParseException e) {

//        这种方式从 JDK7开始支持，好处是捕捉的代码更紧凑，不足之处是，一旦发生异常，不能确定到底是哪种异常，
//        需要通过instanceof 进行判断具体的异常类型

//        解决方法是在catch里面使用instanceof关键字去判断
//        if (e instanceof FileNotFoundException)
//            System.out.println("d:/LOL.exe不存在");
//        if (e instanceof ParseException)
//            System.out.println("日期格式解析错误");

//        finally关键字
//        无论是否出现异常，finally中的代码都会被执行

//        throws
//        考虑如下情况：
//        主方法调用method1
//        method1调用method2
//        method2中打开文件
//        method2中需要进行异常处理
//        但是method2不打算处理，而是把这个异常通过throws抛出去
//        那么method1就会接到该异常。 处理办法也是两种，要么是try catch处理掉，要么也是抛出去。
//        method1选择本地try catch住 一旦try catch住了，就相当于把这个异常消化掉了，主方法在调用method1的时候，就不需要进行异常处理了
        method1();

//        throw和throws的区别
//        throws与throw这两个关键字接近，不过意义不一样，有如下区别：
//        1. throws 出现在方法声明上，而throw通常都出现在方法体内。
//        2. throws 表示出现异常的一种可能性，并不一定会发生这些异常；
//           throw则是抛出了异常，执行throw则一定抛出了某个异常对象。

//        假设有一个方法 public int method()， 会返回一个整数
//        在这个方法中有try catch 和 finally.
//        try 里返回 1
//        catch 里 返回 2
//        finally 里 返回3
//        那么，这个方法到底返回多少？
        System.out.println(test());
//        结果是3 我以为是1
//        so...
//        1. 无论try代码块中是否有异常，finally里的代码都会执行
//        2. 当try和catch代码块中有return语句时，finally仍然会执行
//        3. 如果try...catch...finally都有return语句，则等待try catch执行完之后，
//          跳过try catch里的return语句只执行finally中的return语句
//        4. 如果仅仅是try...catch里有return语句，那么在执行return语句之前会先执行finally代码块里的内容


//        异常分类： 可查异常，运行时异常和错误3种
//        其中，运行时异常和错误又叫非可查异常

//        可查异常：CheckedException
//        可查异常即必须进行处理的异常，要么try catch住,要么往外抛，谁调用，谁处理，比如 FileNotFoundException
//        如果不处理，编译器，就不让你通过 详情见打开LOL.exe异常

//        运行时异常RuntimeException指： 不是必须进行try catch的异常
//        常见运行时异常:
//        除数不能为0异常:ArithmeticException
//        下标越界异常:ArrayIndexOutOfBoundsException
//        空指针异常:NullPointerException
//        在编写代码的时候，依然可以使用try catch throws进行处理，与可查异常不同之处在于，即便不进行try catch，
//          也不会有编译错误
//        Java之所以会设计运行时异常的原因之一，是因为下标越界，空指针这些运行时异常太过于普遍，如果都需要进行捕捉，
//          代码的可读性就会变得很糟糕。

//        //任何除数不能为0:ArithmeticException
//        int k = 5/0;
//        //下标越界异常：ArrayIndexOutOfBoundsException
//        int j[] = new int[5];
//        j[10] = 10;
//        //空指针异常：NullPointerException
//        String str = null;
//        str.length();

//        错误Error，指的是系统级别的异常，通常是内存用光了
//        在默认设置下，一般java程序启动的时候，最大可以使用16m的内存
//        例如不停的给StringBuffer追加字符，很快就把内存使用光了。抛出OutOfMemoryError
    //        与运行时异常一样，`错误也是不要求强制捕捉的`





    }

    private static int test() {
        try {
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 2;
        } finally {
            return 3;
        }
    }

    private static void method1() {
//        接收到下层的异常后有两个选择
//        1. 将异常再次用throws抛出
//        2. try catch 捕获并处理异常
        try {
            method2();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private static void method2() throws FileNotFoundException {
//        method2()不处理异常,将异常交由调用者( method1() )去处理 method1()
        File f = new File("d:/LOL.exe");

        System.out.println("试图打开 d:/LOL.exe");
        new FileInputStream(f);
        System.out.println("成功打开");

    }
}
