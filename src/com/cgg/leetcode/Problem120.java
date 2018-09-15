package com.cgg.leetcode;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-09-11 20:28:30
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rs = 0;
        for (List<Integer> integers : triangle) {
            Collections.sort(integers);
            rs = rs + (int) integers.get(0);
        }
        return rs;
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
