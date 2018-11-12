package com.cgg.leetcode;

import java.util.Arrays;

/**
 * @author cgg cgg244@qq.com
 * @data 2018/11/12 19:51
 * gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem31 {
    /**
     * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     * <p>
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     * <p>
     * 必须原地修改，只允许使用额外常数空间。
     * <p>
     * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     *
     * 100%AC
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int index = -1;
        for (int j = nums.length - 1; j >= 0; j--) {
            for (int i = nums.length - 1; i >j; i--) {
                if (nums[j] < nums[i]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    index = j+1 ;
                    break;
                }
            }
            if (index != -1) break;
        }

        int[] newNum = null;
        if (index != -1 && index < nums.length) {
            newNum = Arrays.copyOfRange(nums, index, nums.length);
            Arrays.sort(newNum);
            for (int i : newNum) {
                nums[index++] = i;
            }
        } else Arrays.sort(nums);
    }

    public static void main(String[] args) {
        Problem31 problem31 = new Problem31();
        int[] nums = new int[]{1, 2, 3};
        problem31.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{};
        problem31.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 2, 3, 5, 4};
        problem31.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{2, 3, 1};
        problem31.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{4,2,0,2,3,2,0};
        problem31.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1,3,2};
        problem31.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
