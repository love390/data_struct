package com.cgg.leetcode;

import java.util.Scanner;

/**
 * @Author: cgg
 * @Date: 18-9-24 下午4:56
 * @Version 1.0
 * @github github.com/love390
 * @gitee gitee.com/cgggitee/
 */
public class Problem91 {
    /**
     * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
     * <p>
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "12"
     * 输出: 2
     * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
     * 示例 2:
     * <p>
     * 输入: "226"
     * 输出: 3
     * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
     * <p>
     * 状态转移方程f[n]=if(符合规则)(f[n-1]+1)+if(符合规则)(f[n-2]+1)
     *
     *
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s.length() == 1) {
            if (isInArea(s)) return 1;
            else return 0;
        }

        if (s.startsWith("0")) return 0;

        int[] flag = new int[3];
        flag[0] = 1;

        if(isInArea(s.substring(1,2)))flag[1]=flag[0];//看成一位数新加入的元素非0,可加入
        if(isInArea(s.substring(0,2)))flag[1]++;//看成两位数


        for (int i = 2; i < s.length(); i++) {
            int c2 = 0, c1 = 0;
            if (isInArea(s.substring(i, i + 1))) c1 = flag[(i - 1)%3];//看成一位数
            if (isInArea(s.substring(i - 1, i + 1))) c2 = flag[(i - 2)%3];//看成两位数
            flag[i%3] = c1 + c2;
        }

//        for(int i:flag) System.out.print(i+" ");

        return flag[(s.length() - 1)%3];
    }

    private boolean isInArea(String s) {
        if (s.length() == 1) {
            char code = s.charAt(0);
            if ('1' <= code) return true;//一位数在合理范围,可编码
            else return false;
        } else if (s.length() == 2) {
            if (!isInArea(s.substring(0, 1))) return false;//两位数以0开头,不可编码
            char char1=s.charAt(0);
            char char2=s.charAt(1);
            if (
                    char1=='1'
                    ||
                    (char1=='2' && '0'<= char2 && char2<='6')
            ) return true;//两位数在合理范围,可编码
            else return false;
        } else return false;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Problem91 problem91 = new Problem91();
        while (scanner.hasNext()) {
            System.out.println(problem91.numDecodings(scanner.nextLine().trim()));
        }
        scanner.close();
    }
}
