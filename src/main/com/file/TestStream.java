package main.com.file;

import sun.nio.cs.ext.GBK;

import java.io.*;
import java.nio.charset.Charset;

/**
 * 什么是流(Stream)，流就是一系列的数据
 */
public class TestStream {

//    什么是流

    //    当不同的介质之间有数据交互的时候，JAVA就使用流来实现。
//    数据源可以是文件，还可以是数据库，网络甚至是其他的程序
//    比如读取文件的数据到程序中，站在程序的角度来看，就叫做输入流
//    输入流： InputStream
//    输出流：OutputStream
    public static void main(String[] args) {
//        文件输入流
//        如下代码，就建立了一个文件输入流，这个流可以用来把数据从硬盘的文件，读取到JVM(内存)。
//        目前代码只是建立了流，还没有开始读取，真正的读取在下个章节讲解。

//        try {
//            File f = new File("d:/lol.txt");
//            // 创建基于文件的输入流
//            FileInputStream fis = new FileInputStream(f);
//            // 通过这个输入流，就可以把数据从硬盘，读取到Java的虚拟机中来，也就是读取到内存中
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

//        InputStream字节输入流
//        OutputStream字节输出流
//        用于以字节的形式读取和写入数据

//        所有的数据存放在计算机中都是以数字的形式存放的。 所以字母就需要转换为数字才能够存放。
//        比如A就对应的数字65，a对应的数字97. 不同的字母和符号对应不同的数字，就是一张码表。
//        ASCII是这样的一种码表。 只包含简单的英文字母，符号，数字等等。 不包含中文，德文，俄语等复杂的。

//        InputStream是字节输入流，同时也是抽象类，只提供方法声明，不提供方法的具体实现。
//        FileInputStream 是InputStream子类，以FileInputStream 为例进行文件读取

//        try {
//            //准备文件lol.txt其中的内容是AB，对应的ASCII分别是65 66
//            File f =new File("d:/lol.txt");
//            //创建基于文件的输入流
//            FileInputStream fis =new FileInputStream(f);
//            //创建字节数组，其长度就是文件的长度
//            byte[] all =new byte[(int) f.length()];
//            //以字节流的形式读取文件所有内容
//            fis.read(all);
//            for (byte b : all) {
//                //打印出来是65 66
//                System.out.println(b);
//            }
//
//            //每次使用完流，都应该进行关闭
//            fis.close();
//
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

//        以字节流的形式向文件写入数据

//        OutputStream是字节输出流，同时也是抽象类，只提供方法声明，不提供方法的具体实现。
//        FileOutputStream 是OutputStream子类，以FileOutputStream 为例向文件写出数据
//        注: 如果文件d:/lol2.txt不存在，写出操作会自动创建该文件。
//        但是如果是文件 d:/xyz/lol2.txt，而目录xyz又不存在，会抛出异常

//        try {
//            // 准备文件lol2.txt其中的内容是空的
//            File f = new File("d:/lol2.txt");
//            // 准备长度是2的字节数组，用88,89初始化，其对应的字符分别是X,Y
//            byte data[] = { 88, 89 };
//
//            // 创建基于文件的输出流
//            FileOutputStream fos = new FileOutputStream(f);
//            // 把数据写入到输出流
//            fos.write(data);
//            // 关闭输出流
//            fos.close();
//
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

//        找到一个大于100k的文件，按照100k为单位，拆分成多个子文件，并且以编号作为文件名结束。
//        比如文件 eclipse.exe，大小是309k。
//        拆分之后，成为
//        eclipse.exe-0
//        eclipse.exe-1
//        eclipse.exe-2
//        eclipse.exe-3

//        String path = "E:/test/psiphon3.exe";
//        try {
//            boolean start = (new File(path).exists()) ? splitFile(path) : mergeFile(path);
//            if (start){
//                System.out.println("成功");
//            }
//            else {
//                System.out.println("失败");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        所有的流，无论是输入流还是输出流，使用完毕之后，都应该关闭。
//        如果不关闭，会产生对资源占用的浪费。 当量比较大的时候，会影响到业务的正常开展。

//        在try中关闭
//        在try的作用域里关闭文件输入流，在前面的示例中都是使用这种方式，这样做有一个弊端；
//        如果文件不存在，或者读取的时候出现问题而抛出异常，那么就不会执行这一行关闭流的代码，存在巨大的资源占用隐患。 不推荐使用
//        try {
//            File f = new File("d:/lol.txt");
//            FileInputStream fis = new FileInputStream(f);
//            byte[] all = new byte[(int) f.length()];
//            fis.read(all);
//            for (byte b : all) {
//                System.out.println(b);
//            }
//            // 在try 里关闭流
//            fis.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        在finally中关闭
//        这是标准的关闭流的方式
//        1. 首先把流的引用声明在try的外面，如果声明在try里面，其作用域无法抵达finally.
//        2. 在finally关闭之前，要先判断该引用是否为空
//        3. 关闭的时候，需要再一次进行try catch处理
//        这是标准的严谨的关闭流的方式，但是看上去很繁琐，所以写不重要的或者测试代码的时候，都会采用上面的有隐患try的方式，因为不麻烦~
//        File f = new File("d:/lol.txt");
//        FileInputStream fis = null;
//        try {
//            fis = new FileInputStream(f);
//            byte[] all = new byte[(int) f.length()];
//            fis.read(all);
//            for (byte b : all) {
//                System.out.println(b);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            // 在finally 里关闭流
//            if (null != fis)
//                try {
//                    fis.close();
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//        }

//        把流定义在try()里,try,catch或者finally结束的时候，会自动关闭
//        这种编写代码的方式叫做 try-with-resources， 这是从JDK7开始支持的技术
//        所有的流，都实现了一个接口叫做 AutoCloseable，任何类实现了这个接口，都可以在try()中进行实例化。 并且在try, catch, finally结束的时候自动关闭，回收相关资源。

//        File f = new File("d:/lol.txt");
//
//        //把流定义在try()里,try,catch或者finally结束的时候，会自动关闭
//        try (FileInputStream fis = new FileInputStream(f)) {
//            byte[] all = new byte[(int) f.length()];
//            fis.read(all);
//            for (byte b : all) {
//                System.out.println(b);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        JAVA的字符流

//        Reader字符输入流
//        Writer字符输出流
//        专门用于字符的形式读取和写入数据

//        使用字符流读取文件
//        FileReader 是Reader子类，以FileReader 为例进行文件读取
        // 准备文件lol.txt其中的内容是AB
//        File f = new File("d:/lol.txt");
//        // 创建基于文件的Reader
//        try (FileReader fr = new FileReader(f)) {
//            // 创建字符数组，其长度就是文件的长度
//            char[] all = new char[(int) f.length()];
//            // 以字符流的形式读取文件所有内容
//            fr.read(all);
//            for (char b : all) {
//                // 打印出来是A B
//                System.out.println(b);
//            }
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

//        使用字符流把字符串写入到文件
//        FileWriter 是Writer的子类，以FileWriter 为例把字符串写入到文件

//        // 准备文件lol2.txt
//        File f = new File("d:/lol2.txt");
//        // 创建基于文件的Writer
//        try (FileWriter fr = new FileWriter(f)) {
//            // 以字符流的形式把数据写入到文件中
//            String data="abcdefg1234567890";
//            char[] cs = data.toCharArray();
//            fr.write(cs);
//
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

//        练习-文件加密

//        准备一个文本文件(非二进制)，其中包含ASCII码的字符和中文字符。
//        设计一个方法
//        public static void encodeFile(File encodingFile, File encodedFile);
//        在这个方法中把encodingFile的内容进行加密，然后保存到encodedFile文件中。
//        加密算法：
//        数字：
//        如果不是9的数字，在原来的基础上加1，比如5变成6, 3变成4
//        如果是9的数字，变成0
//        字母字符：
//        如果是非z字符，向右移动一个，比如d变成e, G变成H
//        如果是z，z->a, Z-A。
//        字符需要保留大小写
//        非字母字符
//        比如',&^ 保留不变，中文也保留不变
//        建议： 使用以前学习的练习题中的某个Java文件，比如循环练习，就有很多的字符和数字

//        解密在文件加密中生成的文件。
//        设计一个方法
//        public static void decodeFile(File decodingFile, File decodedFile);
//        在这个方法中把decodingFile的内容进行解密，然后保存到decodedFile文件中。
//        解密算法：
//        数字：
//        如果不是0的数字，在原来的基础上减1，比如6变成5, 4变成3
//        如果是0的数字，变成9
//        字母字符：
//        如果是非a字符，向左移动一个，比如e变成d, H变成G
//        如果是a，a->z, A-Z。
//        字符需要保留大小写
//        非字母字符：
//        比如',&^ 保留不变，中文也保留不变


//        File file = new File("E:/test/src/test.txt");
//        // 建立all以存储所有数据
//        char[] all = new char[(int)file.length()];
//        // length存储文件内容真正长度
//        int length = 0;
//        // 拿取文件内容
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
//            // read方法会返回读取到的长度
//            length = bufferedReader.read(all);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        // 对得到的字符流加密（解密）
//        for (int i = 0; i < all.length; i++) {
//            all[i] = encrypt(all[i]);
//            // all[i] = decrypt(all[i]);
//        }
//        // 解密（加密）后的数据写入
//        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
//            bufferedWriter.write(all, 0, length);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("over!");

//        编码概念
//        计算机存放数据只能存放数字，所有的字符都会被转换为不同的数字。
//        就像一个棋盘一样，不同的字，处于不同的位置，而不同的位置，有不同的数字编号。
//            有的棋盘很小，只能放数字和英文
//            有的大一点，还能放中文
//            有的“足够”大，能够放下世界人民所使用的所有文字和符号

//        常见编码
//        工作后经常接触的编码方式有如下几种：
//        ISO-8859-1 ASCII 数字和西欧字母
//        GBK GB2312 BIG5 中文
//        UNICODE (统一码，万国码)
//        其中
//        ISO-8859-1 包含 ASCII
//        GB2312 是简体中文，BIG5是繁体中文，GBK同时包含简体和繁体以及日文。
//        UNICODE 包括了所有的文字，无论中文，英文，藏文，法文，世界所有的文字都包含其中

//        UNICODE和UTF
//        根据前面的学习，我们了解到不同的编码方式对应不同的棋盘，而UNICODE因为要存放所有的数据，那么它的棋盘是最大的。
//        不仅如此，棋盘里每个数字都是很长的(4个字节)，因为不仅要表示字母，还要表示汉字等。
//        如果完全按照UNICODE的方式来存储数据，就会有很大的浪费。
//        比如在ISO-8859-1中，a 字符对应的数字是0x61
//        而UNICODE中对应的数字是 0x00000061，倘若一篇文章大部分都是英文字母，那么按照UNICODE的方式进行数据保存就会消耗很多空间
//        在这种情况下，就出现了UNICODE的各种减肥子编码, 比如UTF-8对数字和字母就使用一个字节，而对汉字就使用3个字节，从而达到了减肥还能保证健康的效果
//        UTF-8，UTF-16和UTF-32 针对不同类型的数据有不同的减肥效果，一般说来UTF-8是比较常用的方式

//        Java采用的是Unicode
//        写在.java源代码中的汉字，在执行之后，都会变成JVM中的字符。
//        而这些中文字符采用的编码方式，都是使用UNICODE. "中"字对应的UNICODE是4E2D,所以在内存中，实际保存的数据就是十六进制的0x4E2D, 也就是十进制的20013。

//        以字符 中 为例，查看其在不同编码方式下的值是多少
//        也即在不同的棋盘上的位置
//        String str = "中";
//        showCode(str);

//        文件的编码方式-记事本
//        接下来讲，字符在文件中的保存
//        字符保存在文件中肯定也是以数字形式保存的，即对应在不同的棋盘上的不同的数字
//        用记事本打开任意文本文件，并且另存为，就能够在编码这里看到一个下拉。
//            ANSI 这个不是ASCII的意思，而是采用本地编码的意思。如果你是中文的操作系统，就会使GBK，如果是英文的就会是ISO-8859-1
//            Unicode UNICODE原生的编码方式
//            Unicode big endian 另一个 UNICODE编码方式
//            UTF-8 最常见的UTF-8编码方式，数字和字母用一个字节， 汉字用3个字节。

//        eclipse也有类似的编码方式，右键任意文本文件，点击最下面的"property"
//        就可以看到Text file encoding
//        也有ISO-8859-1，GBK,UTF-8等等选项。
//        其他的US-ASCII,UTF-16，UTF-16BE,UTF-16LE不常用。

//        用FileInputStream 字节流正确读取中文
//        为了能够正确的读取中文内容
//            1. 必须了解文本是以哪种编码方式保存字符的
//            2. 使用字节流读取了文本后，再使用对应的编码方式去识别这些数字，得到正确的字符
//        如本例，一个文件中的内容是字符中，编码方式是GBK，那么读出来的数据一定是D6D0。
//        再使用GBK编码方式识别D6D0，就能正确的得到字符中

//        File f = new File("E:\\project\\j2se\\src\\test.txt");
//        try (FileInputStream fis = new FileInputStream(f);) {
//            byte[] all = new byte[(int) f.length()];
//            fis.read(all);
//            //文件中读出来的数据是
//            System.out.println("文件中读出来的数据是：");
//            for (byte b : all)
//            {
//                int i = b&0x000000ff;  //只取16进制的后两位
//                System.out.println(Integer.toHexString(i));
//            }
//            System.out.println("把这个数字，放在GBK的棋盘上去：");
//            String str = new String(all,"GBK");
//            System.out.println(str);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

//        用FileReader 字符流正确读取中文

//        FileReader得到的是字符，所以一定是已经把字节根据某种编码识别成了字符了
//        而FileReader使用的编码方式是Charset.defaultCharset()的返回值，如果是中文的操作系统，就是GBK
//        FileReader是不能手动设置编码方式的，为了使用其他的编码方式，只能使用InputStreamReader来代替，像这样：
//        new InputStreamReader(new FileInputStream(f), Charset.forName("UTF-8"));
//        在本例中，用记事本另存为UTF-8格式，然后用UTF-8就能识别对应的中文了。
//        解释： 为什么中字前面有一个?
//        如果是使用记事本另存为UTF-8的格式，那么在第一个字节有一个标示符，叫做BOM用来标志这个文件是用UTF-8来编码的。

//        File f = new File("E:\\project\\j2se\\src\\test.txt");
//        System.out.println("默认编码方式:"+Charset.defaultCharset());
//        //FileReader得到的是字符，所以一定是已经把字节根据某种编码识别成了字符了
//        //而FileReader使用的编码方式是Charset.defaultCharset()的返回值，如果是中文的操作系统，就是GBK
//        try (FileReader fr = new FileReader(f)) {
//            char[] cs = new char[(int) f.length()];
//            fr.read(cs);
//            System.out.printf("FileReader会使用默认的编码方式%s,识别出来的字符是：%n",Charset.defaultCharset());
//            System.out.println(new String(cs));
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        //FileReader是不能手动设置编码方式的，为了使用其他的编码方式，只能使用InputStreamReader来代替
//        //并且使用new InputStreamReader(new FileInputStream(f),Charset.forName("UTF-8")); 这样的形式
//        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(f),Charset.forName("UTF-8"))) {
//            char[] cs = new char[(int) f.length()];
//            isr.read(cs);
//            System.out.printf("InputStreamReader 指定编码方式UTF-8,识别出来的字符是：%n");
//            System.out.println(new String(cs));
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

//        JAVA 缓存流BUFFEREDREADER，PRINTWRITER

//        以介质是硬盘为例，字节流和字符流的弊端：
//        在每一次读写的时候，都会访问硬盘。 如果读写的频率比较高的时候，其性能表现不佳。
//        为了解决以上弊端，采用缓存流。
//        缓存流在读取的时候，会一次性读较多的数据到缓存中，以后每一次的读取，都是在缓存中访问，直到缓存中的数据读取完毕，再到硬盘中读取。
//        就好比吃饭，不用缓存就是每吃一口都到锅里去铲。用缓存就是先把饭盛到碗里，碗里的吃完了，再到锅里去铲
//        缓存流在写入数据的时候，会先把数据写入到缓存区，直到缓存区达到一定的量，才把这些数据，一起写入到硬盘中去。按照这种操作模式，
//          就不会像字节流，字符流那样每写一个字节都访问硬盘，从而减少了IO操作

//        缓存字符输入流 BufferedReader 可以一次读取一行数据

//        // 准备文件lol.txt其中的内容是
//        // garen kill teemo
//        // teemo revive after 1 minutes
//        // teemo try to garen, but killed again
//        File f = new File("d:/lol.txt");
//        // 创建文件字符流
//        // 缓存流必须建立在一个存在的流的基础上
//        try (
//                FileReader fr = new FileReader(f);
//                BufferedReader br = new BufferedReader(fr);
//        )
//        {
//            while (true) {
//                // 一次读一行
//                String line = br.readLine();
//                if (null == line)
//                    break;
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

//        PrintWriter 缓存字符输出流， 可以一次写出一行数据

//        // 向文件lol2.txt中写入三行语句
//        File f = new File("d:/lol2.txt");
//        try (
//                // 创建文件字符流
//                FileWriter fw = new FileWriter(f);
//                // 缓存流必须建立在一个存在的流的基础上
//                PrintWriter pw = new PrintWriter(fw);
//        ) {
//            pw.println("garen kill teemo");
//            pw.println("teemo revive after 1 minutes");
//            pw.println("teemo try to garen, but killed again");
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

//        有的时候，需要立即把数据写入到硬盘，而不是等缓存满了才写出去。 这时候就需要用到flush

//        //向文件lol2.txt中写入三行语句
//        File f =new File("d:/lol2.txt");
//        //创建文件字符流
//        //缓存流必须建立在一个存在的流的基础上
//        try(FileWriter fr = new FileWriter(f);PrintWriter pw = new PrintWriter(fr);) {
//            pw.println("garen kill teemo");
//            //强制把缓存中的数据写入硬盘，无论缓存是否已满
//            pw.flush();
//            pw.println("teemo revive after 1 minutes");
//            pw.flush();
//            pw.println("teemo try to garen, but killed again");
//            pw.flush();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

//        设计一个方法，用于移除Java文件中的注释
//        public void removeComments(File javaFile)
//        比如，移出以//开头的注释行
//        File f = new File("d:/LOLFolder/LOL.exe");
//        System.out.println("当前文件是：" +f);
//        //文件是否存在
//        System.out.println("判断是否存在："+f.exists());
//        //是否是文件夹
//        System.out.println("判断是否是文件夹："+f.isDirectory());
//        注： 如果注释在后面，或者是/**/风格的注释，暂不用处理

//        DataInputStream 数据输入流
//        DataOutputStream 数据输出流







    }

