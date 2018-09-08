package com.cgg.leetcode;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-09-08 19:42:04
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Program26 {
    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int len = 0;
        for (int index = 0; index < nums.length; ) {
            int nextIndex = nextIndex(nums, index);
            if (nextIndex >= index && nextIndex < nums.length) {
                swap(nums, len++, nextIndex);
                index = nextIndex + 1;
            }
        }
        return len;
    }

    private int nextIndex(int[] nums, int index) {
        int next = index;
        while (next < nums.length && nums[next] == nums[index]) next++;
        return next - 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,1,2};
        int size=new Program26().removeDuplicates(nums);
        for (int i = 0; i < size; i++) System.out.print(nums[i] + " ");
        System.out.println();
    }
}
