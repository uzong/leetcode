package com.uzong;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 大数，借助队列实现相加
 */
public class AddTwoNumbers2 {

    /**
     * 官方答案
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum1 = (l1 != null) ? l1.val : 0;
            int sum2 = (l2 != null) ? l2.val : 0;
            int sum = sum1 + sum2 + carry;
            curr.next = new ListNode(sum % 10);
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
            carry = sum / 10;
            curr = curr.next;
        }
        if(carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    @Test
    public void testAddTwoNumbers3() {
        ListNode nodeo9 = buildListNode(new int[]{9});
        ListNode noden9 = buildListNode(new int[]{1,9,9,9,9,9,9,9,9,9});
        ListNode result = addTwoNumbers3(nodeo9,noden9);
        print(result);
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<Integer> queue1 = nodeTransformQueue(l1);
        Queue<Integer> queue2 = nodeTransformQueue(l2);
        Queue<Integer> resultQueue = new LinkedList<>();
        Integer forwardNum = 0;
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            Integer num1 = queue1.isEmpty() ? 0 : queue1.poll();
            Integer num2 = queue2.isEmpty() ? 0 : queue2.poll();
            Integer midNum = num1 + num2 + forwardNum;
            resultQueue.add(midNum % 10);
            forwardNum = midNum / 10;
        }
        //特殊处理最后一位
        if(forwardNum > 0) {
            resultQueue.add(forwardNum);
        }
        return queueTransformNode(resultQueue);
    }

    /**
     * 链表转队列
     * @param listNode
     * @return 队列
     */
    public Queue<Integer> nodeTransformQueue(ListNode listNode) {
        Queue<Integer> queue = new LinkedList<>();
        while (listNode != null) {
            queue.add(listNode.val);
            listNode = listNode.next;
        }
        return queue;
    }

    /**
     * 队列转链表
     * @param queue
     * @return 头节点
     */
    public ListNode  queueTransformNode(Queue<Integer> queue) {
        ListNode head = null;
        ListNode tail = null;
        while (!queue.isEmpty()) {
            Integer val = queue.poll();
            ListNode newNode = new ListNode(val);
            if(head == null) {
                head = tail = newNode;
            }else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    @Test
    public void testAddTwoNumbers() {
        ListNode node243 = buildListNode(new int[]{2,4,3});
        ListNode node708 = buildListNode(new int[]{7,0,8});

        ListNode nodeo9 = buildListNode(new int[]{9});
        ListNode noden9 = buildListNode(new int[]{1,9,9,9,9,9,9,9,9,9});
        ListNode result = addTwoNumbers(node243,node708);
        print(result);
    }
    /**
     * 根据数组尾插入法构建结点。
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
     * 测试原始类型和封装类型
     */
    @Test
    public void testAdd() {
        Integer a = null;
        Integer b = 1;
        System.out.println(a + b); //Exception in thread "main" java.lang.NullPointerException
    }
}
