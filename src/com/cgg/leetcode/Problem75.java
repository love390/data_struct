package com.cgg.leetcode;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-09-08 19:17:41
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem75 {
    /**
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * <p>
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * <p>
     * 注意:
     * 不能使用代码库中的排序函数来解决这道题。
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int index = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = index; j < nums.length; j++) {
                if (nums[j] == i) {
                    swap(nums, j, index);
                    index++;
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        new Problem75().sortColors(nums);
        for (int i = 0; i < nums.length; i++) System.out.print(nums[i] + " ");
    }
}
