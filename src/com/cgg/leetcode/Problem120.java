package com.cgg.leetcode;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-10-08 11:59:30
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem120 {

    /**
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

     例如，给定三角形：

     [
     [2],
     [3,4],
     [6,5,7],
     [4,1,8,3]
     ]
     自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

     说明：

     如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分

     100%AC  43/43 16MS
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int rs = 0;
        List<List<Integer>> tmp = new ArrayList<>();

        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> integers = null;
            if (i == 0) {
                integers = triangle.get(0);
                tmp.add(integers);
                rs = integers.get(0);
            } else {
                List<Integer> pre = tmp.get(i - 1);
                List<Integer> cur = triangle.get(i);
                integers = new ArrayList<>();
                rs = Integer.MAX_VALUE;
                for (int j = 0; j < cur.size(); j++) {
                    int c1 = inArea(j, pre) ? pre.get(j) : Integer.MAX_VALUE;
                    int c2 = inArea(j - 1, pre) ? pre.get(j - 1) : Integer.MAX_VALUE;
                    integers.add(Math.min(c1, c2) + cur.get(j));
                    rs = Math.min(integers.get(j), rs);
                }
                tmp.add(integers);
            }
        }
        return rs;
    }

    private boolean inArea(int index, List list) {
        return index >= 0 && index < list.size();
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\[([^\\[\\]]*?)\\]");
        Scanner scanner = new Scanner(System.in);
        Problem120 problem120 = new Problem120();
        while (scanner.hasNext()) {
            List<List<Integer>> triangle = new ArrayList<>();
            Matcher matcher = pattern.matcher(scanner.nextLine());
            while (matcher.find()) {
                List<Integer> integers = new ArrayList<Integer>();
                String[] data = matcher.group(1).split("\\s*,+\\s*");
                for (String s : data) {
                    integers.add(Integer.parseInt(s));
                }
                triangle.add(integers);
            }
            System.out.println(problem120.minimumTotal(triangle));
        }
        scanner.close();
    }
}
