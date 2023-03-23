package algorithm.swordToOffer2.linkedList;

import static algorithm.swordToOffer2.linkedList.CommonLinked.reverseList;

/**
 * @description: 链表中的数字相加
 * 先把两个链表反转做加和，求出和链表，再把和链表反转，就是所要求的的链表的和
 * @author: gaoliang.wang
 * @date: 2022-02-22
 **/
public class No25 {
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
            if(fast.next != null){
                fast = fast.next;
            }
        }
        ListNode temp = slow.next;
        slow.next = null;
        link(head,reverseList(temp),dummy);
    }

    private void link(ListNode node1, ListNode node2, ListNode head) {
        ListNode pre = head;
        while (node1 != null && node2 != null){
            ListNode temp = node1.next;
            pre.next = node1;
            node1.next = node2;
            pre = node2;
            node2 = node2.next;
            node1 = temp;
        }

        if (node1 != null){
            pre.next = node1;
        }
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);

        ListNode node2 = new ListNode(4);
        node2.next = new ListNode(5);
        node2.next.next = new ListNode(6);
        ListNode head = new ListNode(0);

        new No25().link(node1,node2,head);
    }
}
