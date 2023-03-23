package algorithm;


import algorithm.swordToOffer2.linkedList.ListNode;

import java.util.*;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2021/1/5 21:41
 **/
public class Test {
    public static void main(String[] args) {

    }

    public static ListNode getNode(ListNode head){
        ListNode node = head;
        ListNode tail = null;
        while (node != null){
            ListNode next = node.next;
            if (node.child != null){
                ListNode childNode = node.child;
                ListNode tailNode = getNode(childNode);
                node.child = null;
                node.next = childNode;
                childNode.prev = node;
                if (next != null){
                    tailNode.next = next;
                    next.prev = tailNode;
                }
                tail =  tailNode;
            }else {
                tail = node;
            }
            node = next;
        }
        return tail;
    }

}
