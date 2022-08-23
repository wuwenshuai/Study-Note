package com.carrry.link;

import lombok.Data;

/**
 * @author cw3k
 * @version 1.0
 * @description:
 * 链表是一种物理存储非连续，非顺序对的存储结构。数据的逻辑是通过指针链接次序实现的
 * 链表的一些基本操作:插入，删除，替换，反转，操作
 * @date 2022/8/10 14:35
 */

@Data
public class LinkNode {
    public long val;
    public LinkNode next;  // 存null代表最后一个节点
    public LinkNode () {

    }

    public LinkNode(long val) {
        this.val = val;
    }



    public  void printLink() {
       if (this.next == null) {
           return;
       } else {
           // 下个节点不为空，则打印下一个节点数据，并进行下一层递归
           System.out.print(this.next.getVal() + "->");
           this.next.printLink();
       }
    }


    public  void addNode (int data) {
        if (this.next == null) {
            // 当前节点为空，则添加值到新节点
            this.next = new LinkNode(data);
        } else {
            //  递归进入下个对象，直到将值添加到next为空的节点后
            this.next.addNode(data);
        }
    }

    public void deleteNode(int data) {
        if (this.next == null) {
            return;
        }
        if (this.next.getVal() == data) {
            LinkNode newNode = this.next;
            this.next = newNode;
        } else {
            //进入递归
            this.next.deleteNode(data);
        }
    }

    public boolean findNode(int data) {
        if (this.next == null) {
            return false;
        }
        if (this.next.getVal() == data) {
            return true;
        }else {
            return this.next.findNode(data);
        }
    }

    public LinkNode reverseList2 (LinkNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        LinkNode newNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;

    }


    public LinkNode reverseList (LinkNode head) {

        LinkNode prev = null;
        LinkNode curr = head;
        while (curr != null) {
            LinkNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;

    }


}


