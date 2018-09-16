package com.cgg.leetcode;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-09-16 16:57:18
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem62_1 {

    private static int[] pathX = new int[]{1, 0};
    private static int[] pathY = new int[]{0, 1};

    private int endX;
    private int endY;


    private int rs;

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * <p>
     * 问总共有多少条不同的路径？
     *
     * 暴力穷举
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        this.endX = m - 1;
        this.endY = n - 1;
        if (m < 0 || n < 0) return 0;
        this.uniquePaths2(0, 0);
        return rs;
    }

    private void uniquePaths2(int x, int y) {
        if (x == this.endX && y == this.endY) {
            this.rs++;
            return ;
        }
        if(x>this.endX ||y>this.endY) return;
        for (int i = 0; i < this.pathX.length; i++) {
            this.uniquePaths2(x+this.pathX[i],y+ this.pathY[i]);
        }
    }

    public static void main(String[] args) {
        Problem62_1 problem6223 =new Problem62_1();
        System.out.println(problem6223.uniquePaths(7,3));
    }
}
