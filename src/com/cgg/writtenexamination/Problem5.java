package com.cgg.writtenexamination;

import java.util.Scanner;

/**
 * @Author: cgg
 * @Date: 18-9-29 下午9:12
 * @Version 1.0
 * @github github.com/love390
 * @gitee gitee.com/cgggitee/
 */
public class Problem5 {

    public boolean compute(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 1; i < (a.length() - 1); i++) {
            String tmp1 = a.substring(0, i);
            String tmp2 = a.substring(i, a.length());
            if ((tmp2 + tmp1).equals(b)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Problem5 Problem5 = new Problem5();
        while (scanner.hasNext()) {
            String[] data = scanner.nextLine().trim().split(";");
            System.out.println(Problem5.compute(data[0], data[1]));
        }
        scanner.close();
    }
}
