package algorithm.swordToOffer2.linkedList;

import static algorithm.swordToOffer2.linkedList.CommonLinked.reverseList;

/**
 * @description: 回文链表
 * 找出后排链表头节点，反转后排链表，与前排链表比较
 * @author: gaoliang.wang
 * @date: 2022-02-24
 **/
public class No27 {


    public  boolean isPlalindromeLinked(ListNode head){
        if (head == null || head.next == null){
            return true;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast.next != null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //如果链表为奇数，slow的下一个节点就是后排链表头节点
        ListNode second = slow.next;
        //如果为偶数
        if (fast.next != null){
            second = slow.next.next;
        }
        slow.next = null;
        return verify(second,reverseList(head));
    }

    private static boolean verify(ListNode second, ListNode first) {
        while (second != null && first != null){
            if (first.val != second.val){
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return first == null && second == null;
    }
}
