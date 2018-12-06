package com.cgg.leetcode;

import java.util.Arrays;

public class Problem909 {
    private static int[] DIRECTION = new int[]{1, 2, 3, 4, 5, 6};
    private int endIndex;//结束点
    private int rs;//结果
    private boolean isFind;//是否能够到达结束点
    private int[][] flag;//记忆化搜索中间量，截去不必要的递归

    /**
     * 在一块 N x N 的板子 board 上，从板的左下角开始，每一行交替方向，按从 1 到 N*N 的数字给方格编号。例如，对于一块 6 x 6 大小的板子，可以编号如下：
     * 36 35 34 33 32 31
     * 25 26 27 28 29 30
     * 24 23 22 21 20 19
     * 13 14 15 16 17 18
     * 12 11 10 09 08 07
     * 01 02 03 04 05 06
     * 从板子的方块 1 开始（总是在最后一行、第一列）出发。
     * 从方块 x 开始，每一次移动都包含以下内容：
     * 你选择一个目标方块 S，它的编号是 x+1，x+2，x+3，x+4，x+5，或者 x+6，只要这个数字满足 <= N*N。
     * 如果 S 有一个坡或梯子，你就移动到那个坡或梯子的目的地。否则，你会移动到 S。
     * 在 r 行 c 列上的方格里有 “坡” 或 “梯子”；如果 board[r][c] != -1，那个坡或梯子的目的地将会是 board[r][c]。
     * 注意，你每次移动最多只能爬过一个坡或梯子一次：就算目的地是另一个坡或梯子的起点，你也不会继续移动。
     * 返回达到方格 N*N 所需的最少移动次数，如果不可能，则返回 -1。
     * 示例：
     * 输入：[
     * {}-1,-1,-1,-1,-1,-1},
     * {}-1,-1,-1,-1,-1,-1},
     * {}-1,-1,-1,-1,-1,-1},
     * {}-1,35,-1,-1,13,-1},
     * {}-1,-1,-1,-1,-1,-1},
     * {}-1,15,-1,-1,-1,-1]]
     * 输出：4
     * 解释：
     * 首先，从方格 1 [第 5 行，第 0 列] 开始。
     * 你决定移动到方格 2，并必须爬过梯子移动到到方格 15。
     * 然后你决定移动到方格 17 [第 3 行，第 5 列]，必须爬过坡到方格 13。
     * 然后你决定移动到方格 14，且必须通过梯子移动到方格 35。
     * 然后你决定移动到方格 36, 游戏结束。
     * 可以证明你需要至少 4 次移动才能到达第 N*N 个方格，所以答案是 4。
     * 提示：
     * 2 <= board.length = board[0].length <= 20
     * board[i][j] 介于 1 和 N*N 之间或者等于 -1。
     * 编号为 1 的方格上没有坡或梯子。
     * 编号为 N*N 的方格上没有坡或梯子。
     * <p>
     * <p>
     * 100%AC 递归+记忆化搜索
     *
     * @param board
     * @return
     */
    public int snakesAndLadders(int[][] board) {
        //初始化
        this.endIndex = board.length * board.length - 1;
        this.rs = this.endIndex;
        this.isFind = false;

        this.flag = new int[board.length][board.length];
        for (int[] ints : this.flag) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
//        long start = System.nanoTime();
        this.compute(board, 0, 0);
//        long end = System.nanoTime();
//        System.out.println((end - start) / 1000000.00);
        return this.isFind ? this.rs : -1;
    }

    private void compute(int[][] board, int curIndex, int step) {
        int x = board.length - curIndex / board.length - 1;//计算对应坐标
        int y = curIndex / board.length % 2 == 0 ? curIndex % board.length : board.length - curIndex % board.length - 1;
//        System.out.println(x+" "+y);
        if (board[x][y] == 1) return;
        if (board[x][y] != -1) curIndex = board[x][y] - 1;

        if (this.flag[x][y] <= step) return;//记忆化，剪枝
        this.flag[x][y] = step;

//        System.out.println("board = [" + board + "], curIndex = [" + curIndex + "], step = [" + step + "]");
        if (curIndex == this.endIndex || step >= this.rs) {
//            System.out.println("board = [" + board + "], curIndex = [" + curIndex + "], step = [" + step + "]");
            this.rs = Math.min(step, this.rs);
            this.isFind = true;
            return;
        }
        for (int index = 0; index < DIRECTION.length; index++) {//递归找下一步
            if (curIndex + DIRECTION[index] <= this.endIndex) {
                this.compute(board, curIndex + DIRECTION[index], step + 1);
            }
        }
    }

    public static void main(String[] args) {
        Problem909 problem909 = new Problem909();
        int[][] snakeInts = new int[][]{
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };
        System.out.println(problem909.snakesAndLadders(snakeInts));

        snakeInts = new int[][]{
                {-1, -1, -1},
                {-1, 9, 8},
                {-1, 8, 9}
        };
        System.out.println(problem909.snakesAndLadders(snakeInts));

        snakeInts = new int[][]{
                {1, 1, -1},
                {1, 1, 1},
                {-1, 1, 1}
        };
        System.out.println(problem909.snakesAndLadders(snakeInts));

        snakeInts = new int[][]{
                {-1, -1, -1, 13, 123, -1, -1, -1, -1, 37, -1, -1},
                {-1, -1, -1, -1, -1, -1, 123, -1, -1, -1, -1, -1},
                {123, -1, -1, -1, 79, 70, -1, -1, 17, -1, -1, 103},
                {-1, -1, 120, -1, 101, -1, 2, 72, -1, -1, -1, -1},
                {-1, 71, 77, -1, -1, -1, -1, 35, -1, -1, -1, -1},
                {-1, -1, 98, -1, -1, -1, -1, -1, -1, 99, -1, -1},
                {83, -1, 108, 27, -1, -1, 113, -1, -1, -1, 79, -1},
                {28, -1, -1, -1, 57, 14, -1, 48, -1, -1, -1, -1},
                {-1, -1, -1, -1, 16, 115, -1, 46, -1, -1, -1, -1},
                {-1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {94, -1, 116, -1, -1, -1, 39, 100, -1, -1, 16, -1},
                {-1, 94, -1, -1, 53, -1, -1, -1, -1, -1, -1, -1}
        };
        System.out.println(problem909.snakesAndLadders(snakeInts));
    }
}
