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
        Long result = nodeTransformNum(l1) + nodeTransformNum(l2);
        return numTransformNode(result);
    }

    public Long nodeTransformNum(ListNode node) {
        Long resultNum = 0L;
        Long digit = 1L;
        while(node != null) {
            resultNum = resultNum + digit * node.val;
            digit = digit * 10L;
            node = node.next;
        }
        return resultNum;
    }

    /**
     * 使用尾插法将数字转换成链表。特殊处理num=0
     * @param num 数字
     * @return 头结点
     */
    public ListNode numTransformNode(Long num) {
        if(num == 0) {
            return new ListNode(0);
        }
        ListNode head = null;
        ListNode tail = null;
        int remainder = 0;
        while(num > 0) {
            remainder = (int) (num % 10);
            ListNode current = new ListNode(remainder);
            if(head == null) {
                head = tail = current;
            }else {
                tail.next = current;
                tail = current;
            }
            num = num / 10;
        }
        return head;
    }

    /**
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */
    @Test
    public void testAddTwoNumbers() {
        ListNode node243 = buildListNode(new int[]{2,4,3});
        ListNode node708 = buildListNode(new int[]{7,0,8});

        ListNode nodeo9 = buildListNode(new int[]{9});
        ListNode noden9 = buildListNode(new int[]{1,9,9,9,9,9,9,9,9,9});

        ListNode result = addTwoNumbers(nodeo9,noden9);
        print(result);
    }

    /**
     * 打印
     * @param node 头结点
     */
    public void print(ListNode node) {
        while(node != null) {
            System.out.print(node.val + " ");
            node =  node.next;
        }
    }

    /**
     * 根据数组未插入法构建结点。
     * @param nums 数组
     * @return 头结点
     */
    public ListNode buildListNode(int[] nums) {
        ListNode head = null;
        ListNode tail = null;
        for(int i = 0; i < nums.length; i++) {
            ListNode current = new ListNode(nums[i]);
            if(head == null) {
                head = tail = current;
            } else {
                tail.next = current;
                tail = current;
            }
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public void add() {
        int a = 9;
        Long b = 9999999991L;
    }
}