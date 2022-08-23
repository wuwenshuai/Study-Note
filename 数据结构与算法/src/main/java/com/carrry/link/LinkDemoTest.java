package com.carrry.link;

/**
 * @author cw3k
 * @version 1.0
 * @description: TODO
 * @date 2022/8/10 15:03
 */
public class LinkDemoTest {

    public static void main(String[] args) {


        LinkNode linkNode = new LinkNode();
        linkNode.addNode(1);
        linkNode.addNode(0);
        linkNode.addNode(68);
        linkNode.addNode(26);
        linkNode.addNode(69);

        LinkNode linkNode1 = linkNode.reverseList2(linkNode);
        linkNode1.printLink();
    }
}
