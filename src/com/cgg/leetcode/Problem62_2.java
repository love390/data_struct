package com.cgg.leetcode;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-09-16 17:40:48
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem62_2 {
    private static int[] pathX = new int[]{-1, 0};
    private static int[] pathY = new int[]{0, -1};

    private int endX;
    private int endY;
    private Integer[][] rs;

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * <p>
     * 问总共有多少条不同的路径？
     *
     * 在暴力解的基础上存储重复计算的部分，加入记忆化搜索，自顶向下
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        this.endX = m - 1;
        this.endY = n - 1;
        this.rs = new Integer[m][n];
        if (m < 0 || n < 0) return 0;
        return this.uniquePaths2(this.endX, this.endY);
    }

    private int uniquePaths2(int x, int y) {
        if (x == 0 && y == 0) {
            return 1;
        }
        if (x < 0 || y < 0) return 0;
        if (this.rs[x][y] != null) {
            return this.rs[x][y];
        }
        int tmp = 0;
        for (int i = 0; i < this.pathX.length; i++) {
            tmp = this.uniquePaths2(x + this.pathX[i], y + this.pathY[i]) + tmp;
        }
        this.rs[x][y] = tmp;
        return tmp;
    }

    public static void main(String[] args) {
        Problem62_2 problem6223 = new Problem62_2();
        System.out.println(problem6223.uniquePaths(30, 60));
    }
}
