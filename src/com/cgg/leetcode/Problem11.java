package com.cgg.leetcode;

/**
 * @author cgg cgg244@qq.com
 * @data 18-10-31 下午6:55
 * gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem11 {
    /**
     * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     * 示例:
     * <p>
     * 输入: [1,8,6,2,5,4,8,3,7]
     * 输出: 49
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int rs = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                rs = Math.max(rs, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return rs;
    }

    public int maxArea2(int[] height) {
        int rs = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            rs = Math.max(rs, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) left++;
            else right--;
        }
        return rs;
    }

    public static void main(String[] args) {
        Problem11 problem11 = new Problem11();
        System.out.println(problem11.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(problem11.maxArea2(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
