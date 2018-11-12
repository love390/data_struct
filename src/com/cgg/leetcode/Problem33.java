package com.cgg.leetcode;

import java.util.Arrays;

/**
 * @author cgg cgg244@qq.com
 * @data 2018/11/12 21:25
 * gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem33 {
    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * <p>
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     * <p>
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     * <p>
     * 你可以假设数组中不存在重复的元素。
     * <p>
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     * 示例 2:
     * <p>
     * 输入: nums = [4,5,6,7,0,1,2], target = 3
     * 输出: -1
     *
     * 100%AC
     * 由正常二分查找变形，题目数组二分后必然存在一边为有序数组，一边为无序数组的情况
     * target在有序部分直接调用内部工具类获取
     * target在无序部分继续二分
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums.length <= 0) return -1;
        int rs = -1;
        int start = 0, end = nums.length - 1, mid;
        while (true) {
            mid = (end + start) >> 1;
//            System.out.println(start + ":" + mid + ":" + end);
            if (nums[start] <= nums[mid] && nums[start] <= target && nums[mid] >= target) {
                rs = Arrays.binarySearch(nums, start, mid + 1, target);
                break;
            } else if (nums[mid] <= nums[end] && nums[mid] <= target && nums[end] >= target) {
                rs = Arrays.binarySearch(nums, mid, end + 1, target);
                break;
            } else if (nums[start] > nums[mid] && (nums[start] <= target || nums[mid] >= target)) {
                end = mid;
            } else if (start == mid) {
                if (target == nums[start]) rs = start;
                else if (target == nums[end]) rs = end;
                else rs = -1;
                break;
            } else start = mid;
        }
        return rs < 0 ? -1 : rs;
    }

    public static void main(String[] args) {
        Problem33 problem33 = new Problem33();
        System.out.println(problem33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0) == 4);
        System.out.println(problem33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3) == -1);
        System.out.println(problem33.search(new int[]{1, 3}, 3) == 1);
        System.out.println(problem33.search(new int[]{1}, 0) == -1);
        System.out.println(problem33.search(new int[]{1, 3}, 0) == -1);
        System.out.println(problem33.search(new int[]{3,1}, 1) == 1);
        System.out.println(problem33.search(new int[]{5,1,3}, 5) == 0);
    }
}
