package algorithm.swordToOffer2.string;

/**
 * @description: 不含重复字符的最长子字符串
 * @author: gaoliang.wang
 * @date: 2022-02-13
 **/
public class No16 {
    public static void main(String[] args) {
        String str = "babcca";
        System.out.println(maxStringLength(str));
    }

    public static int maxStringLength(String str){
        if (str.length() == 0){
            return 0;
        }
        int i = 0;
        int j = -1;
        int maxLength = 1;
        int[] nums = new int[256];
        for (; i < str.length(); i++) {
            nums[str.charAt(i)]++;
            while (haveRepetition(nums)){
                j++;
                nums[str.charAt(j)]--;
            }
            maxLength = Math.max(maxLength,i-j);
        }
        return maxLength;
    }

    public static boolean haveRepetition(int[] nums){
        for (int num:nums){
            if (num>1){
                return true;
            }
        }
        return false;
    }

    public static int maxStringLength1(String str){
        if (str.length() == 0){
            return 0;
        }
        int i = 0;
        int j = -1;
        int maxLength = 1;
        int[] nums = new int[256];
        int count = 0;
        for (; i < str.length(); i++) {
            nums[str.charAt(i)]++;
            if (nums[str.charAt(i)] == 2){
                count++;
            }
            while (count>1){
                j++;
                nums[str.charAt(j)]--;
                if (nums[str.charAt(j)] == 1){
                    count--;
                }
            }
            maxLength = Math.max(maxLength,i-j);
        }
        return maxLength;
    }

}
