package main.com.collection;

import main.com.lol.ADHero;
import main.com.lol.APHero;
import main.com.lol.Hero;

import java.util.ArrayList;

/**
 * 集合类
 */
public class TestCollection {
    public static void main(String[] args) {
//        如果要存放多个对象，可以使用数组，但是数组有局限性
//        比如 声明长度是10的数组
//        不用的数组就浪费了
//        超过10的个数，又放不下

//        //数组的局限性
//        Hero heros[] = new Hero[10];
//        //声明长度是10的数组
//        //不用的数组就浪费了
//        //超过10的个数，又放不下
//        heros[0] = new ADHero("盖伦");
//        //放不下要报错
//        heros[20] = new APHero("提莫");

//        为了解决数组的局限性，引入容器类的概念。 最常见的容器类就是  ---  ArrayList
//        容器的容量"capacity"会随着对象的增加，自动增长
//        只需要不断往容器里增加英雄即可，不用担心会出现数组的边界问题。

//        //容器类ArrayList，用于存放对象
//        ArrayList heros = new ArrayList();
//        heros.add( new ADHero("盖伦"));
//        System.out.println(heros.size());
//        //容器的容量"capacity"会随着对象的增加，自动增长
//        //只需要不断往容器里增加英雄即可，不用担心会出现数组的边界问题。
//        heros.add( new APHero("提莫"));
//        System.out.println(heros.size());

//        集合常用方法
//        add	增加
//        contains	判断是否存在
//        get	获取指定位置的对象
//        indexOf	获取对象所处的位置
//        remove	删除
//        set	替换
//        size	获取大小
//        toArray	转换为数组
//        addAll	把另一个容器所有对象都加进来
//        clear	清空

    }
}
