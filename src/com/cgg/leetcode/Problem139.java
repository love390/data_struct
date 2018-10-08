package com.cgg.leetcode;

import java.util.*;

/**
 * @author cgg cgg244@qq.com
 * @data 18-10-8 下午12:58
 * gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem139 {
    private boolean flag;

    /**
     * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

     说明：

     拆分时可以重复使用字典中的单词。
     你可以假设字典中没有重复的单词。
     示例 1：

     输入: s = "leetcode", wordDict = ["leet", "code"]
     输出: true
     解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
     示例 2：

     输入: s = "applepenapple", wordDict = ["apple", "pen"]
     输出: true
     解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。
     示例 3：

     输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     输出: false

     31/36
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        this.flag=false;
        Collections.sort(wordDict, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o1);
            }
        });
        this.find(s, wordDict);
        return this.flag;
    }

    private void find(String s, List<String> wordDict) {
        System.out.println(s);
        if (s.length() == 0) {
            this.flag = true;
            return;
        }

        for (int i = 0; i < wordDict.size(); i++) {
            if (this.flag) return;
            if (s.endsWith(wordDict.get(i))) this.find(s.substring(0,s.length()-wordDict.get(i).length()), wordDict);
        }
    }

    public static void main(String[] args) {
        Problem139 problem139 = new Problem139();

        String s = "leetcode";
        String[] words = {
                "leet", "code"
        };
        List<String> wordDict = new ArrayList<>();
        Collections.addAll(wordDict, words);


        System.out.println(problem139.wordBreak(s, wordDict) == true);

        s = "ccbb";
        words = new String[]{
                "bc","cb"
        };
        wordDict = new ArrayList<>();
        Collections.addAll(wordDict, words);


        System.out.println(problem139.wordBreak(s, wordDict) == false);
    }
}
