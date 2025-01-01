package algorithm.niuke;

/**
 * @description: 大数加法
 * @author: gaoliang.wang
 * @date: 2022/5/3 11:36 AM
 **/
public class Bm86 {

    public static void main(String[] args) {
        String s = "1";
        String t = "99";
        System.out.println(new Bm86().solve(s, t));
    }

    public String solve (String s, String t) {
        // write code here
        if (s == null || s.length() == 0){
            return t;
        }
        if (t == null || t.length() == 0){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int sLen = s.length()-1;
        int tLen = t.length()-1;
        int sum = 0;
        int tail = 0;
        while (sLen>=0 || tLen>=0){
            int sc = 0;
            int tc = 0;
            if (sLen>=0){
                sc = s.charAt(sLen--)-'0';
            }
            if (tLen>=0){
                tc = t.charAt(tLen--)-'0';
            }
            tail = sc+tc+sum>=10?sc+tc+sum-10:sc+tc+sum;
            sum = sc+tc+sum>=10?1:0;
            sb.append(tail);
        }
        if (sum != 0){
            sb.append(sum);
        }
        return sb.reverse().toString();
    }
}
