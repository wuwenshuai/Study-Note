package com.carrry.link.刷题;


import com.carrry.link.Node.LinkedList;
import com.carrry.link.Node.Node;

/**
 * 反转一个链表
 */
public class ReverseList {


    public static void main(String[] args) {



        LinkedList head = new LinkedList();
        head.addNode(1);
        head.addNode(2);
        head.addNode(3);
      //  head.printLink();


        System.out.println("");
        // 反转链表
        Node prev = null;
        Node next = null;
        Node cur = head.head;
        while (cur != null) {
            // 把当前节点,的后续节点存到next上
            next = cur.next;
            // 把当前节点的netx指针，指向prev
            cur.next = prev;
            //前指针后移动
            prev = cur;
            //当前指针后移
            cur = next;
        }

        // 返回prev
        LinkedList linkedList = new LinkedList(prev);
        linkedList.printList();
    }
}
