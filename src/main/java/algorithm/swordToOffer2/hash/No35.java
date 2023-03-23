package algorithm.swordToOffer2.hash;

import java.util.List;

/**
 * @description: 最小时差
 * 转换为分钟，存储在数组里面，一天1440分钟
 * @author: gaoliang.wang
 * @date: 2022-02-25
 **/
public class No35 {

    public int findMinDifference(List<String> times){
        //大于1440说明有时间重复，直接返回0
        if (times.size() > 1440){
            return 0;
        }
        boolean[] minutes = new boolean[1440];
        for (String str:times){
            String[] arr = str.split(":");
            int a = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
            //存在相同时间直接返回0
            if (minutes[a]){
                return 0;
            }
            minutes[a] = true;
        }
        return helper(minutes);

    }

    private int helper(boolean[] minutes) {
        int minDiff = minutes.length-1;
        int prev = -1;
        int first = minutes.length - 1;
        int last = -1;
        for (int i = 0; i < minutes.length; i++) {
            if (minutes[i]){
                if (prev >0){
                    minDiff = Math.min(i - prev,minDiff);
                }
                prev = i;
                first = Math.min(first,i);
                last = Math.max(last,i);
            }
        }
        //最小的时间加上1440等于第二天的时间，减去最大时间得到一个差值
        minDiff = Math.min(first+minutes.length-last,minDiff);
        return minDiff;
    }
}
