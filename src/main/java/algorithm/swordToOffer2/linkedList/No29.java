package algorithm.swordToOffer2.linkedList;

/**
 * @description: 排序的循环链表
 * 需要考虑临界值
 * @author: gaoliang.wang
 * @date: 2022-02-24
 **/
public class No29 {


    public static ListNode insertNode(ListNode head,ListNode node){
        if (head == null){
            head = node;
            head.next = head;
        }
        if (head.next == null){
            head.next = node;
            node.next = head;
        }
        insert(head,node);
        return head;
    }

    public static void insert(ListNode head, ListNode node) {
        ListNode cur = head;
        ListNode next = head.next;
        ListNode biggest = head;
        while (!(cur.val <= node.val && next.val >= node.val) && next != head){
            cur = next;
            next = next.next;
            if (cur.val >= biggest.val){
                biggest = cur;
            }
        }
        if (cur.val <= node.val && next.val>= node.val){
            cur.next = node;
            node.next = next;
        }else {
            node.next = biggest.next;
            biggest.next = node;
        }
    }
}
