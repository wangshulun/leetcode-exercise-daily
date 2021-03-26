package com.allen.structure;

/**
 * Definition for singly-linked list.
 *
 * @author wangshulun
 * @date 2021/3/26
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
