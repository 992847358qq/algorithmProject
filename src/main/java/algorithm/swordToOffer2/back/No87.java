package algorithm.swordToOffer2.back;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 恢复ip地址
 * @author: gaoliang.wang
 * @date: 2022/3/17 11:37 PM
 **/
public class No87 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result  = new LinkedList<>();
        helper(s,0,0,"","",result);
        return result;
    }

    private void helper(String s, int i, int segi, String seg, String ip, List<String> result) {
        if (i == s.length() && segi == 3 && isValidSeg(seg)){
            result.add(ip+seg);
        }else if (i<s.length() && segi<=3){
            //选择当前字符是否拼接
            char ch = s.charAt(i);
            //满足条件进行拼接
            if (isValidSeg(seg+ch)){
                helper(s,i+1,segi,seg+ch,ip,result);
            }
            //不满足条件开始新的分段数字
            if (seg.length()>0 && segi<3){
                helper(s,i+1,segi+1,""+ch,ip+seg+".",result);
            }

        }
    }

    private boolean isValidSeg(String seg) {
        return Integer.valueOf(seg) <= 255 && (seg.equals("0") || seg.charAt(0) == '0');
    }
}
