package com.codebuilder.main.leet;


import java.util.*;

/**
 * likou试题 debug
 * @author CodeBuilder
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i-2]) {
                nums[i++] = n;
            }
        }
        System.out.println(Arrays.toString(nums));
        return i;
    }
}
