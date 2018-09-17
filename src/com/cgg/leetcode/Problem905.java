package com.cgg.leetcode;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-09-16 19:08:48
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem905 {
    /**
     * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
     * <p>
     * 你可以返回满足此条件的任何数组作为答案。
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParity(int[] A) {
        if (A.length <= 1) return A;
        int lp = 0;
        int rp = A.length - 1;
        while (lp < rp) {
            while ( lp < rp&& A[lp] % 2 == 0) lp++;

            int tmp = A[lp];
            A[lp] = A[rp];
            A[rp] = tmp;
            rp--;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = new int[]{0,2};
        Problem905 problem905 = new Problem905();
        for (int i : problem905.sortArrayByParity(A)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
