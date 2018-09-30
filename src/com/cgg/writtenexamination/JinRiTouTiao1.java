package com.cgg.writtenexamination;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author cgg 891842749@qq.com
 * @Date 2018-09-20 19:02:23
 * @Description gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class JinRiTouTiao1 {
    public String compute(String[] datas) {
        LinkedList<String> strings = new LinkedList<>();
        strings.push("/");
        for (String data : datas) {
            if (data.equals(".")) continue;
            if (data.equals("..")) {
                strings.pop();
                continue;
            }
            strings.push(data);
        }
        String rs = "";
        while (strings.size() > 0) {
            rs = rs + "/" + strings.getLast();
            strings.removeLast();
        }
        return rs.replaceAll("/+","/");
    }

    public static void main(String[] args) {
        JinRiTouTiao1 JinRiTouTiao1 = new JinRiTouTiao1();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            if (data.startsWith("/")) data = data.substring(1, data.length());
            if (data.endsWith("/")) data = data.substring(0, data.length() - 1);
            String[] datas = data.split("/+");
            for (String s : datas) System.out.println(s);
            System.out.println(JinRiTouTiao1.compute(datas));
        }
        scanner.close();
    }
}
