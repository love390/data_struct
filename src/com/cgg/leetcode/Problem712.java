package com.cgg.leetcode;

import java.util.*;

/**
 * @author cgg cgg244@qq.com
 * @data 18-11-1 下午7:36
 * gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem712 {

    class Node  {
        String s;
        int total;

        public Node(String s, int total) {
            this.s = s;
            this.total = total;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (total != node.total) return false;
            return s != null ? s.equals(node.s) : node.s == null;
        }

        @Override
        public int hashCode() {
            int result = s != null ? s.hashCode() : 0;
            result = 31 * result + total;
            return result;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "s='" + s + '\'' +
                    ", total=" + total +
                    '}';
        }
    }

    /**
     * 给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。
     * <p>
     * 示例 1:
     * <p>
     * 输入: s1 = "sea", s2 = "eat"
     * 输出: 231
     * 解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
     * 在 "eat" 中删除 "t" 并将 116 加入总和。
     * 结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
     * 示例 2:
     * <p>
     * 输入: s1 = "delete", s2 = "leet"
     * 输出: 403
     * 解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
     * 将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
     * 结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
     * 如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
     * <p>
     * <p>
     * 部分超时
     *
     * @param s1
     * @param s2
     * @return
     */
    public int minimumDeleteSum(String s1, String s2) {
        if (s1.length() <= 0 || s2.length() <= 0) {
            return 0;
        }

        HashSet<Node> strings1 = new HashSet<>();
        HashSet<Node> strings2 = new HashSet<>();
        strings1.add(new Node(s1, 0));
        strings2.add(new Node(s2, 0));

        removeChars(strings1, s1.length());
        removeChars(strings2, s2.length());

//        System.out.println(Arrays.toString(strings1.toArray()));
//        System.out.println(Arrays.toString(strings2.toArray()));

//        String[] strings1s = new String[s1.length()];
//        String[] strings2s = new String[s2.length()];
//        strings1s = strings1.toArray(strings1s);
//        strings2s = strings2.toArray(strings2s);
        Node[] strings1s=toNode(strings1.toArray());
        Node[] strings2s=toNode(strings2.toArray());

//        Arrays.sort(strings1s, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() != o2.length() ? o2.length() - o1.length() : o1.compareTo(o2);
//            }
//        });
//        Arrays.sort(strings2s, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() != o2.length() ? o2.length() - o1.length() : o1.compareTo(o2);
//            }
//        });

//        System.out.println(Arrays.toString(strings1s));
//        System.out.println(Arrays.toString(strings2s));
        int index1 = 0;
        int index2 = 0;
        int rs = Integer.MAX_VALUE;
//        while (true) {
//            while (strings1s[index1].length() > strings2s[index2].length())index1++;
//            while (strings1s[index1].length() < strings2s[index2].length())index2++;

        for (int i = index1; i < strings1s.length; i++) {
            for (int j = index2; j < strings2s.length; j++) {
                if (strings1s[i].s.equals(strings2s[j].s))
//                    System.out.println(strings1s[i]+":"+strings2s[j]);
//                System.out.print(rs+" :");
//                    rs = Math.min(rs, codeTotal(s1, strings1s[i]) + codeTotal(s2, strings2s[j]));
                    rs = Math.min(rs, strings1s[i].total+strings2s[j].total);
//                System.out.println(rs);

            }
        }
//        }


        return rs;
    }

    public void removeChars(HashSet<Node> strings, int deep) {
        if (deep <= 1) return;

        List<Node> strings1 = new ArrayList<>();
        for (Node s : strings) {
            for (int i = 0; i < s.s.length() - 1; i++) {
                String newS = s.s.substring(0, i) + s.s.substring(i + 1, s.s.length());
                strings1.add(new Node(newS, s.total+s.s.codePointAt(i)));
            }
            if (s.s.length() >= 1) {
                String s1 = s.s.substring(1, s.s.length());
                String s2 = s.s.substring(0, s.s.length() - 1);
                strings1.add(new Node(s1, s.total+s.s.codePointAt(0)));
                strings1.add(new Node(s2, s.total+s.s.codePointAt(s.s.length()-1)));
            }
        }
        for (Node s : strings1) {
            strings.add(s);
        }

        removeChars(strings, --deep);
    }

    public Node[] toNode(Object[] o) {
        Node[] nodes = new Node[o.length];
        for (int i = 0; i < o.length; i++) {
            Node node = (Node) o[i];
            nodes[i] = node;
        }
        return nodes;
    }

    public int calutlate(String s) {
        int tmp = 0;
        for (char c : s.toCharArray()) tmp += c;
        return tmp;
    }

    public int codeTotal(String s1, String s11) {
        int rs = 0;
        HashMap<Character, Integer> characterIntegerHashMap1 = new HashMap<>();
        HashMap<Character, Integer> characterIntegerHashMap2 = new HashMap<>();
        char[] c1 = s1.toCharArray();
        char[] c2 = s11.toCharArray();

        for (char c : c1) {
            if (characterIntegerHashMap1.containsKey(c))
                characterIntegerHashMap1.put(c, characterIntegerHashMap1.get(c) + 1);
            else characterIntegerHashMap1.put(c, 1);
        }
        for (char c : c2) {
            if (characterIntegerHashMap2.containsKey(c))
                characterIntegerHashMap2.put(c, characterIntegerHashMap2.get(c) + 1);
            else characterIntegerHashMap2.put(c, 1);
        }

        for (char c : c1) {
            int num1 = characterIntegerHashMap1.containsKey(c) ? characterIntegerHashMap1.get(c) : 0;
            int num2 = characterIntegerHashMap2.containsKey(c) ? characterIntegerHashMap2.get(c) : 0;
            rs += (num1 - num2) * c;
            characterIntegerHashMap1.remove(c);
            characterIntegerHashMap2.remove(c);
        }
        return rs;
    }

    public static void main(String[] args) {
        Problem712 problem712 = new Problem712();
        System.out.println(problem712.minimumDeleteSum("sea", "eat"));
        System.out.println(problem712.minimumDeleteSum("delete", "leet"));
        System.out.println(problem712.minimumDeleteSum("a", "at"));
    }
}
