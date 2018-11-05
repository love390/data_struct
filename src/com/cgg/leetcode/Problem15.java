package com.cgg.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @author cgg cgg244@qq.com
 * @data 18-11-5 下午4:44
 * gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem15 {
    /**
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     * <p>
     * 满足要求的三元组集合为：
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        HashSet<String> strings = new HashSet<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ArrayList<Integer> arraysList = new ArrayList<Integer>();
                        arraysList.add(nums[k]);
                        arraysList.add(nums[j]);
                        arraysList.add(nums[i]);
                        Collections.sort(arraysList);
                        strings.add(arraysList.toString());
                    }
                }
            }
        }
        for (String s : strings) {
            ArrayList<Integer> arraysList = new ArrayList<Integer>();
            s = s.replaceAll("\\s+","");
            s = s.substring(1, s.length());
            s = s.substring(0, s.length() - 1);
            String[] s1 = s.split(",");
            for (String s3 : s1) {
                arraysList.add(Integer.parseInt(s3));
            }
            lists.add(arraysList);
        }
        return lists;
    }

    public static void main(String[] args) {
        Problem15 problem15 = new Problem15();
        System.out.println(problem15.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
