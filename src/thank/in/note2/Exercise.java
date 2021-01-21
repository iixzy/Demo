package thank.in.note2;

import thank.in.note2.exercise.DataOnly;
import thank.in.note2.exercise.One;

/**
 * @author Administrator
 */
public class Exercise {
    public static void main(String[] args) {
        System.out.println(new One().i);
        System.out.println(new One().j);
        System.out.println(new One().k);
        //0
        //
        //0.0
        DataOnly dataOnly = new DataOnly();
        dataOnly.setB(true);
        dataOnly.setD(9.9999);
        dataOnly.setI(1000000000);
        System.out.println(dataOnly.getD()+""+dataOnly.isB()+dataOnly.getI());
        /**
         * Boolean 生成set和get的时候会生成set和isXXX
         */
    }
}
