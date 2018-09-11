package com.cgg.writtenexamination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-09-09 17:39:56
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem1 {
    /**
     * 输入一个有符号整数，输出该整数的反转值。
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String data = scanner.nextLine().trim();
            if(data.length()<=1 ){
                System.out.println(data);
                continue;
            }
            char[] tmp = data.toCharArray();
            List list = new ArrayList();
            int start = 0;
            if (tmp[0] == '-') {
                start++;
            }
            for (int i = start; i < tmp.length; i++) list.add(tmp[i]);
            for (int i = list.size() - 1; i >= 0; i--) {
                if ((char)list.get(i) !='0') break;
                list.remove(i);
            }
            Collections.reverse(list);

            if (start != 0) System.out.print("-");
            for (Object obj : list) System.out.print(obj);
            System.out.println();
        }
    }
}
