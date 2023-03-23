package algorithm.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/7/25 9:42 PM
 **/
public class HJ14 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < num; i++) {
            priorityQueue.add(br.readLine());
        }

        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
    }
}
