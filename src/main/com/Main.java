package main.com;

/**
 * @author Administrator
 */
public class Main {
//    final修饰类，方法，基本类型变量，引用的时候分别有不同的意思。
    /*1. final修饰类
        当Hero被修饰成final的时候，表示Hero不能够被继承
        其子类会出现编译错误
      2. final修饰方法
        Hero的useItem方法被修饰成final,那么该方法在ADHero中，不能够被重写
      3. final修饰基本类型变量
        final修饰基本类型变量，表示该变量只有一次赋值机会
      4. final修饰引用
        h引用被修饰成final，表示该引用只有1次指向对象的机会
        所以17行(重新new了一次)会出现编译错误
        但是，依然通过h引用修改对象的属性值hp，因为hp并没有final修饰
      5. 常量
        常量指的是可以公开，直接访问，不会变化的值
        比如 itemTotalNumber 物品栏的数量是6个*/



    public static void main(String[] args) {

    }




}
