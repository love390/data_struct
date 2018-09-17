package com.cgg.leetcode;

import java.util.Arrays;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-09-16 21:07:54
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem906 {
    private static Double MOD = Math.pow(10, 9) + 7;

    /**
     * 给定一个整数数组 A，找到 min(B) 的总和，其中 B 的范围为 A 的每个（连续）子数组。
     * <p>
     * 由于答案可能很大，因此返回答案模 10^9 + 7。
     * <p>
     * 状态转移方程f[n]=f[n-1]+sum(min(A[i~n]))   （1<=i<=n）
     * <p>
     * 测试通过94%的用例，正常情况下O(N^2)应该是可以计算10^4的，但是有个超大数据来的时候结果超时
     * 1 <= A <= 30000
     * 1 <= A[i] <= 30000
     *
     * @param A
     * @return
     */
    public int sumSubarrayMins(int[] A) {
        if (A.length == 1) return A[0];
        int len = A.length;
        int[] flag = Arrays.copyOf(A, A.length);
        for (int i = 1; i < len; i++) {
            int tmp = 0;
            int minFlag = A[i];
            for (int j = i; j >= 0; j--) {
                minFlag = Math.min(minFlag, A[j]);
                tmp = tmp + minFlag;
            }
            int a = flag[i - 1] + tmp;
            flag[i] = (int) (a % MOD);
        }
        return (flag[len - 1]);
    }

    public static void main(String[] args) {
//        int[] A = new int[]{3, 2, 1, 4};
        int len = 30000;
        int[] A = new int[len];
        for (int i = 0; i < len; i++) A[i] = (int) (Math.random() * len);
        Problem906 problem906 = new Problem906();
        long start = System.currentTimeMillis();
        System.out.println(problem906.sumSubarrayMins(A));
        System.out.println((System.currentTimeMillis() - start) * 1.000 / 1000 + "s");//结果0.4左右
    }
}
