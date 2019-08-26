package com.uzong;

import org.junit.Test;

/**
 * @author uzong
 * @Desc 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int result = nodeTransformNum(l1) + nodeTransformNum(l2);
        return numTransformNode(result);
    }

    public int nodeTransformNum(ListNode node) {
        int resultNum = 0;
        int digit = 1;
        while (node != null) {
            resultNum = resultNum + digit * node.val;
            digit = digit * 10;
            node = node.next;
        }
        return resultNum;
    }

    public ListNode numTransformNode(int num) {
        ListNode node = null;
        int remainder = 0;
        while(num > 0) {
            remainder = num % 10;
            ListNode newNode = new ListNode(remainder);
            if(node == null) {
                node = newNode;
            } else {
                node.next = newNode;
            }
            node = node.next;
            num = num / 10;
        }
        return node;
    }

    /**
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */
    @Test
    public void testAddTwoNumbers() {
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node41 = new ListNode(4);
        ListNode node7 = new ListNode(7);
        ListNode node0 = new ListNode(0);
        ListNode node8 = new ListNode(8);
        // (2 -> 4 -> 3)
        node2.next = node4;
        node4.next = node3;
        // (5 -> 6 -> 4)
        node5.next = node6;
        node6.next = node41;
        // 7 -> 0 -> 8
        node7.next = node0;
        node0.next = node8;

        ListNode result = addTwoNumbers(node2,node5);

        print(result);
    }

    public void print(ListNode node) {
        while(node != null) {
            System.out.print(node.val + " ");
            node =  node.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}