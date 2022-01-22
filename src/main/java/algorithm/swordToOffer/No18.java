package algorithm.swordToOffer;

/**
 * @author MR.Wang
 * @dept 删除链表节点，给定一个头节点和指针节点，删除指针节点
 * @description TODO
 * @date 2021/2/2 22:11
 **/
public class No18 {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);

        delete(a,a);
        Node temp = a;
        while (temp != null){
            System.out.println(temp.getData());
            temp =temp.getNext();
        }
    }
    //a-b-c-d
    //删除b 把c赋值到b，然后b指向c的下一个节点
    private static void delete(Node head, Node node) {
        if (node.next != null){
            node.setData(node.getNext().getData());
            node.setNext(node.getNext().getNext());
        }else if (head == node){
            head = null;
        }else {
            while (head.getNext() != node){
                head = head.getNext();
            }
            head.next = null;
        }
    }
}
