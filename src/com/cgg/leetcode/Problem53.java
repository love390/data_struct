package com.cgg.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: cgg
 * @Date: 18-9-23 下午10:47
 * @Version 1.0
 * @github github.com/love390
 * @gitee gitee.com/cgggitee/
 */
public class Problem53 {
    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 示例:
     * <p>
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * 进阶:
     * <p>
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     *
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length <= 0) return 0;
        if (nums.length == 1) return nums[0];

//        int[] tmp = Arrays.copyOf(nums, nums.length);
//        int preMax = nums[0];
//
//        for (int i = 1; i < nums.length; i++) {
//            tmp[i] = Math.max(tmp[i - 1], tmp[i - 1] + tmp[i]);
//        }
//
//        for (int i = 1; i < nums.length; i++) {
//            System.out.print(nums[i] + " ");
//        }
//        return tmp[nums.length - 1];
        int rs = nums[0];
        for (int start = 0; start < nums.length; start++) {
            int tmpMax = nums[start];
            int tmp = nums[start];
            for (int end = start + 1; end < nums.length; end++) {
                tmpMax = Math.max(tmpMax, tmp + nums[end]);
                tmp = tmp + nums[end];
            }
            rs = Math.max(rs, tmpMax);
        }

        return rs;
    }

    public int maxSubArray2(int[] nums) {
        if (nums.length <= 0) return 0;
        if (nums.length == 1) return nums[0];
        int rs = Integer.MIN_VALUE;
        int sum = 0;
        for (int start = 0; start < nums.length; start++) {
            sum += nums[start];
            rs = Math.max(rs, sum);
            if (sum <= 0) sum = 0;
        }

        return rs;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Problem53 problem53 = new Problem53();
        while (scanner.hasNext()) {
            String[] data = scanner.nextLine().split(",+");
            int[] nums = new int[data.length];
            for (int i = 0; i < data.length; i++) nums[i] = Integer.parseInt(data[i]);
            System.out.println(problem53.maxSubArray2(nums));
        }
        scanner.close();
    }
}
