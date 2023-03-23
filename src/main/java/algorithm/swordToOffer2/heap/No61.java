package algorithm.swordToOffer2.heap;


import java.util.*;

/**
 * @description: 和最小的k个数对
 * @author: gaoliang.wang
 * @date: 2022/3/5 10:35 PM
 **/
public class No61 {
    //每个数组只取前k个数值就行。因为数组是递增顺序，
    // 第k+1个数值 与另外一个数组中任何一个数字组合都比前k个数值组成的数组大
    //最大堆最多包含k个元素，增删时间复杂度为O(logk).
    //两个for循环的时间复杂度为O(k二次方*logn)
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> maxHeap = new PriorityQueue<>(
                (m1,m2) -> m2[0] + m2[1] - m1[0] - m1[1]
        );
        for (int i = 0; i < Math.min(k,nums1.length); i++) {
            for (int j = 0; j < Math.min(k,nums2.length); j++) {
                if (maxHeap.size()>=k){
                    int[] root = maxHeap.peek();
                    if (root[0] + root[1] > nums1[i] + nums2[j]){
                        maxHeap.poll();
                        maxHeap.offer(new int[]{nums1[i],nums2[j]});
                    }
                }else {
                    maxHeap.offer(new int[]{nums1[i],nums2[j]});
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        while (!maxHeap.isEmpty()){
            int[] arr = maxHeap.poll();
            result.add(Arrays.asList(arr[0],arr[1]));
        }
        return result;
    }

    public static void main(String[] args) {
        String[] str = new String[]{
                "a","b"
        };
        List<String> list = Arrays.asList(str);

        int[] arr = new int[]{1,2,3};
        List<int[]> ints = Arrays.asList(arr);
    }

    //基于最小堆
    //数组1的第一个元素和数组的第一个元素组成的一定是第一个最小元素
    //先打数组1的前k个元素与数组2中的第一个元素组合放入最小堆中
    //再把数组2中的前k个元素与数组1中元素组合放入最小堆中，每次从堆中移除一个元素，一定是k个组合中的其中一个
    //直到k个组合全部组合完成
    public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        Queue<int[]> minHeap = new PriorityQueue<>(
                (m1,m2) -> nums1[m1[0]] + nums2[m1[2]] - nums1[m2[0]] - nums2[m2[1]]
        );
        if (nums2.length>0){
            for (int i = 0; i < Math.min(k,nums1.length); i++) {
                minHeap.offer(new int[]{i,0});
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        while (k-->0 && !minHeap.isEmpty()){
            int[] ids = minHeap.poll();
            result.add(Arrays.asList(nums1[ids[0]],nums2[ids[1]]));
            if (ids[1] < nums2.length){
                minHeap.offer(new int[]{ids[0],ids[1] + 1});
            }
        }
        return result;
    }
}
