package com.cgg.writtenexamination;

import java.util.Scanner;

/**
 * @Author: cgg
 * @Date: 18-9-25 下午8:22
 * @Version 1.0
 * @github github.com/love390
 * @gitee gitee.com/cgggitee/
 */
public class KuaiShou2 {
    private int[] w;
    private int[] l;
    private boolean isVisited[];
    private int rest;
    private int rs;

    /**
     * 快手算法2/3题
     * 搭积木,A的宽和长小于等于B的就可叠上去,最高层数
     * 没全部AC
     * @param w
     * @param l
     * @return
     */
    public int compute(int[] w, int[] l) {
        this.w = w;
        this.l = l;
        this.isVisited = new boolean[w.length];
        find(-1, 0);
        return rs;
    }

    private void find(int pre, int deep) {

        rs = Math.max(rs, deep - 1);

        for (int i = 0; i < this.w.length; i++) {
            if (pre != -1) {
                if (this.w[pre] >= this.w[i] && this.l[pre] >= this.l[i]) {
                    continue;
                }
            }
            if (this.isVisited[i] == false) {
                this.isVisited[i] = true;
                deep++;
                find(i, deep);
                deep--;
                this.isVisited[i] = true;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KuaiShou2 kuaiShou21 = new KuaiShou2();
        while (scanner.hasNext()) {
            int len = Integer.parseInt(scanner.nextLine().trim());
            int[] w = new int[len];
            int[] l = new int[len];

            int i = 0;
            String[] data = null;
            while (i < len) {
                data = scanner.nextLine().split("\\s+");
                w[i] = Integer.parseInt(data[0]);
                l[i] = Integer.parseInt(data[1]);
                i++;
            }
            System.out.println(kuaiShou21.compute(w, l));
        }
        scanner.close();
    }
}
