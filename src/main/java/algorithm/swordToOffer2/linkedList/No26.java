package algorithm.swordToOffer2.linkedList;

/**
 * @description: 重排链表
 * 先找出链表中节点，再把后排节点反转，两个链表拼接
 * @author: gaoliang.wang
 * @date: 2022-02-22
 **/
public class No26 extends CommonLinked {


    public static void reOrderListNode(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast!= null && slow!=null){
            fast = fast.next;
            slow = slow.next;
            if (fast != null){
                fast = fast.next;
            }
        }
        //后排链表起点
        ListNode temp = slow.next;
        link(head,reverseList(temp),dummy);
    }

    private static void link(ListNode node1, ListNode node2, ListNode dummy) {
        ListNode prev = dummy;
        while (node1 != null && node2 != null){
            ListNode temp = node1.next;
            prev.next = node1;
            node1.next = node2;

            prev = node2;
            node1 = temp;
            node2 = node2.next;
        }
        if (node1 != null){
            prev.next = node1;
        }
    }
}
