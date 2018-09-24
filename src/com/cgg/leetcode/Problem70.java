package com.cgg.leetcode;

import java.util.Scanner;

/**
 * @Author: cgg
 * @Date: 18-9-24 下午4:27
 * @Version 1.0
 * @github github.com/love390
 * @gitee gitee.com/cgggitee/
 */
public class Problem70 {
    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * <p>
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * <p>
     * 注意：给定 n 是一个正整数。
     * <p>
     * 示例 1：
     * <p>
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     * 示例 2：
     * <p>
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     * f[n]表示到第n阶的方法个数
     *f[n]=f[n-1]+f[n-2]
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] flag = new int[3];
        flag[2] = 2;
        flag[1] = 1;
        for (int i = 3; i <= n; i++) {
            flag[i%3] = this.getValue(flag, (i - 1)%3) + this.getValue(flag, (i - 2)%3);
        }
        return flag[n%3];
    }

    private int getValue(int[] flag, int index) {
        if (0 <= index && index < flag.length) return flag[index];
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Problem70 problem70 = new Problem70();
        while (scanner.hasNext()) {
            System.out.println(problem70.climbStairs(Integer.parseInt(scanner.nextLine().trim())));
        }
        scanner.close();
    }
}
