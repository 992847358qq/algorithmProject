package algorithm.swordToOffer;

/**
 * @author MR.Wang
 * @dept 链表中倒数第k个节点
 * 倒数第k个节点与尾节点之间的距离为k-1
 * 所以定义两个指针，第一个指针先走k-1步，第二个指针开始走
 * 当第一个指针到尾节点时，第二个指针所指向的就是第k个节点
  @description TODO
 * @date 2021/2/12 20:13
 **/
public class No22 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.setNext(node2);node2.setNext(node3);
        node3.setNext(node4);node4.setNext(node5);
        node5.setNext(node6);
        System.out.println(findNodeFromTail(node1,3));
    }
    public static Integer findNodeFromTail(Node node,int k){
        if (node == null){
            return null;
        }
        if (k == 0){
            System.out.println("k应该从1开始");
            return null;
        }
        Node one = node;
        Node two = null;
        for (int i = 0;i<k-1;i++){
            if (one.getNext() == null){
                System.out.println("k不应该大于链表长度");
                return null;
            }
            one = one.getNext();
        }
        two = node;
        while (one.getNext() != null){
            one = one.getNext();
            two = two.getNext();
        }
        return two.getData();
    }

}
