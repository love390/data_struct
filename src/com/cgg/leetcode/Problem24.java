package com.cgg.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author cgg cgg244@qq.com
 * @data 18-11-9 下午1:31
 * gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem24 {
    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * <p>
     * 示例:
     * <p>
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     * 说明:
     * <p>
     * 你的算法只能使用常数的额外空间。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        LinkedList<ListNode> listNodes = new LinkedList<>();
        LinkedList<ListNode> listNodes2 = new LinkedList<>();
        int flag = -1;
        while (head != null) {
            flag = -1 * flag;
            if (flag > 0) listNodes.addFirst(head);
            else listNodes.addLast(head);
            head = head.next;
        }

        if (listNodes.size() == 1) return listNodes.pop();

        ListNode last = null;
        ListNode lastP = null;
        if (listNodes.size() % 2 != 0) last = listNodes.pop();
//        System.out.println(Arrays.toString(listNodes.toArray()));

        flag = -1;
        while (!listNodes.isEmpty()) {
            flag = -1 * flag;
            ListNode listNode = null;
            if (flag > 0) {
                listNode = listNodes.getFirst();
                listNode.next = null;
                listNodes2.addFirst(listNode);
                listNodes.removeFirst();
            } else {
                listNode = listNodes.getLast();
                listNode.next = null;
                listNodes2.addFirst(listNode);
                listNodes.removeLast();
            }
        }

//        System.out.println(Arrays.toString(listNodes2.toArray()));

        ListNode newListNode = new ListNode(0);
        ListNode tmp = newListNode;
        while (!listNodes2.isEmpty()) {
            tmp.next = listNodes2.pop();
            tmp = tmp.next;
            if (listNodes2.size() == 0) lastP = tmp;
        }

        if (lastP != null) lastP.next = last;

        return newListNode.next;
    }

    public static void main(String[] args) {
        Problem24 problem24 = new Problem24();
        ListNode head = new ListNode(1);
//        ListNode tmp = new ListNode(2);
//        head.next = tmp;
//
//        ListNode tmp1 = new ListNode(3);
//        tmp.next = tmp1;
//        tmp = tmp.next;
//
//        tmp1 = new ListNode(4);
//        tmp.next = tmp1;
//        tmp = tmp.next;


        head = problem24.swapPairs(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
