package algorithm.swordToOffer2.binary_search;

/**
 * @description: 求平方根
 * @author: gaoliang.wang
 * @date: 2022/3/10 9:23 PM
 **/
public class No72 {
//    public int mySqrt(int x) {
//        int left = 1;
//        int right = x;
//        while (left<=right){
//            int mid = left + (right-left)/2;
//            //18的平方根=4;
//            if (mid <= x/mid){
//                if ((mid+1)>x/(mid+1)){
//                    return mid;
//                }
//                left = mid+1;
//            }else {
//                right = mid-1;
//            }
//        }
//        return 0;
//    }

    public static void main(String[] args) {
        System.out.println(new No72().mySqrt(18));
    }

    int mySqrt(int x) {
        /* 查找区间为 [1, x / 2 + 2) */
        int left = 1, right = x / 2 + 2;
        /* 循环不变量，查找区间始终是左闭右开 */
        while (left < right) {
            /* 防止出现整型溢出的风险 */
            int mid = left + ((right - left) >> 1);
            if (mid > x / mid) {
                right = mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return right - 1;
    }
}
