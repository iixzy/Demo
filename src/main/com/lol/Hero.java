package main.com.lol;

/**
 * LOL英雄类
 */
public abstract class Hero {

    String name ; //姓名

    float hp; //血量

    float armor; //护甲

    int moveSpeed; //移动速度

//    饿汉式,一开始就加载
    private static Hero instance = new Hero() {
    @Override
    public void attack() {

    }
};

    public Hero () {

    }

    public static Hero getInstance(){
        return instance;
    }


//    内部类分为四种：
//    1. 非静态内部类
//非静态内部类 BattleScore “战斗成绩”
//    非静态内部类可以直接在一个类里面定义
//
//    比如：
//    战斗成绩只有在一个英雄对象存在的时候才有意义
//    所以实例化BattleScore 的时候，必须建立在一个存在的英雄的基础上
//    语法: new 外部类().new 内部类()
//    作为Hero的非静态内部类，是可以直接访问外部类的private实例属性name的

// 非静态内部类，只有一个外部类对象存在的时候，才有意义
// 战斗成绩只有在一个英雄对象存在的时候才有意义
    class BattleScore {
        int kill;
        int die;
        int assit;

        public void legendary() {
            if (kill >= 8) {
                System.out.println(name + "超神！");
            } else {
                System.out.println(name + "尚未超神！");
            }
        }
    }



//    2. 静态内部类
//    在一个类里面声明一个静态内部类
//    比如敌方水晶，当敌方水晶没有血的时候，己方所有英雄都取得胜利，而不只是某一个具体的英雄取得胜利。
//    与非静态内部类不同，静态内部类水晶类的实例化 不需要一个外部类的实例为基础，可以直接实例化
//    语法：new 外部类.静态内部类();
//    因为没有一个外部类的实例，所以在静态内部类里面不可以访问外部类的实例属性和方法
//    除了可以访问外部类的私有静态成员外，静态内部类和普通类没什么大的区别
//敌方的水晶
    static class EnemyCrystal{
        int hp=5000;
    
        //如果水晶的血量为0，则宣布胜利
        public void checkIfVictory(){
            if(hp==0){
                Hero.battleWin();

                //静态内部类不能直接访问外部类的对象属性
//                System.out.println(name + " win this game");
            }
        }
    }



//    3. 匿名类
//    匿名类指的是在声明一个类的同时实例化它，使代码更加简洁精练
//    通常情况下，要使用一个接口或者抽象类，都必须创建一个子类
//
//    有的时候，为了快速使用，直接实例化一个抽象类，并“当场”实现其抽象方法。
//    既然实现了抽象方法，那么就是一个新的类，只是这个类，没有命名。
//    这样的类，叫做匿名类   见主方法
    public abstract void attack();

//    4. 本地类
//    本地类可以理解为有名字的匿名类
//    内部类与匿名类不一样的是，内部类必须声明在成员的位置，即与属性和方法平等的位置。
//    本地类和匿名类一样，直接声明在代码块里面，可以是主方法，for循环里等等地方




    public static void main(String[] args) {

        Hero garen = new Hero() {
            @Override
            public void attack() {

            }
        };
        garen.name = "盖伦";
        // 实例化内部类
        // BattleScore对象只有在一个英雄对象存在的时候才有意义
        // 所以其实例化必须建立在一个外部类对象的基础之上
        BattleScore score = garen.new BattleScore();
        score.kill = 9;
        score.legendary();


        //实例化静态内部类
        Hero.EnemyCrystal crystal = new Hero.EnemyCrystal();
        crystal.checkIfVictory();

        //匿名类
        ADHero adh=new ADHero();
        //通过打印adh，可以看到adh这个对象属于ADHero类
        adh.attack();
        System.out.println(adh);

        Hero h = new Hero(){
            //当场实现attack方法
            @Override
            public void attack() {
                System.out.println("新的进攻手段");
            }
        };
        h.attack();
        //通过打印h，可以看到h这个对象属于Hero$1这么一个系统自动分配的类名
        System.out.println(h);

        //本地类
        //与匿名类的区别在于，本地类有了自定义的类名
        class SomeHero extends Hero{
            @Override
            public void attack() {
                System.out.println( name+ " 新的进攻手段");
            }
        }
        SomeHero hero  =new SomeHero();
        hero.name ="地卜师";
        hero.attack();


//        在匿名类中使用外部的局部变量
//        在匿名类中使用外部的局部变量，外部的局部变量必须修饰为final
//        为什么要声明为final，其机制比较复杂，请参考第二个Hero代码中的解释
//        注：在jdk8中，已经不需要强制修饰成final了，如果没有写final，不会报错，因为编译器偷偷的帮你加上了看不见的final
        //在匿名类中使用外部的局部变量，外部的局部变量必须修饰为final
//        final int damage = 5;
//        Hero hero1 = new Hero(){
//            @Override
//            public void attack() {
//                System.out.printf("新的进攻手段，造成%d点伤害",damage);
//            }
//        };

        //在匿名类中使用外部的局部变量damage 必须修饰为final
        int damage = 5;
        //这里使用本地类AnonymousHero来模拟匿名类的隐藏属性机制
        //事实上的匿名类，会在匿名类里声明一个damage属性，并且使用构造方法初始化该属性的值
        //在attack中使用的damage，真正使用的是这个内部damage，而非外部damage
        //假设外部属性不需要声明为final
        //那么在attack中修改damage的值，就会被暗示为修改了外部变量damage的值
        //但是他们俩是不同的变量，是不可能修改外部变量damage的
        //所以为了避免产生误导，外部的damage必须声明为final,"看上去"就不能修改了
        class AnonymousHero extends Hero{
            int damage;
            public AnonymousHero(int damage){
                this.damage = damage;
            }
            @Override
            public void attack() {
                damage = 10;
                System.out.printf("新的进攻手段，造成%d点伤害",this.damage );
            }
        }
        Hero hero1 = new AnonymousHero(damage);







    }

    //类方法，静态方法
    //通过类就可以直接调用
    public static void battleWin(){
        System.out.println("hero battle win");
    }


}

