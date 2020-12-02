package main.com.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Arrays;

public class ReadFile {
    public static void main(String[] args) {

//        try {
//            // 读取f盘下该文件E:\windows\Desktop\wiki
//            //构造方法1
//            InputStream inputStream = new FileInputStream(new File("E://windows//Desktop//wiki//202011251.png"));
//            int i = 0;
//            //一次读取一个字节
//            while ((i = inputStream.read()) != -1) {
//
//                // System.out.print(i + " ");// 65 66 67 68
//                //为什么会输出65 66 67 68？因为字符在底层存储的时候就是存储的数值。即字符对应的ASCII码。
//                System.out.print((char) i + " ");// A B C D
//            }
//            inputStream.close();
//            System.out.println("----------分隔符------------");
//
//            // 读取f盘下该文件f://hell/test.txt
//            //构造方法2
//            InputStream inputStream2 = new FileInputStream("E://windows//Desktop//wiki//z2.png");
//            // 字节数组
//            byte[] b = new byte[2];
//            int i2 = 0;
//            //  一次读取一个字节数组
//            while ((i2 = inputStream2.read(b)) != -1) {
//
//                System.out.print(new String(b, 0, i2) + " ");// AB CD
//            }
//            //关闭IO流
//            inputStream2.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//
//        }
//
//        //关闭IO流

//        BigInteger begin = BigInteger.valueOf(System.currentTimeMillis());
////        读取文件 读取路径下所有文件名
//        File fileFrom_E = new File("E://developer");
//        readFileList(fileFrom_E.listFiles());
//        BigInteger end = BigInteger.valueOf(System.currentTimeMillis());
//        System.out.println(end.subtract(begin));



//        String[] string = fileFrom_E.list();
//        System.out.println(Arrays.toString(string));

    }

    /**
     *读取路径下所有文件名
     *
     * @author wsc
     * @param
     * @return
     * @since 1.0.0 2020-11-25
     */
    private static void readFileList(File[] fileFrom_e) {
        for (File e : fileFrom_e) {
            if (e.isDirectory()) {
                System.out.println(e.getName());
                if (e.listFiles() != null)
                    readFileList(e.listFiles());
//                System.out.println(e);
            } else {
                System.out.println(e.getName());
            }
        }

    }

}
