package com.cgg.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author cgg cgg244@qq.com
 * @data 18-11-8 下午5:10
 * gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem22 {
    /**
     * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     * <p>
     * 例如，给出 n = 3，生成结果为：
     * <p>
     * [
     * "((()))",
     * "(()())",
     * "(())()",
     * "()(())",
     * "()()()"
     * ]
     *
     *
     * n=8超时
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        String s = " ( ) ";
        ArrayList<String> strings1 = new ArrayList<>();
        ArrayList<String> strings2 = new ArrayList<>();

        if (n <= 0) return strings1;


        if (n == 1) {
            strings1.add("()");
            return strings1;
        }


        strings1.add(" ( ) ");
        for (int i = 2; i <= n; i++) {
            ArrayList<String> strings = strings1.size() > strings2.size() ? strings1 : strings2;
            ArrayList<String> stringsNew = strings1 == strings ? strings2 : strings1;
            stringsNew.clear();
            for (String c : strings) {
                for (int j = 0; j < c.length(); j++) {
                    if (c.charAt(j) == ' ') {
                        String newS = "";
                        if (j > 0 && j < c.length() - 1) {
                            newS = c.substring(0, j) + s + c.substring(j + 1, c.length());
                        }

                        if (j == 0) {
                            newS = s + c.substring(j + 1, c.length());
                        }

                        if (j == c.length() - 1) {
                            newS = c.substring(0, c.length() - 1) + s;
                        }

                        stringsNew.add(newS);
                    }
                }
            }
        }
        strings1 = strings1.size() > strings2.size() ? strings1 : strings2;
        ArrayList<String> rs = new ArrayList<>();
        HashSet<String> stringHashSet=new HashSet<>();
        for (String sc : strings1) {
            stringHashSet.add(sc.replaceAll("\\s", ""));
        }

        for (String sc : stringHashSet) {
            rs.add(sc);
        }
//        System.out.println(strings2);
        return rs;
    }

    public static void main(String[] args) {
        Problem22 problem22 = new Problem22();
        for(int i=0;i<9;i++){
            System.out.println(i+" "+problem22.generateParenthesis(i).size());
        }
    }
}
