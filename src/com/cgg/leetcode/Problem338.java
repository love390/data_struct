package com.cgg.leetcode;

import java.util.Arrays;

/**
 * @author cgg cgg244@qq.com
 * @data 18-10-8 下午4:10
 * gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem338 {
    private int[] flag;

    /**
     * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 2
     * 输出: [0,1,1]
     * 示例 2:
     * <p>
     * 输入: 5
     * 输出: [0,1,1,2,1,2]
     * 进阶:
     * <p>
     * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
     * 要求算法的空间复杂度为O(n)。
     * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
     *
     * 100%AC
     * 2ms
     *
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        if (num == 0) return new int[]{0};
        this.flag = new int[num + 1];
        this.flag[0] = 0;
        this.flag[1] = 1;
        for (int i = 2; i <= num; i++) {
            this.flag[i] = this.flag[i / 2] + this.flag[i % 2];
        }
        return this.flag;
    }

    public static void main(String[] args) {
        com.cgg.leetcode.Problem338 problem338 = new com.cgg.leetcode.Problem338();
        System.out.println(Arrays.toString(problem338.countBits(8)));

    }

}
