package com.cgg.leetcode;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-09-16 18:33:51
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem63_3 {
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
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     * <p>
     * 在62.3的基础上改进
     *
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        if (obstacleGrid[0][0] == 0 && obstacleGrid.length == 1 && obstacleGrid[0].length == 1) return 1;
        this.endX = obstacleGrid[0].length;
        this.endY = obstacleGrid.length;
        this.rs = new int[this.endX + 1][this.endY + 1];
        if (this.endX < 0 || this.endY < 0) return 0;
        this.rs[1][1] = 1;
        for (int x = 1; x <= this.endX; x++) {
            for (int y = 1; y <= this.endY; y++) {
                if (x == 1 && y == 1) continue;
                if (obstacleGrid[x-1][y-1] == 1) continue;
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
        Problem63_3 problem6223 = new Problem63_3();
        int[][] obstacleGrid = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
//                {0}
        };
        System.out.println(problem6223.uniquePathsWithObstacles(obstacleGrid));
    }
}
