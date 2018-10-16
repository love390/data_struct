package com.cgg.leetcode;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


/**
 * @author cgg cgg244@qq.com
 * @data 18-10-16 下午6:07
 * gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem2 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode rs = new ListNode(-1);
        ListNode tail = rs;
        while (l1 != null || l2 != null) {
            int val1 = l1!= null ? l1.val : 0;
            int val2 = l2!= null ? l2.val : 0;

            System.out.println(val1 + " " + val2);

            int tmp = val1 + val2 + carry;
            tail = tail.next = new ListNode(tmp % 10);

            carry = tmp / 10;

            l1 = l1== null ? null : l1.next;
            l2 = l2== null ? null : l2.next;

        }
        if (carry != 0) tail.next = new ListNode(carry);
        return rs;
    }

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        int[] arrays1 = new int[]{2, 4, 3};
        int[] arrays2 = new int[]{5, 6, 4};
        ListNode l1 = new ListNode(-1);
        ListNode l2 = new ListNode(-1);

        ListNode tmp = l1;
        for (int i = 0; i < arrays1.length; i++) tmp = tmp.next = new ListNode(arrays1[i]);

//        while (l1 != null) {
//            System.out.print(l1.val + "->");
//            l1 = l1.next;
//        }
//        System.out.println();


        tmp = l2;
        for (int i = 0; i < arrays2.length; i++) tmp = tmp.next = new ListNode(arrays2[i]);
//        while (l2 != null) {
//            System.out.print(l2.val + "->");
//            l2 = l2.next;
//        }

        ListNode rs = problem2.addTwoNumbers(l1.next, l2.next);
        while (rs != null) {
            System.out.print(rs.val + "->");
            rs = rs.next;
        }
    }
}
