package main.com;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 物品类
 */
public class Item {

    String name; // 名字

    int price; // 价格

//    使用懒汉式单例模式
    private static Item instance;

    public Item () {}

    private Item getInstance () {
        if (instance == null) {
            instance = new Item();
        }
        return instance;
    }



    public static void main(String[] args) {
        Item xuPing = new Item();
        xuPing.name = "血瓶";
        xuPing.price = 50;

        Item caoXue = new Item();
        xuPing.name = "草鞋";
        xuPing.price = 300;

        Item changJian = new Item();
        xuPing.name = "长剑";
        xuPing.price = 350;


        Scanner scan = new Scanner(System.in);
//        BigInteger a = BigInteger.valueOf(scan.nextLong());
//        BigInteger b = BigInteger.valueOf(scan.nextLong());
//        System.out.println(a.add(b));

//        Integer n = scan.nextInt();
//        String str = n < 6?"工作日":"周末";
//        System.out.println(str);

//        System.out.println(Integer.toBinaryString(123));

//        位或
//        5的二进制是101
//        8的二进制是1000
//        所以 5|8 对每一位进行或运算，得到 1101->13
//        System.out.println(Integer.toBinaryString(5));
//        System.out.println(Integer.toBinaryString(8));
//        System.out.println(Integer.parseInt("1101",2));
//        System.out.println(5|8);
//        System.out.println(9|19);

//
//        System.out.println(Integer.toBinaryString(9)); //9的二进制是1001
//        System.out.println(Integer.toBinaryString(8)); //8的二进制是1000
//        System.out.println(9&8); //所以 9&8 对每一位进行与运算，得到 100->4

//        5的二进制是101
//        6的二进制是110
//        所以 5^6 对每一位进行异或运算，得到 011->3
//        一些特别情况：
//        任何数和自己进行异或 都等于 0
//        任何数和0 进行异或 都等于自己

//        int i  =5;
//        int j = 6;
//        System.out.println(Integer.toBinaryString(i)); //5的二进制是 101
//        System.out.println(Integer.toBinaryString(j)); //6的二进制是110
//        System.out.println(i^j); //所以 5^6 对每一位进行或运算，得到 011->3
//
//        System.out.println(i^0);
//        System.out.println(i^i);


//        5 的二进制是 00000101
//        所以取反即为 11111010
//        这个二进制换算成十进制即为-6
//        System.out.println(Integer.tobinarystring(i)); //5的二进制是00000101,所以取非即为11111010,即为-6

//        system.out.println(~i);


//        不用乘法符号(*) 计算 2x16
//        System.out.println(9<<1); // i << 1 = i * 2
//        System.out.println(9<<2); // i << 1 = i * 4
//        System.out.println(9<<3); // i << 1 = i * 8
//        System.out.println(16<<4); // i << 1 = i * 16

//        System.out.println(99>>1); // i >> 1 = i / 2
//        System.out.println(32>>2); // i << 1 = i / 4
//        System.out.println(64>>3); // i << 1 = i / 8
//        System.out.println(32>>4); // i << 1 = i / 16
    }
}
