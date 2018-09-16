package com.cgg.leetcode;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-09-16 17:44:56
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem62_3 {
    private static int[] pathX = new int[]{-1, 0};
    private static int[] pathY = new int[]{0, -1};

    private int endX;
    private int endY;
    private int[][] rs;

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * <p>
     * 问总共有多少条不同的路径？
     * <p>
     * 改成自地向上的动态规划
     * 状态转移方程： f[m][n]=f[m-1][n]+f[m][n-1];
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        this.endX = m;
        this.endY = n;
        this.rs = new int[m + 1][n + 1];
        if (m < 0 || n < 0) return 0;
        this.rs[1][1] = 1;
        for (int x = 1; x <= this.endX; x++) {
            for (int y = 1; y <= this.endY; y++) {
                if (x == 1 && y == 1) continue;
                int tmp = 0;
                for (int i = 0; i < this.pathX.length; i++) {
                    tmp = this.rs[x + this.pathX[i]][y + this.pathY[i]] + tmp;
                }
                this.rs[x][y] = tmp;
            }
        }
        return this.rs[this.endX][this.endY];
    }

    public static void main(String[] args) {
        Problem62_3 problem6223 = new Problem62_3();
        System.out.println(problem6223.uniquePaths(7, 3));
    }
}
