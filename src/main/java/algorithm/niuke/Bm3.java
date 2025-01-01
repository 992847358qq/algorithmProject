package algorithm.niuke;

import algorithm.swordToOffer2.linkedList.ListNode;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/6/25 12:57 PM
 **/
public class Bm3 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ListNode node = new Bm3().reverseKGroup(node1, 2);
        System.out.println(node.val);
    }

    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        //获取第k个元素
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int c = k;
        while(dummy != null && c>0){
            dummy = dummy.next;
            c--;
        }
        if (c >0 || dummy == null){
            return head;
        }
        //保存下一次循环头结点
        ListNode right = dummy.next;
        dummy.next = null;
        ListNode node = reverseNode(head);
        head.next = reverseKGroup(right,k);
        return node;
    }

    public ListNode reverseNode(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
