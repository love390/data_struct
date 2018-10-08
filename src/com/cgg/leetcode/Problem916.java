package com.cgg.leetcode;

import java.util.*;

/**
 * @Author: cgg
 * @Date: 18-9-30 下午6:26
 * @Version 1.0
 * @github github.com/love390
 * @gitee gitee.com/cgggitee/
 */
public class Problem916 {
    private Vector<HashMap<Character, Integer>> vectors;
    private Vector<HashMap<Character, Integer>> vectorsB;
    private HashSet<Character> characters;

    public List<String> wordSubsets(String[] A, String[] B) {

        HashSet<String> stringsA = new HashSet<>();
        for (String s : A) stringsA.add(s);

        HashSet<String> stringsB = new HashSet<>();
        for (String s : B) stringsB.add(s);

        List<String> rs = new Vector<>();

        this.vectors = new Vector<>();
        for (String s : A) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else map.put(c, 1);
            }
            this.vectors.add(map);
        }

        this.vectorsB = new Vector<>();
        for (String s : stringsB) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else map.put(c, 1);
            }
            this.vectorsB.add(map);
        }

        this.characters = new HashSet<>();
        for (String s : stringsB) {
            for (char c : s.toCharArray()) this.characters.add(c);
        }

        for (int i = 0; i < A.length; i++) {
            boolean flag = true;
            HashMap<Character, Integer> map = (HashMap<Character, Integer>) vectors.get(i).clone();

            for (char c : this.characters) {
                if (!map.containsKey(c)) flag = false;
            }
            if (!flag) continue;

            for (HashMap<Character, Integer> mapB : this.vectorsB) {
                for (Map.Entry c : mapB.entrySet()) {
                    if (!map.containsKey(c.getKey()) || map.get(c.getKey()) < (int) c.getValue()) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) rs.add(A[i]);
        }
        return rs;
    }

    public static void main(String[] args) {
        Problem916 problem916 = new Problem916();
        String[] A = {
                "amazon", "apple", "facebook", "google", "leetcode"
        };
        String[] B = {
                "e", "o"
        };
//        System.out.println(problem916.wordSubsets(A, B).toString());

        A = new String[]{
                "amazon", "apple", "facebook", "google", "leetcode"
        };
        B = new String[]{
                "e", "oo"
        };
//        System.out.println(problem916.wordSubsets(A, B).toString());

        A = new String[]{
                "amazon", "apple", "facebook", "google", "leetcode"
        };
        B = new String[]{
                "e", "o","e"
        };
        System.out.println(problem916.wordSubsets(A, B).toString());
    }
}
