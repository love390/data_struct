package com.cgg.writtenexamination;

import java.util.Scanner;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-09-20 19:47:25
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class a4 {
    private int[] flag;
    private int red;
    private int blue;
    private int green;

    private int[] rest;
    private int last=-1;

    private long total;

    public long compute(int n, int m, int k) {
        this.red = n;
        this.blue = m;
        this.green = k;
        this.rest = new int[3];
        this.rest[0] = this.red;
        this.rest[1] = this.blue;
        this.rest[2] = this.green;

        this.find(0);
        return this.total;
    }

    private void find(int index) {
        if (this.rest[0] == 0 && this.rest[1] == 0 && this.rest[2] == 0) {
            this.total++;
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (this.rest[i] != 0 && i!=last) {
                this.rest[i]--;
                this.last=i;
                find(i);
                this.rest[i]++;
                this.last=index;
            }
        }
    }

    public static void main(String[] args) {
        a4 a4 = new a4();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] integers = scanner.nextLine().trim().split("\\s+");
            int n = Integer.parseInt(integers[0]);
            int m = Integer.parseInt(integers[1]);
            int k = Integer.parseInt(integers[2]);
            System.out.println(a4.compute(n, m, k));
        }
        scanner.close();
    }
}
