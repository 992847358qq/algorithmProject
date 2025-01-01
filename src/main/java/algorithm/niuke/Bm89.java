package algorithm.niuke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @description: 合并区间
 * @author: gaoliang.wang
 * @date: 2022/5/3 9:13 PM
 **/
public class Bm89 {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        ArrayList<Interval> result = new ArrayList<>();
        boolean first = true;
        for (Interval interval:intervals){
            if (first){
                result.add(interval);
                first = false;
            }
            Interval perv = result.get(result.size()-1);
            //判断当前是否与前一个有交集
            if (interval.start<=perv.end){
                if (interval.end>= perv.end){
                    perv.end = interval.end;
                }
            }else {
                result.add(interval);
            }
        }
        return result;
    }

     public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
}
