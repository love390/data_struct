package com.cgg.leetcode;

/**
 * @author cgg cgg244@qq.com
 * @data 18-10-30 下午6:11
 * gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem8 {
    /**
     * 实现 atoi，将字符串转为整数。
     * <p>
     * 该函数首先根据需要丢弃任意多的空格字符，直到找到第一个非空格字符为止。如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
     * <p>
     * 字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
     * <p>
     * 当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。
     * <p>
     * 若函数不能执行有效的转换，返回 0。
     * <p>
     * 说明：
     * <p>
     * 假设我们的环境只能存储 32位有符号整数，其数值范围是 [−231,231 − 1]。如果数值超过可表示的范围，
     * <p>
     * 则返回 INT_MAX(231 − 1) 或 INT_MIN (−231) 。
     * <p>
     * 示例 1:
     * <p>
     * 输入:"42"
     * 输出:42
     * 示例 2:
     * <p>
     * 输入:"   -42"
     * 输出:-42
     * 解释:第一个非空白字符为 '-',它是一个负号。
     * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
     * 示例 3:
     * <p>
     * 输入:"4193 with words"
     * 输出:4193
     * 解释:转换截止于数字 '3' ，因为它的下一个字符不为数字。
     * 示例 4:
     * <p>
     * 输入:"words and 987"
     * 输出:0
     * 解释:第一个非空字符是 'w',但它不是数字或正、负号。
     * 因此无法执行有效的转换。
     * 示例 5:
     * <p>
     * 输入:"-91283472332"
     * 输出:-2147483648
     * 解释:数字 "-91283472332"超过 32位有符号整数范围。
     * <p>
     * 因此返回 INT_MIN(−231) 。
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        if (str.length() >= 2 && !Character.isDigit(str.charAt(0)) && !Character.isDigit(str.charAt(1))) return 0;
        char prefix = str.charAt(0);
        if (str.startsWith("+"))
            str = str.replace("+", "");
        str = str.replaceAll("^(?:0|[+-])(0+)", "");
        if (str.length() == 0 || !str.startsWith("-") && !Character.isDigit(str.charAt(0))) return 0;
        if (str.length() == 1 && str.startsWith("-")) return 0;

        int maxLen = 11;
        int maxInt = Integer.MAX_VALUE;

        int index = 1;
        String rs = str.charAt(0) + "";
        while (index < str.length()) {
            if (Character.isDigit(str.charAt(index)) && index <= maxLen) {
                rs += str.charAt(index);
            } else break;
            index++;
        }
        try {
            Integer.parseInt(rs);
        } catch (Exception e) {
            if ((rs.charAt(0)) == '-') return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }

        if (!rs.equals(0) && !rs.equals(Integer.MAX_VALUE) && !rs.equals(Integer.MIN_VALUE)) {
            if (prefix == '-' && prefix != rs.charAt(0)) rs = prefix + rs;
        }

        return Integer.parseInt(rs);
    }

    public static void main(String[] args) {
        Problem8 problem8 = new Problem8();
        System.out.println(problem8.myAtoi("4193 with words"));
        System.out.println(problem8.myAtoi(" -91283472332"));
        System.out.println(problem8.myAtoi(" 91283472332"));
        System.out.println(problem8.myAtoi(" -"));
        System.out.println(problem8.myAtoi("-42"));
        System.out.println(problem8.myAtoi(""));
        System.out.println(problem8.myAtoi("-1"));
        System.out.println(problem8.myAtoi("+1"));
        System.out.println(problem8.myAtoi("-0000000000012345678"));
        System.out.println(problem8.myAtoi("-00000000000"));
        System.out.println(problem8.myAtoi("00000000000"));
        System.out.println(problem8.myAtoi("+00000000000"));
        System.out.println(problem8.myAtoi("+1"));
        System.out.println(problem8.myAtoi("-000000001"));
        System.out.println(problem8.myAtoi("  "));
        System.out.println(problem8.myAtoi("-"));
        System.out.println(problem8.myAtoi("+"));
        System.out.println(problem8.myAtoi("+-2"));

//        System.out.println(("-00000000000").replaceAll("^(?:0|[+-])(0+)", ""));
//        System.out.println(("00000000000").replaceAll("^(?:0|[+-])(0+)", ""));
//        System.out.println(("+00000000000").replaceAll("^(?:0|[+-])(0+)", ""));
    }
}
