package com.cgg.leetcode;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-09-16 18:16:03
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem63_2 {
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
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     * <p>
     * 在暴力解63_1的基础上存储重复计算的部分，加入记忆化搜索，自顶向下
     *
     * @return
     */

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.endX = obstacleGrid.length - 1;
        this.endY = obstacleGrid[0].length - 1;
        this.rs = new Integer[this.endX + 1][this.endY + 1];
        if (this.endX < 0 || this.endY < 0) return 0;
        if (obstacleGrid[0][0] == 1) return 0;
        return this.uniquePathsWithObstacles2(this.endX, this.endY, obstacleGrid);
    }

    private int uniquePathsWithObstacles2(int x, int y, int[][] obstacleGrid) {
        if (x == 0 && y == 0) {
            return 1;
        }
        if (x < 0 || y < 0) return 0;
        if (this.rs[x][y] != null) {
            return this.rs[x][y];
        }
        int tmp = 0;
        for (int i = 0; i < this.pathX.length; i++) {
            System.out.println(x + " " + y);
            if (obstacleGrid[x][y] == 1) continue;
            tmp = this.uniquePathsWithObstacles2(x + this.pathX[i], y + this.pathY[i], obstacleGrid) + tmp;
        }
        this.rs[x][y] = tmp;
        return tmp;
    }

    public static void main(String[] args) {
        Problem63_2 problem6223 = new Problem63_2();
        int[][] obstacleGrid = new int[][]{
//                {0, 0, 0},
//                {0, 1, 0},
//                {0, 0, 0}
                {1}
        };
        System.out.println(problem6223.uniquePathsWithObstacles(obstacleGrid));
    }
}
