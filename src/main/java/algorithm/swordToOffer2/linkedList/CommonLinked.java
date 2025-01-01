package algorithm.swordToOffer2.linkedList;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022-02-24
 **/
public class CommonLinked {
    public static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
