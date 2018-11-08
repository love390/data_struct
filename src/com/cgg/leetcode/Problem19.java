package com.cgg.leetcode;

import java.util.Stack;

/**
 * @author cgg cgg244@qq.com
 * @data 18-11-8 下午4:12
 * gitee:www.gitee.com/cgggitee/
 * github:https://github.com/love390/
 */
public class Problem19 {


    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * <p>
     * 示例：
     * <p>
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * <p>
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     * <p>
     * 给定的 n 保证是有效的。
     * <p>
     * 进阶：
     * <p>
     * 你能尝试使用一趟扫描实现吗？
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newListNode = new ListNode(0);
        ListNode tmp = new ListNode(0);
        Stack<ListNode> listNodes = new Stack<>();
        Stack<ListNode> listNodes2 = new Stack<>();
        while (head != null) {
            listNodes.push(head);
            head = head.next;
        }

        while (!listNodes.empty()) {
            tmp = listNodes.pop();
            if (n != 1) {
                tmp.next = null;
                listNodes2.push(tmp);
            }
            n--;
        }

        tmp = newListNode;
        while (!listNodes2.empty()) {
            tmp.next = listNodes2.pop();
            tmp = tmp.next;
        }

        return newListNode.next;
    }

    public static void main(String[] args) {
        Problem19 problem19 = new Problem19();
        ListNode head = new ListNode(1);
        ListNode tmp = new ListNode(2);
        head.next = tmp;

        ListNode tmp1 = new ListNode(3);
        tmp.next = tmp1;
        tmp = tmp.next;

        tmp1 = new ListNode(4);
        tmp.next = tmp1;
        tmp = tmp.next;

        tmp1 = new ListNode(5);
        tmp.next = tmp1;
        tmp = tmp.next;


        head = problem19.removeNthFromEnd(head, 2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}