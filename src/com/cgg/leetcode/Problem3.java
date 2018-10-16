package com.cgg.leetcode;

import java.util.HashMap;

/**
 * @author cgg cgg244@qq.com
 * @data 18-10-16 下午7:17
 * gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem3 {
    /**
     * 给定一个字符串，找出不含有重复字符的最长子串的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 无重复字符的最长子串是 "abc"，其长度为 3。
     * 示例 2:
     * <p>
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 无重复字符的最长子串是 "b"，其长度为 1。
     * 示例 3:
     * <p>
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 无重复字符的最长子串是 "wke"，其长度为 3。
     * 请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> stringIntegerHashMap = new HashMap<>();
        int rs = 0;
        int tmp = 0;
        int end = 0;
        char[] c = s.toCharArray();
        while (end < c.length) {
            if (stringIntegerHashMap.containsKey(c[end])) {
                tmp = end - stringIntegerHashMap.get(c[end]) - 1;
                int cEnd = stringIntegerHashMap.get(c[end]);
                stringIntegerHashMap.clear();
//                System.out.println(cEnd+" "+end);
                for (int i = cEnd + 1; i < end; i++) stringIntegerHashMap.put(c[i], i);

            } else {
                stringIntegerHashMap.put(c[end], end);
                end++;
                tmp++;
            }
            rs = Math.max(rs, tmp);
        }
        return rs;
    }

    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        System.out.println(problem3.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(problem3.lengthOfLongestSubstring("bbbbbbb"));
        System.out.println(problem3.lengthOfLongestSubstring("pwwkew"));
        System.out.println(problem3.lengthOfLongestSubstring("pa"));
        System.out.println(problem3.lengthOfLongestSubstring("dvdf"));
        System.out.println(problem3.lengthOfLongestSubstring("abba"));
    }
}
