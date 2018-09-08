package com.cgg.leetcode;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-09-08 18:00:41
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem283 {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * [0,tmp)表示全部非0
    *遍历数组将非0数字调到tmp的位置,然后tmp++
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int tmp = 0;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != 0) {
                swap(nums, tmp, index);
                tmp++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12, 14};
        new Problem283().moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) System.out.print(nums[i] + " ");
        System.out.println();
    }
}
