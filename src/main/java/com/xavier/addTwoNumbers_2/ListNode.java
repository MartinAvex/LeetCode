package com.xavier.addTwoNumbers_2;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }

    @Override
    public String toString() {
        String str = "[" + val;
        while (next != null) {
            str += ", " + next.val;
            next = next.next;
        }
        return str + "]";
    }
}
