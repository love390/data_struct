package com.cgg.leetcode;

import java.util.Arrays;

public class Problem908 {
    /**
     * 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择任意 x 满足 -K <= x <= K，并将 x 加到 A[i] 中。
     * 在此过程之后，我们得到一些数组 B。
     * 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
     * 示例 1：
     * 输入：A = [1], K = 0
     * 输出：0
     * 解释：B = [1]
     * 示例 2：
     * 输入：A = [0,10], K = 2
     * 输出：6
     * 解释：B = [2,8]
     * 示例 3：
     * 输入：A = [1,3,6], K = 3
     * 输出：0
     * 解释：B = [3,3,3] 或 B = [4,4,4]
     * 提示：
     * 1 <= A.length <= 10000
     * 0 <= A[i] <= 10000
     * 0 <= K <= 10000
     * <p>
     * 100AC
     *
     * @param A
     * @param K
     * @return
     */
    public int smallestRangeI(int[] A, int K) {
        if (A.length <= 1) return 0;
        Arrays.sort(A);
        int mid = (A[0] + A[A.length - 1]) >> 1;
//        System.out.println("mid:"+mid);
        for (int index = 0; index < A.length; index++) {
            int flag = A[index] > mid ? -1 : 1;
            if (flag > 0) {
                if (A[index] + K >= mid) A[index] = mid;
                else A[index] = A[index] + K;
            } else {
                if (A[index] - K <= mid) A[index] = mid;
                else A[index] = A[index] - K;
            }
        }
//        System.out.println(Arrays.toString(A));
        return A[A.length - 1] - A[0];
    }

    public static void main(String[] args) {
        Problem908 problem908 = new Problem908();
        System.out.println(problem908.smallestRangeI(new int[]{1}, 0));
        System.out.println(problem908.smallestRangeI(new int[]{0, 10}, 2));
        System.out.println(problem908.smallestRangeI(new int[]{1, 3, 6}, 3));
    }
}
