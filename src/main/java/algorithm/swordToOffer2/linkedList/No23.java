package algorithm.swordToOffer2.linkedList;

/**
 * @description: 两个链表的第一个重合节
 * 时间复杂度O(m+n)  空间复杂度O(1)
 * @author: gaoliang.wang
 * @date: 2022-02-22
 **/
public class No23 {

    public static void main(String[] args) {

    }

    public static ListNode gerIntersectionListNode(ListNode headA,ListNode headB){
        int countA = countList(headA);
        int countB = countList(headB);
        int diff = Math.abs(countA - countB);
        ListNode longer = countA > countB ?headA:headB;
        ListNode shorter = countA < countB?headA:headB;
        ListNode node1 = longer;
        for (int i = 0; i < diff; i++) {
            node1= node1.next;
        }
        ListNode node2 = shorter;
        while (node1 != node2){
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }

    public static int countList(ListNode head){
        int count = 0;
        while (head != null){
            count++;
            head = head.next;
        }
        return count;
    }
}
