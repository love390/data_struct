package com.cgg.leetcode;

import java.util.Arrays;

/**
 * @author cgg cgg244@qq.com
 * @data 18-11-5 下午3:22
 * gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem12 {
    public static class Node {
        int ints;
        String s;

        public Node(int ints, String s) {
            this.ints = ints;
            this.s = s;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "ints=" + ints +
                    ", s='" + s + '\'' +
                    '}';
        }
    }

    private static Node[] nodes;

    static {

        nodes = new Node[13];
        nodes[0] = new Node(1, "I");
        nodes[1] = new Node(4, "IV");
        nodes[2] = new Node(5, "V");
        nodes[3] = new Node(9, "IX");
        nodes[4] = new Node(10, "X");
        nodes[5] = new Node(40, "XL");
        nodes[6] = new Node(50, "L");
        nodes[7] = new Node(90, "XC");
        nodes[8] = new Node(100, "C");
        nodes[9] = new Node(400, "CD");
        nodes[10] = new Node(500, "D");
        nodes[11] = new Node(900, "CM");
        nodes[12] = new Node(1000, "M");
    }

    /**
     * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
     * <p>
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * <p>
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * <p>
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 3
     * 输出: "III"
     * 示例 2:
     * <p>
     * 输入: 4
     * 输出: "IV"
     * 示例 3:
     * <p>
     * 输入: 9
     * 输出: "IX"
     * 示例 4:
     * <p>
     * 输入: 58
     * 输出: "LVIII"
     * 解释: L = 50, V = 5, III = 3.
     * 示例 5:
     * <p>
     * 输入: 1994
     * 输出: "MCMXCIV"
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        String rs = "";
        while (num>0){
            int index = Arrays.binarySearch(nodes, new Node(num, ""), (o1, o2) -> o1.ints - o2.ints);
            index = (index + "").startsWith("-") ? -1 * index - 2 : index;
            rs=rs+nodes[index].s;
            num-=nodes[index].ints;
        }
        return rs;
    }

    public static void main(String[] args) {
        Problem12 problem12 = new Problem12();
        System.out.println(problem12.intToRoman(4).equals("IV"));
        System.out.println(problem12.intToRoman(58).equals("LVIII"));
    }
}
