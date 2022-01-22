package algorithm.swordToOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author MR.Wang
 * @dept 两个队列实现栈
 * @description TODO
 * @date 2021/1/26 22:47
 **/
public class No9_1 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue1 = new LinkedList<>();
        addNum(queue,queue1,1);
        addNum(queue,queue1,2);
        addNum(queue,queue1,3);
        addNum(queue,queue1,4);
        deleteNum(queue,queue1);
        addNum(queue,queue1,5);
        deleteNum(queue,queue1);
        addNum(queue,queue1,6);
        deleteNum(queue,queue1);
        deleteNum(queue,queue1);
    }

    private static void deleteNum(Queue<Integer> queue, Queue<Integer> queue1) {
        if (queue.size() == 0 && queue1.size() == 0){
            System.out.println("栈已经为空");
        }
        Integer num = 0;
        if (queue.size()!= 0){
            while (queue.size()>0){
                 num = queue.poll();
                if (queue.size()!= 0){
                    queue1.add(num);
                }
            }
        }else {
            while (queue1.size()>0){
                num = queue1.poll();
                if (queue1.size()!= 0){
                    queue.add(num);
                }
            }
        }
        System.out.println(num);
    }

    private static void addNum(Queue<Integer> queue, Queue<Integer> queue1, int num) {
        if (queue.size() != 0){
            queue.add(num);
        }else {
            queue1.add(num);
        }
    }
}
