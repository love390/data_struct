package com.cgg.writtenexamination;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-09-20 19:32:16
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class JinRiTouTiao3 {
    public String[] compute(char[][] chars, String[] strings) {
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] integers = scanner.nextLine().split("/s+");
            String[] strings = scanner.nextLine().split("/s+");
            char[][] chars = new char[Integer.parseInt(integers[1])][Integer.parseInt(integers[0])];
            int h=Integer.parseInt(integers[1]);
            int i=0,j=0;
            while (i++<h){
                String[] charsTmp= scanner.nextLine().split("/s+");
                for(String s:charsTmp){
//                    chars[i][]
                }
            }
        }
        scanner.close();
    }
}
