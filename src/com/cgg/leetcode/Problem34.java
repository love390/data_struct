package com.cgg.leetcode;

import java.util.Arrays;

public class Problem34 {
    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * 如果数组中不存在目标值，返回 [-1, -1]。
     * 示例 1:
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: [3,4]
     * 示例 2:
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: [-1,-1]
     * <p>
     * 100AC
     * <p>
     * jdk库二分查找函数稍微进行修改
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int indexStart = this.binarySearch0(nums, 0, nums.length, target, true);
        int indexEnd = this.binarySearch0(nums, 0, nums.length, target, false);
        return new int[]{indexStart >= 0 ? indexStart : -1, indexEnd >= 0 ? indexEnd : -1};
    }

    private static int binarySearch0(int[] a, int fromIndex, int toIndex,
                                     int key, boolean isFirst) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else {
                if (isFirst) while (mid > 0 && a[mid - 1] == key) mid--;
                else while (mid < a.length - 1 && a[mid + 1] == key) mid++;
                return mid; // key found
            }
        }
        return -(low + 1);  // key not found.
    }

    public static void main(String[] args) {
        Problem34 problem34 = new Problem34();
        System.out.println(Arrays.toString(problem34.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)).equals(Arrays.toString(new int[]{3, 4})));
        System.out.println(Arrays.toString(problem34.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)).equals(Arrays.toString(new int[]{-1, -1})));
        System.out.println(Arrays.toString(problem34.searchRange(new int[]{1}, 1)).equals(Arrays.toString(new int[]{0, 0})));
        System.out.println(Arrays.toString(problem34.searchRange(new int[]{2, 2}, 2)).equals(Arrays.toString(new int[]{0, 1})));
    }
}
