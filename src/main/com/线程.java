package main.com;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class 线程 {
    // 顺序编程 吃喝示例：当吃饭吃不完的时候，是不能喝酒的，只能吃完晚才能喝酒
    public static void main(String[] args) throws Exception {
        // 先吃饭再喝酒
//        eat();
//        drink();


        // 一边吃饭一边喝酒
//        new EatThread().start();
//        new DrinkThread().start();

//        多线程创建方式
//        继承 Thread
//        实现 Runable
//        实现 Callable

////        继承java.lang.Thread, 重写run()方法 start()启动线程
//        new SetEmail().start();

////        实现java.lang.Runnable接口，重写run()方法，然后使用Thread类来包装 ----*****更常用
//        RunableTest test = new RunableTest();
//        new Thread(test).start();



//        其他变体写法
//        // 1. 匿名内部类
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName() + "\t" + Thread.currentThread().getId());
//            }
//        }).start();

//        // 2. 尾部代码块, 是对匿名内部类形式的语法糖
//        new Thread() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName() + "\t" + Thread.currentThread().getId());
//            }
//        }.start();

//        // 3. Runnable是函数式接口，所以可以使用Lamda表达式形式
//        Runnable runnable = () -> {System.out.println(Thread.currentThread().getName() + "\t" + Thread.currentThread().getId());};
//        new Thread(runnable).start();




//        实现Callable接口，重写call()方法，然后包装成java.util.concurrent.FutureTask, 再然后包装成Thread
//        Callable：有返回值的线程，能取消线程，可以判断线程是否执行完毕
        // 将Callable包装成FutureTask，FutureTask也是一种Runnable
        MyCallable callable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();

        // get方法会阻塞调用的线程
        Integer sum = futureTask.get();
        System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId() + "=" + sum);






    }

    private static void eat() throws Exception {
        System.out.println("开始吃饭?...\t" + new Date());
        Thread.sleep(5000);
        System.out.println("结束吃饭?...\t" + new Date());
    }

    private static void drink() throws Exception {
        System.out.println("开始喝酒?...\t" + new Date());
        Thread.sleep(5000);
        System.out.println("结束喝酒?...\t" + new Date());
    }
}
class EatThread extends Thread{
    @Override
    public void run() {
        System.out.println("开始吃饭?...\t" + new Date());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束吃饭?...\t" + new Date());
    }
}

class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.currentThread().getId() + "\t" + new Date() + " \tstarting...");

        int sum = 0;
        for (int i = 0; i <= 100000; i++) {
            sum += i;
        }
        Thread.sleep(5000);

        System.out.println(Thread.currentThread().getName() + "\t" + Thread.currentThread().getId() + "\t" + new Date() + " \tover...");
        return sum;
    }
}


class DrinkThread extends Thread {
    @Override
    public void run() {
        System.out.println("开始喝酒?...\t" + new Date());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束喝酒?...\t" + new Date());
    }
}

//        继承 Thread
class SetEmail extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "先睡儿会");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.currentThread().getId());
    }
}

//        实现 Runable
class RunableTest implements Runnable {

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.currentThread().getId());
    }
}