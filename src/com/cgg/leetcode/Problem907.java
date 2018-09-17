package com.cgg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-09-17 17:23:56
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem907 {

    /**
     * 如果一个正整数自身是回文数，而且它也是一个回文数的平方，那么我们称这个数为超级回文数。
     *
     * 现在，给定两个正整数 L 和 R （以字符串形式表示），返回包含在范围 [L, R] 中的超级回文数的数目。
     *
     *
     *
     * 示例：
     *
     * 输入：L = "4", R = "1000"
     * 输出：4
     * 解释：
     * 4，9，121，以及 484 是超级回文数。
     * 注意 676 不是一个超级回文数： 26 * 26 = 676，但是 26 不是回文数。
     *
     *
     * 提示：
     *
     * 1 <= len(L) <= 18
     * 1 <= len(R) <= 18
     * L 和 R 是表示 [1, 10^18) 范围的整数的字符串。
     * int(L) <= int(R)
     *
     * 不用hashmap超空间，用了超时
     * @param L
     * @param R
     * @return
     */
    public int superpalindromesInRange(String L, String R) {
        int start = Integer.parseInt(L);
        int end = Integer.parseInt(R);
        int count = 0;
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
//        Boolean[] flag = new Boolean[start + (end - start)];
        for (int i = start; i <= end; i++) {
            int rs = (int) Math.sqrt(i);
            if (Math.pow(rs, 2) != i) continue;
            if (this.isPalindrome(String.valueOf(i))) {
                hashMap.put(i, true);
                if (!hashMap.containsKey(rs)) {
                    if (this.isPalindrome(String.valueOf(rs))) hashMap.put(rs, true);
                    else hashMap.put(rs, false);
                }
                Boolean aBoolean = hashMap.get(rs);
                if (aBoolean != null && aBoolean) count++;

                List<Integer> list = new ArrayList<>();
                for (Integer integer : hashMap.keySet()) {
                    if (integer < rs) list.add(integer);
                }
                for (Integer integer : list) {
                    hashMap.remove(integer);
                }

            }
        }
        return count;
    }

    private boolean isPalindrome(String s) {
        int mid = 0;
        char[] lc = null;
        char[] rc = null;
        if (s.length() == 1) return true;
        if (s.length() % 2 == 0) {
            mid = (int) (s.length() / 2);
            lc = (s.substring(mid, s.length())).toCharArray();
            lc = this.reverse(lc);
            rc = (s.substring(0, mid).toCharArray());
        } else {
            mid = (int) (Math.ceil(s.length() / 2));
            lc = (s.substring(mid + 1, s.length())).toCharArray();
            lc = this.reverse(lc);
            rc = (s.substring(0, mid).toCharArray());
        }
        if (String.valueOf(lc).equals(String.valueOf(rc))) return true;
        else return false;
    }

    private char[] reverse(char[] c) {
        char[] tmp = new char[c.length];
        for (int i = 0; i < c.length; i++) {
            tmp[i] = c[c.length - 1 - i];
        }
        return tmp;
    }

    public static void main(String[] args) {
        Problem907 problem907=new Problem907();
        System.out.println(problem907.superpalindromesInRange("4","1000"));
    }
}
