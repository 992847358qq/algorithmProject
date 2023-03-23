package algorithm.swordToOffer2.linkedList;

/**
 * @description: 反转链表
 * @author: gaoliang.wang
 * @date: 2022-02-22
 **/
public class No24 {

    public static void main(String[] args) {


    }

    /**
     * 递归反转  //递归模式 n->k->j  k如果指向n，那么n.next.next = n;
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode newNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    /**
     * 双指针
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }


}
