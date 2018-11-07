package com.cgg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author cgg cgg244@qq.com
 * @data 18-11-7 下午2:31
 * gitee:www.gitee.com/cgggitee/
 * github:https://gith
 * ub.com/love390/
 */
public class Problem17 {
    private static HashMap<Character, String> stringHashMap = new HashMap<>();

    static {
        stringHashMap.put('2', "abc");
        stringHashMap.put('3', "def");
        stringHashMap.put('4', "ghi");
        stringHashMap.put('5', "jkl");
        stringHashMap.put('6', "mno");
        stringHashMap.put('7', "pqrs");
        stringHashMap.put('8', "tuv");
        stringHashMap.put('9', "wxyz");
        stringHashMap.put('0', " ");
    }

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * <p>
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * 示例:
     * <p>
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * 说明:
     * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if(digits.length()<=0)return new ArrayList<>();
        List<String> strings = new ArrayList<>();
        strings.add("");
        digits = digits.replaceAll("1", "");
        for (char c : digits.toCharArray()) {
            List<String> newS = new ArrayList<>();
            String s = stringHashMap.get(c);

            for (char c1 : s.toCharArray()) {
                for (String sTmp : strings) {
                    newS.add(sTmp + String.valueOf(c1));
                }
            }

            strings = newS;
        }
        return strings;
    }

    public static void main(String[] args) {
        Problem17 problem17 = new Problem17();
        System.out.println(problem17.letterCombinations("23"));
    }
}
