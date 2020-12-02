package main.com.exception;

import main.com.lol.ADHero;
import main.com.lol.APHero;
import main.com.lol.Hero;
/**
 *自定义异常类
 * @author
 * @since 1.0.0 2020-11-25
 */
public class EnemyHeroIsDeadException extends Exception{

    public EnemyHeroIsDeadException(){

    }
    public EnemyHeroIsDeadException(String msg){
        super(msg);
    }

    public static void main(String[] args) {
//        自定义异常使用
        Hero garen =  new ADHero();
        garen.setName("盖伦");
        garen.setHp(616);

        Hero teemo =  new APHero();
        teemo.setName("提莫");
        teemo.setHp(0);

        try {
            garen.attackHero(teemo);
        } catch (EnemyHeroIsDeadException e) {
            // TODO Auto-generated catch block
            System.out.println("异常的具体原因:"+e.getMessage());
            e.printStackTrace();
        }
    }
}
