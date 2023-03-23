package leetcode;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/6/11 4:14 PM
 **/
public class leet926 {
    //利用 s 只存在 00 和 11 两种数值，我们知道最后的目标序列形如 000...000、000...111 或 111...111 的形式。
    //因此我们可以枚举目标序列的 00 和 11 分割点位置 idxidx（分割点是 00 是 11 都可以，不消耗改变次数）
    //于是问题转换为：分割点 idxidx 左边有多少个 11（目标序列中分割点左边均为 00，因此 11 的个数为左边的改变次数），
    // 分割点 idxidx 的右边有多少个 00（目标序列中分割点右边均为 11，因此 00 的个数为右边的改变次数），两者之和即是分割点为 idxidx 时的总变化次数，所有 idxidx 的总变化次数最小值即是答案。
    //而求解某个点左边或者右边有多少 11 和 00 可通过「前缀和」进行优化
    //00110
    public int minFlipsMonoIncr(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length, ans = n;
        int[] sum = new int[n + 1];
        //生成前缀和，当前位置对应的和
        for (int i = 1; i <= n; i++){
            sum[i] = sum[i - 1] + (cs[i - 1] - '0');
        }
        for (int i = 1; i <= n; i++) {
            //l表示得值即为左边1的个数
            int l = sum[i - 1];
            //n-i表示分割点右边长度，sum[n]-sum[i]表示从i到n的位置有几个1
            //拿右边长度-1的个数就是右边需要转换的0的个数
            int r = (n - i) - (sum[n] - sum[i]);
            //求取最小值
            ans = Math.min(ans, l + r);
        }
        return ans;
    }

    /**
     * 当 1≤i<n 时，考虑下标 i 处的字符。
     * 如果下标 i 处的字符是 0，则只有当下标 i−1 处的字符是 0 时才符合单调递增；如果下标 i 处的字符是 1，
     * 则下标 i−1 处的字符是 0 或 1 都符合单调递增，
     * 此时为了将翻转次数最小化，应分别考虑下标 i−1 处的字符是 0 和 1 的情况下需要的翻转次数，取两者的最小值。
     *
     */
    public int minFlipsMonoIncr1(String s) {
        int n = s.length();
        //取两个值代表字符为0和1的翻转次数
        int dp0 = 0, dp1 = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int dp0New = dp0, dp1New = Math.min(dp0, dp1);
            if (c == '1') {
                //如果字符为1，那么变为0需要翻转次数+1
                dp0New++;
            } else {
                //如果字符为0，那么变为1需要翻转次数+1
                dp1New++;
            }
            dp0 = dp0New;
            dp1 = dp1New;
        }
        return Math.min(dp0, dp1);
    }

    public static void main(String[] args) {
        System.out.println(new leet926().minFlipsMonoIncr("00110"));
    }
}
