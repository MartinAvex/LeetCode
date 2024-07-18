package com.xavier.common;

public class ListNode {

    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
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
