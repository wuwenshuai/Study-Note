package com.carrry.link.TwoNode;

public class DoublyLinkedList {
    private DoublyLinkedListNode head;
    private DoublyLinkedListNode tail;


    public DoublyLinkedList() {
        head = null;
        tail = null;
    }


    // 添加节点到链表末尾
    public void add(int data) {

        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

        //判断是否是头结点
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }


    // 删除指定数据的节点
    public boolean remove(int data) {
        if (head == null) {
            return false;
        }
        // 定义一个当前节点，指向head
        DoublyLinkedListNode curr = head;
        while (curr != null) {
            if (curr.data == data) {
                //区分是不是头节点
                if (curr.prev == null) {
                    head = curr.next;
                } else {
                    // 不是头节点
                    curr.prev.next = curr.next;
                }

                // 判断curr的尾结点是不是尾结点
                if (curr.next == null) {
                    tail = curr.prev;
                } else {
                    curr.next.prev = curr.prev;
                }

                return true;
            } else {
                curr = curr.next;
            }


        }
        return false;
    }

    // 修改指定数据的节点
    public boolean update(int oldData, int newData) {
        DoublyLinkedListNode current = head;
        while (current != null) {
            if (current.data == oldData) {
                current.data = newData;
                return true;
            }
            current = current.next;
        }
        return false;
    }


    // 查找指定数据的节点
    public DoublyLinkedListNode find(int data) {
        DoublyLinkedListNode current = head;
        while (current != null) {
            if (current.data == data) {
                return current;
            }
            current = current.next;
        }
        return null;
    }



    // 打印链表
    public void printList() {
        DoublyLinkedListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }


    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();
        list.add(1);
        list.add(12);
        list.add(1);
        list.add(31);

        list.printList();
        list.remove(12);
        list.printList();
        list.update(31,33);
        list.printList();
    }
}
