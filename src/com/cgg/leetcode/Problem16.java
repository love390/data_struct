package com.cgg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author cgg cgg244@qq.com
 * @data 18-11-7 下午1:43
 * gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem16 {
    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     * <p>
     * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
     * <p>
     * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<Integer> integers1 = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    integers.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }
        for (int i : integers) {
            integers1.add(Math.abs(i - target));
        }

        if (integers.size() <= 0) return 0;
        int tmpIndex = 0;
        for (int i = 0; i < integers1.size(); i++) {
            tmpIndex = integers1.get(i) > integers1.get(tmpIndex) ? tmpIndex : i;
        }
        return integers.get(tmpIndex);
    }

    /**
     * 第一次接触这种降低复杂度的操作，别人的博客
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int clost = Integer.MAX_VALUE, sub = 0, abssub = 0, sum = 0; // 定义最接近的数,目前差值
        for (int i = 1; i < nums.length - 1; i++) {
            int left = 0, right = nums.length - 1;
            while (left < i && right > i) {

                sub = nums[left] + nums[right] + nums[i] - target;
                abssub = Math.abs(sub);

                if (clost > abssub) {
                    clost = abssub;
                    sum = nums[left] + nums[right] + nums[i];
                }
                if (sub > 0) {
                    right--;
                } else if (sub < 0) {
                    left++;
                } else {
                    sum = nums[left] + nums[right] + nums[i];
                    break;
                }
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        Problem16 problem16 = new Problem16();
        System.out.println(problem16.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
