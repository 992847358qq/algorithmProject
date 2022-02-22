package algorithm.swordToOffer2.binary_system;

/**
 * @description: 单词长度的最大乘积 计算不包含相同字符的两个字符串长度乘积的最大值
 * @author: gaoliang.wang
 * @date: 2022-02-09
 **/
public class No5 {
    public static void main(String[] args) {
        String[] arr = new String[]{"abcw","foo","fxyz","bar","abcdef"};
        System.out.println(maxLength(arr));
        System.out.println(maxLength1(arr));
        System.out.println(maxLength2(arr));
    }

    //暴力求解
    public static int maxLength(String[] arr){
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                String a = arr[i];
                String b = arr[j];
                boolean flag = true;
                for (int k = 0; k <b.length() ; k++) {
                    if (a.contains(String.valueOf(b.charAt(k)))){
                        flag = false;
                    }
                }
                if (flag){
                    max = Math.max(max,a.length()*b.length());
                }
            }
        }
        return max;
    }

    //如果都为小写字母，那么每个字符串最多都有26个不一样字母，可以先存储每个字符串字母的位置，再做比较
    //整体时间复杂度为O(nk+n的二次方)，数组长度为n，空间复杂度为O(n)
    public static int maxLength1(String[] arr){
        boolean[][] flags = new boolean[arr.length][26];
        //假如arr数组长度为n，字符串平均长度为k，时间复杂度为O(nk)
        for (int i = 0; i < arr.length; i++) {
            for (char c:arr[i].toCharArray()){
                flags[i][c-'a'] = true;
            }
        }
        int result = 0;
        //时间复杂度为O(n的二次方)
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                int k = 0;
                //时间复杂度为O(1)
                for (;k<26;k++){
                    if (flags[i][k] && flags[j][k] ){
                        break;
                    }
                }
                if (k == 26){
                    int prod = arr[i].length() * arr[j].length();
                    result = Math.max(result,prod);
                }
            }
        }
        return result;
    }


    //int整数有32位，每个字符串可能有26个字母，用int二进制来标识字符串位置
    //每个字符串代表一个int值，相于如果为0，代表没有重复的
    public static int maxLength2(String[] arr){
        int[] flags = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (char ch:arr[i].toCharArray()){
                flags[i] |= 1 << (ch-'a');
            }
        }
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                if ((flags[i] & flags[j]) == 0){
                    int prod = arr[i].length() * arr[j].length();
                    result = Math.max(result,prod);
                }
            }
        }
        return result;
    }
}
