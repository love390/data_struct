package com.cgg.leetcode;

import java.util.Arrays;

/**
 * @Author: cgg
 * @Date: 18-9-24 下午2:27
 * @Version 1.0
 * @github github.com/love390
 * @gitee gitee.com/cgggitee/
 */
public class Problem64 {

    private int[][] flag;

    /**
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * <p>
     * 说明：每次只能向下或者向右移动一步。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * [
     * [1,3,1],
     * [1,5,1],
     * [4,2,1]
     * ]
     * 输出: 7
     * 解释: 因为路径 1→3→1→1→1 的总和最小。
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        this.flag = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 0; i <=grid.length; i++) Arrays.fill(this.flag[i], Integer.MAX_VALUE);
        return this.finMinPathSum(grid, 0, 0);
//        return this.flag[grid.length - 1][grid[0].length - 1];
    }

    /**
     * 状态转移方程
     * this.flag[i][j] = Math.min(this.flag[i - 1][j], this.flag[i][j - 1]) + getValue(grid, i - 1, j - 1);
     * @param grid
     * @param x
     * @param y
     * @return
     */
    private int finMinPathSum(int[][] grid, int x, int y) {
//        System.out.println("grid = [" + grid + "], x = [" + x + "], y = [" + y + "]");
//        if (x == 0 && y == 0) return grid[0][0];
//        if (x < 0 || y < 0) return Integer.MAX_VALUE;
//        return Math.min(finMinPathSum(grid, x, y - 1), finMinPathSum(grid, x-1, y))+getValue(grid, x, y);
        this.flag[0][1]=this.flag[1][0]=0;
        for (int i = 1; i <= grid.length; i++)
            for (int j = 1; j <= grid[0].length; j++) {
                this.flag[i][j] = Math.min(this.flag[i - 1][j], this.flag[i][j - 1]) + getValue(grid, i - 1, j - 1);
//                System.out.println("i "+i+" j "+j+" this.flag[i - 1][j] "+this.flag[i - 1][j]+" this.flag[i][j - 1] "+this.flag[i][j - 1]+" getValue(grid, i - 1, j - 1) "+ getValue(grid, i - 1, j - 1)+" this.flag[i][j] "+this.flag[i][j]);
            }
        return this.flag[grid.length][grid[0].length];
    }

    private int getValue(int[][] grid, int x, int y) {
        if (inArea(grid.length, x) && inArea(grid[0].length, y)) return grid[x][y];
        else return 0;
    }

    private boolean inArea(int size, int v) {
        if (0 <= v && v < size) return true;
        else return false;
    }

    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
        Problem64 problem64 = new Problem64();
//        while (scanner.hasNext()) {
//            String[] data = scanner.nextLine().split(",+");
//            int[] nums = new int[data.length];
//            for (int i = 0; i < data.length; i++) nums[i] = Integer.parseInt(data[i]);
//            System.out.println(problem64.minPathSum(nums));
//        }
//        scanner.close();
        int[][] grid = {
                {1,2},{1,1}
        };
        System.out.println(problem64.minPathSum(grid));
    }
}
