package algorithm.swordToOffer2.linkedList;

/**
 * @description: 展平多级双向链表
 * @author: gaoliang.wang
 * @date: 2022-02-24
 **/
public class No28 {

    public static ListNode flatten(ListNode head){
        flattenGetTail(head);
        return head;
    }

    private static ListNode flattenGetTail(ListNode head) {
        ListNode node = head;
        ListNode tail = null;
        while (node != null){
            ListNode next = node.next;
            if (node.child != null){
                ListNode child = node.child;
                ListNode childTail = flattenGetTail(node.child);
                node.child = null;
                node.next = child;
                child.prev = node;
                childTail.next = next;
                if (next != null){
                    next.prev = childTail;
                }
                tail = childTail;
            }else {
                tail = node;
            }
            node = next;
        }
        return  tail;
    }
}
