package com.cgg.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class Problem36 {
    /**
     * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     * 上图是一个部分填充的有效的数独。
     * 数独部分空格内已填入了数字，空白格用 '.' 表示。
     * 示例 1:
     * 输入:
     * {
     * {'5','3','.','.','7','.','.','.','.'},
     * {'6','.','.','1','9','5','.','.','.'},
     * {'.','9','8','.','.','.','.','6','.'},
     * {'8','.','.','.','6','.','.','.','3'},
     * {'4','.','.','8','.','3','.','.','1'},
     * {'7','.','.','.','2','.','.','.','6'},
     * {'.','6','.','.','.','.','2','8','.'},
     * {'.','.','.','4','1','9','.','.','5'},
     * {'.','.','.','.','8','.','.','7','9'}
     * ]
     * 输出: true
     * 示例 2:
     * 输入:
     * {
     * {'8','3','.','.','7','.','.','.','.'},
     * {'6','.','.','1','9','5','.','.','.'},
     * {'.','9','8','.','.','.','.','6','.'},
     * {'8','.','.','.','6','.','.','.','3'},
     * {'4','.','.','8','.','3','.','.','1'},
     * {'7','.','.','.','2','.','.','.','6'},
     * {'.','6','.','.','.','.','2','8','.'},
     * {}'.','.','.','4','1','9','.','.','5'},
     * {}'.','.','.','.','8','.','.','7','9'}
     * ]
     * 输出: false
     * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
     * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
     * 说明:
     * 一个有效的数独（部分已被填充）不一定是可解的。
     * 只需要根据以上规则，验证已经填入的数字是否有效即可。
     * 给定数独序列只包含数字 1-9 和字符 '.' 。
     * 给定数独永远是 9x9 形式的。
     *
     * 100AC 26ms
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> rows = new HashMap<>();//行
        HashMap<Integer, HashSet<Character>> colums = new HashMap<>();//列
        HashMap<Integer, HashSet<Character>> squared = new HashMap<>();//九格

        int[][] ints = new int[3][board.length];//各行，各列，九宫格元素数量

        //行是否符合规则
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> rowsChars = rows.get(i);
            rowsChars = rowsChars == null ? new HashSet<>() : rowsChars;
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    //行
                    rowsChars.add(board[i][j]);
                    rows.put(i, rowsChars);
                    ints[0][i]++;

                    //列
                    HashSet<Character> columsChars = colums.get(j);
                    columsChars = columsChars == null ? new HashSet<>() : columsChars;
                    columsChars.add(board[i][j]);
                    colums.put(j, columsChars);
                    ints[1][j]++;

                    //九宫格
                    int index = (i / 3) * board.length / 3 + j / 3;
//                    System.out.println(index + " " + i + " " + j + " " + board[i][j]);
                    HashSet<Character> squaredChars = squared.get(index);
                    squaredChars = squaredChars == null ? new HashSet<>() : squaredChars;
                    squaredChars.add(board[i][j]);
                    squared.put(index, squaredChars);
                    ints[2][index]++;

                }
                //行
                if (j == board.length - 1) {
                    if (rowsChars != null && ints[0][i] != rowsChars.size()
                            || (rowsChars == null && ints[0][i] > 0)
                    ) {
                        System.out.println("1");
                        return false;
                    }
                }
                //列
                if (i == board.length - 1) {
                    HashSet<Character> characters = colums.get(j);
                    if (characters != null &&
                            ints[1][j] != characters.size()
                            || (characters == null && ints[1][j] > 0)
                    ) {
//                        System.out.println("rows3:" + rows);
//                        System.out.println("colums:" + colums);
//                        System.out.println("squared:" + squared);
//                        for (int[] ints1 : ints) {
//                            System.out.println("ints:" + Arrays.toString(ints1));
//                        }
                        return false;
                    }
                }
//                //九宫格
//                int index = (i / 3) * board.length / 3 + j / 3 - 1;
//                HashSet<Character> characters = colums.get(index);
//                if (index >= 0 && (characters == null || ints[2][index] != characters.size())) {
//                    System.out.println("rows3:" + rows);
//                    System.out.println("colums:" + colums);
//                    System.out.println("squared:" + squared);
//                    for (int[] ints1 : ints) {
//                        System.out.println("ints:" + Arrays.toString(ints1));
//                    }
//                    return false;
//                }
            }
        }

        for (int i = 0; i < board.length * board.length / 9; i++) {
            HashSet<Character> characters = squared.get(i);
            if ((characters != null && characters.size() != ints[2][i])
                    || characters == null && ints[2][i] != 0
            ) {
                return false;
            }
        }

//        System.out.println("rows:" + rows);
//        System.out.println("colums:" + colums);
//        System.out.println("squared:" + squared);
//        for (int[] ints1 : ints) {
//            System.out.println("ints:" + Arrays.toString(ints1));
//        }
        return true;
    }

    public static void main(String[] args) {
        Problem36 problem36 = new Problem36();
        char[][] chars = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(problem36.isValidSudoku(chars));

        chars = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(problem36.isValidSudoku(chars));

        chars = new char[][]{
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(problem36.isValidSudoku(chars));
    }
}
