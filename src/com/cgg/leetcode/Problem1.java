package com.cgg.leetcode;

import java.util.Arrays;

/**
 * @author cgg cgg244@qq.com
 * @data 18-10-16 下午6:00
 * gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem1 {
    /**
     * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
     * <p>
     * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
     * <p>
     * 示例:
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) return new int[]{i, j};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(problem1.twoSum(nums, target)));
    }
}
