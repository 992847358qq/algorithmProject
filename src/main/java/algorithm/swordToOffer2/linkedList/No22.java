package algorithm.swordToOffer2.linkedList;

/**
 * @description: 链表中环的入口节点
 * @author: gaoliang.wang
 * @date: 2022-02-16
 **/
public class No22 {
    public static void main(String[] args) {

    }

    //获取环中的一个节点
    public static ListNode getNodeInLoop(ListNode head){
        if (head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = slow.next;
        while (slow !=null && fast != null){
            if (slow == fast){
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != null){
                fast = fast.next;
            }
        }
        return null;
    }

    public static ListNode detectCycle(ListNode head){
        ListNode loopNode = getNodeInLoop(head);
        if (loopNode == null){
            return null;
        }
        //找到相遇节点，然后求出环的长度
        int count = 1;
        for (ListNode n = loopNode;n.next != loopNode;n = n.next){
            count++;
        }
        //先让一个指针跑环的长度
        ListNode fast = head;
        for (int i = 0; i < count; i++) {
            fast = fast.next;
        }
        //再从头部指针一块走，相遇即为环的入口
        ListNode slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static ListNode detectCycle1(ListNode head){
        ListNode loopNode = getNodeInLoop(head);
        if (loopNode == null){
            return null;
        }
        ListNode node = head;
        while (node != loopNode){
            node = node.next;
            loopNode = loopNode.next;
        }
        return node;
    }




}
