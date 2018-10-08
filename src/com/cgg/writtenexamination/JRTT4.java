package com.cgg.writtenexamination;

import java.util.Scanner;

/**
 * @author cgg cgg244@qq.com
 * @data 18-10-8 下午8:46
 * gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class JRTT4 {
    /**
     * 没来得及提交测试，个人测试良好
     *
     * @param n      n阶台阶
     * @param a      最小迈出距离
     * @param b      最大迈出距离
     * @param ignore 已经坏了的台阶
     * @return
     */
    public int climbStairs(int n, int a, int b, int[] ignore) {
        int[] flag = new int[n + 1];

        for (int j = a; j <= b; j++) {
            if (this.check(ignore, j)) flag[j] = 1;
        }

        for (int i = 1; i <= n; i++) {
            if (this.check(ignore, i))
                for (int j = a; j <= b; j++) {
                    flag[i] = flag[i] + this.getValue(flag, i - j);
                }
        }
        return flag[n];
    }

    private int getValue(int[] flag, int index) {
        if (0 <= index && index < flag.length) return flag[index];
        return 0;
    }

    private boolean check(int[] ignore, int index) {
        for (int o : ignore) {
            if (o == index) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JRTT4 JRTT4 = new JRTT4();
        while (scanner.hasNext()) {
            int m = Integer.parseInt(scanner.nextLine());
            int a = Integer.parseInt(scanner.nextLine());
            int b = Integer.parseInt(scanner.nextLine());
            int n = Integer.parseInt(scanner.nextLine());
            int[] ignore = new int[n];
            while (n-- > 0) {
                ignore[n - 1] = Integer.parseInt(scanner.nextLine());
            }
            System.out.println(JRTT4.climbStairs(m, a, b, ignore));
        }
        scanner.close();
    }

}
