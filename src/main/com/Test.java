package main.com;

import java.util.HashSet;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        test(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
    public static void test (int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                System.out.println(j + ":" + nums[j]);
                sum += nums[j];
                if (sum < max) {
                    break;
                } else {
                    max = sum;
                }
            }
        }
        System.out.println("max : "+max);
    }
}
