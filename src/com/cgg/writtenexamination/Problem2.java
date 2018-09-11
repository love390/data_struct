package com.cgg.writtenexamination;

import java.util.*;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-09-09 17:56:15
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem2 {

    //    private Set<String> stringSet;
    private int count;
    private String s;
    private boolean[] isVisited;
    private int m;
    private int n;

    public Problem2(int n, int m) {
//        this.stringSet = new HashSet<>();
        this.isVisited = new boolean[n + 1];
        this.m = m;
        this.n = n;
        if (m < n) this.n = m;
        find(s, 0, 1);
//        System.out.println(this.stringSet.size());
        System.out.println(count);
    }

    public void find(String s, int rs, int index) {
        if (rs >= this.m) {
            if (rs == this.m) {
                count++;
//                char[] chars = s.toCharArray();
//                Arrays.sort(chars);
//                this.stringSet.add(String.valueOf(chars));
            }
            return;
        }

        for (int i = index; i <= this.n; i++) {
            if (!this.isVisited[i]) {
                this.isVisited[i] = true;
                find(s + i, rs + i, i);
                this.isVisited[i] = false;
            }
        }
    }

    /**
     * 给定整数n，取若干个1到n的整数可求和等于整数m，编程求出所有组合的个数。比如当n=6，m=8时，有四种组合：[2,6], [3,5], [1,2,5], [1,3,4]。限定n和m小于120
     *时间复杂度太高 ，80以上无法做到1s内解决
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] data = scanner.nextLine().trim().split("\\s+");
            int n = Integer.parseInt(data[0]);
            int m = Integer.parseInt(data[1]);
            long start = System.currentTimeMillis();
            new Problem2(n, m);
            System.out.println((System.currentTimeMillis() - start) * 1.000 / 1000 + "s");
        }
        scanner.close();
    }
}