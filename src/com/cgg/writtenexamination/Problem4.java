package com.cgg.writtenexamination;

import java.util.Scanner;

/**
 * @Author: cgg
 * @Date: 18-9-29 下午7:23
 * @Version 1.0
 * @github github.com/love390
 * @gitee gitee.com/cgggitee/
 */
public class Problem4 {

    private Integer[][] flag;
    private int rs;
    private int data;


    public int computeMin(int data) {
        this.data = data;
        this.flag = new Integer[data][data];
//        rs = Integer.MAX_VALUE;
        for (int i = 1; i <= data; i++) {
            int c1 = 0, c2 = Integer.MAX_VALUE;
            if (i % 2 == 0) c1 = this.flag[i / 2][(i - 1)];
            for (int j = 1; j < i; j++) {
                if (this.flag[i - j][j] != null) c2 = Math.min(c2, this.flag[i - j][j]);
                this.flag[i - j][j] = c2;
            }

        }
//        this.find(2, 1, 3);
        return this.rs;
    }

    private void find(int index, int flag, int deep) {
        if (index > this.data) return;

        if (index == this.data) {
            this.rs = Math.min(rs, deep);
        }

        find(index << 1, index, deep + 3);
        find(index + flag, flag, deep + 1);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Problem4 Problem4 = new Problem4();
        while (scanner.hasNext()) {
            int data = scanner.nextInt();
            System.out.println(Problem4.computeMin(data));
        }
        scanner.close();
    }
}