    /**
     * 移除Java文件中的注释
     * @param file
     */
    public static void removeComments(File file) {
        //缓存流必须建立在一个存在的流的基础上
        FileReader fr=null;
        BufferedReader br=null;
        FileWriter fw=null;
        PrintWriter pw=null;
        //StringBuffer存放读取到的全部内容
        StringBuffer sb=new StringBuffer();
        try {
            fr=new FileReader(file);
            br=new BufferedReader(fr);
            //一次读取一行，循环读取
            while (true) {
                String line=br.readLine();
                //读取完之后退出循环
                if (line==null) {
                    break;
                }
                //去除掉每行首尾空格再筛选：长度大于0的（排除空行）、不以//开头的（排除注释）
                if (line.trim().length()>0 && !line.trim().startsWith("//")) {
                    //每读取一行即追加到StringBuffer里，每追加完一行即回车换行
                    sb.append(line).append("\r\n");
                }
            }
            //将StringBuffer中的内容写入到原文件
            fw=new FileWriter(file);
            pw=new PrintWriter(fw);
            pw.println(sb);
            pw.flush();
            System.out.println("文件处理成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                pw.close();
                fw.close();
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static void showCode(String str) {
        String[] encodes = { "BIG5", "GBK", "GB2312", "UTF-8", "UTF-16", "UTF-32" };
        for (String encode : encodes) {
            showCode(str, encode);
        }

    }

    private static void showCode(String str, String encode) {
        try {
            System.out.printf("字符: \"%s\" 的在编码方式%s下的十六进制值是%n", str, encode);
            byte[] bs = str.getBytes(encode);

            for (byte b : bs) {
                int i = b&0xff;
                System.out.print(Integer.toHexString(i) + "\t");
            }
            System.out.println();
            System.out.println();
        } catch (UnsupportedEncodingException e) {
            System.out.printf("UnsupportedEncodingException: %s编码方式无法解析字符%s\n", encode, str);
        }
    }


    // 加密
    static char encrypt(char az09){
        if (az09 == '9'){
            return '0';
        }
        if (az09 == 'z'){
            return 'a';
        }
        if (az09 == 'Z'){
            return  'A';
        }
        if ((az09 >= '0' && az09 < '9') ||
                (az09 >= 'a' && az09 < 'z') ||
                (az09 >= 'a' && az09 < 'Z')) {
            az09 += 1;
        }
        return az09;
    }
    // 解密
    static char decrypt(char ba10){
        if (ba10 == '0'){
            return '9';
        }
        if (ba10 == 'a'){
            return 'z';
        }
        if (ba10 == 'A'){
            return  'Z';
        }
        if ((ba10 > '0' && ba10 <= '9') ||
                (ba10 > 'a' && ba10 <= 'z') ||
                (ba10 > 'a' && ba10 <= 'Z')) {
            ba10 -= 1;
        }
        return ba10;
    }

    // 拆分文件
    static boolean splitFile(String path) throws IOException {
        File file = new File(path);
        int length = (int) file.length();
        // 新建字节数组并将文件数据存入
        byte[] fileContent = new byte[length];
        FileInputStream fis = new FileInputStream(file);
        fis.read(fileContent);
        fis.close();
        // 删除原文件
        file.delete();
        // 创建新文件并将内容输出
        int chileLen = length / 4;
        for (int i = 0; i < 4; i++) {
            File newFile = new File(path + "-" + i);
            FileOutputStream fos = new FileOutputStream(newFile);
            fos.write(fileContent, i * chileLen, chileLen);
            if (i == 3 && length % 4 > 0) {
                fos.write(fileContent, 4 * chileLen, length % 4);
                fos.close();
            }
        }
        return true;
    }

    // 复原文件
    static boolean mergeFile(String path) throws IOException {
        File file = new File(path);
        file.createNewFile();
        FileOutputStream fos = new FileOutputStream(path);
        // 循环将子文件写入合并文件
        for (int i = 0; i < 4; i++) {
            File childFile = new File(path + "-" + i);
            InputStream fis = new FileInputStream(childFile);
            byte[] bytes = new byte[(int) childFile.length()];
            fis.read(bytes);
            fis.close();
            fos.write(bytes);
            // 删除拆分文件
            childFile.delete();
        }
        return true;
    }

}
