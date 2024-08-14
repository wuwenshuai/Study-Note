package com.carrry.link.TwoNode;

public class DoublyLinkedListNode {


    int data;
    DoublyLinkedListNode next;

    DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
