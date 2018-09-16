package com.cgg.leetcode;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-09-16 18:08:41
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem63_1 {

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
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     *
     * 暴力破解，由62_1改编而来
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.endX = obstacleGrid[0].length - 1;
        this.endY = obstacleGrid.length - 1;
        this.uniquePathsWithObstacles2(0, 0, obstacleGrid);
        return rs;
    }


    private void uniquePathsWithObstacles2(int x, int y, int[][] obstacleGrid) {
        if (x == this.endX && y == this.endY) {
            this.rs++;
            return;
        }
        if (x > this.endX || y > this.endY) return;
        for (int i = 0; i < this.pathX.length; i++) {
            if (obstacleGrid[x][y] == 1) continue;
            this.uniquePathsWithObstacles2(x + this.pathX[i], y + this.pathY[i], obstacleGrid);
        }
    }

    public static void main(String[] args) {
        Problem63_1 problem6223 = new Problem63_1();
        int[][] obstacleGrid = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(problem6223.uniquePathsWithObstacles(obstacleGrid));
    }
}
