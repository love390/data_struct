package com.cgg.writtenexamination;

import java.util.Scanner;

/**
 * @Author: cgg
 * @Date: 18-9-29 下午9:12
 * @Version 1.0
 * @github github.com/love390
 * @gitee gitee.com/cgggitee/
 */
public class Problem6 {

    public boolean compute(int[] arrays) {
        try {
            for (int i = 0; i < arrays.length; i++) {
                this.swap(arrays, i, arrays[i + arrays[i]]);
            }
        } catch (Exception e) {
            return true;
        }
        return false;
    }

    private void swap(int[] arrays, int i, int j) {
        int tmp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = tmp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Problem6 d1 = new Problem6();
        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            System.out.println(data);
            data = data.substring(0, data.length());
            System.out.println(data);
//            String[] s = data.split(",");
//            int[] arrays = new int[s.length];
//            for (int i = 0; i < s.length; i++) arrays[i] = Integer.parseInt(s[i]);
//            System.out.println(Problem5.compute(arrays));
        }
        scanner.close();
    }
}
