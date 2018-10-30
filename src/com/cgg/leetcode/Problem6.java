package com.cgg.leetcode;

/**
 * @author cgg cgg244@qq.com
 * @data 18-10-30 下午3:53
 * gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem6 {
    /**
     * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
     * <p>
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * 之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
     * <p>
     * 实现一个将字符串进行指定行数变换的函数:
     * <p>
     * string convert(string s, int numRows);
     * 示例 1:
     * <p>
     * 输入: s = "PAYPALISHIRING", numRows = 3
     * 输出: "PAHNAPLSIIGYIR"
     * 示例 2:
     * <p>
     * 输入: s = "PAYPALISHIRING", numRows = 4
     * 输出: "PINALSIGYAHRPI"
     * 解释:
     * <p>
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        StringBuilder[] strings = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) strings[i] = new StringBuilder();
        int flag = 1;
        char[] chars = s.toCharArray();
        int index = 0;
        int cur = 0;
        while (index < chars.length) {
//            System.out.println("index:" + index + "  " + "cur:" + cur);
            strings[cur].append(chars[index]);
            if (cur + 1 >= numRows) flag = -1;
            if (cur <= 0) flag = 1;
            cur = cur + flag;
            index++;
        }
        String rs = "";
        for (int i = 0; i < numRows; i++) {
            rs = rs + strings[i].toString();
        }
        return rs;
    }

    public static void main(String[] args) {
        Problem6 problem6 = new Problem6();
        System.out.println(problem6.convert("PAYPALISHIRING", 3));
        System.out.println(problem6.convert("PAYPALISHIRING", 4));
        System.out.println(problem6.convert("AB", 2));
    }
}
