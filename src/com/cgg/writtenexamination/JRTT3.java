package com.cgg.writtenexamination;

import java.util.Scanner;

/**
 * @author cgg cgg244@qq.com
 * @data 18-10-8 下午8:06
 * gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class JRTT3 {
    private static int[] flag;
    private int rs;

    /**
     * 使用+,-分割字符串使得和为0
     * 未完成，思路错误
     * @param s
     * @return
     */
    public int find(String s) {
        this.flag = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                int c1 = this.flag[j] + Integer.parseInt(s.substring(j + 1, i));
                int c2 = this.flag[j] - Integer.parseInt(s.substring(j + 1, i));
                this.flag[i] = c1 + c2;
            }
        }
        return this.rs;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JRTT3 JRTT3 = new JRTT3();
        while (scanner.hasNext()) {
            int count = Integer.parseInt(scanner.nextLine());
            while (count-- > 0) {
                System.out.println(JRTT3.find(scanner.nextLine()));
            }
        }
        scanner.close();
    }
}
