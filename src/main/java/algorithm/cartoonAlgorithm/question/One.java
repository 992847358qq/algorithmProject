package algorithm.cartoonAlgorithm.question;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2021/1/11 22:55
 **/
public class One {
    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(7);
        Node node4 = new Node(2);
        Node node5 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;
        System.out.println(isCycle(node1));
    }
    public static boolean isCycle(Node head){
        Node n1 = head;
        Node n2 = head;
        boolean index = true;
        int count = 0;
        while (index && n2 != null && n2.next != null){
            n1 = n1.next;
            n2 = n2.next.next;
            if (n1 == n2){
                //从第一次见面开始继续循环，n2比n1多循环一圈，两人再次相遇，循环的次数就是环长
                while (n2 != null && n2.next != null){
                    n1 = n1.next;
                    n2 = n2.next.next;
                    count++;
                    if (n1 == n2){
                        index = false;
                        System.out.println("环长为："+count);
                        break;
                    }
                }
                return true;
            }
        }
        return false;
    }
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
}
