package algorithm.swordToOffer2.linkedList;

/**
 * @description: 双指针-删除倒数第k个节点
 * @author: gaoliang.wang
 * @date: 2022-02-16
 **/
public class No21 {
    public static void main(String[] args) {

    }

    public static ListNode removeNode(ListNode head,int k){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode front = head;
        ListNode back = dummy;
        for (int i = 0; i < k; i++) {
            front = front.next;
        }
        while (front != null){
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
        return dummy.next;
    }
}
