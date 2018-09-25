package com.cgg.writtenexamination;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Author: cgg
 * @Date: 18-9-25 下午8:22
 * @Version 1.0
 * @github github.com/love390
 * @gitee gitee.com/cgggitee/
 */
public class KuaiShou2_2 {
    private int[] w;
    private int[] l;
    private boolean isVisited[];
    private int rest;
    private int rs;

    class Data {
        int w;
        int l;

        public Data(int w, int l) {
            this.w = w;
            this.l = l;
        }

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }

        public int getL() {
            return l;
        }

        public void setL(int l) {
            this.l = l;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "w=" + w +
                    ", l=" + l +
                    '}';
        }
    }

    public int compute(int[] w, int[] l) {
        this.w = w;
        this.l = l;
        this.isVisited = new boolean[w.length];
//        find(-1, 0);
        Data[] data = new Data[w.length];
        for (int i = 0; i < w.length; i++) data[i] = new Data(w[i], l[i]);
        Arrays.sort(data, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if (o1.getW() >= o2.getW() && o1.getL() >= o2.getL()) return 1;
                else return -1;
            }
        });

        System.out.println(Arrays.toString(data));

        return rs;
    }

    private void find(int pre, int deep) {

//        Arrays.so

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
        KuaiShou2_2 main1 = new KuaiShou2_2();
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
            System.out.println(main1.compute(w, l));
        }
        scanner.close();
    }
}
