package com.cgg.writtenexamination;

import java.util.Scanner;

/**
 * @author cgg cgg244@qq.com
 * @data 18-10-9 下午9:08
 * gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class MT2 {
    /**
     *      * 美团点评校招
     * 给定顶点度数，求该图是否为树（无环）
     *
     * 100%AC
     * @param data
     * @return
     */
    public String check(int[] data) {
        int total = 0;
        for (int i : data) total += i;
        return total == (data.length - 1) * 2 ? "Yes" : "No";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MT2 MT2 = new MT2();
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            while (n-- > 0) {
                int len = Integer.parseInt(scanner.nextLine());
                int[] data = new int[len];
                String[] in = scanner.nextLine().split("\\s+");
                for (int i = 0; i < in.length; i++) data[i] = Integer.parseInt(in[i]);
                System.out.println(MT2.check(data));
            }

        }
        scanner.close();
    }
}
