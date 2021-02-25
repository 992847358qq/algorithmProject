package algorithm.cartoonAlgorithm.question;

/**
 * @author MR.Wang
 * @dept 删除k个数字后的最小值
 * @description TODO
 * @date 2021/1/16 22:23
 **/
public class Que9 {
    public static void main(String[] args) {
        System.out.println(removeTwo("1593212",3));
        System.out.println(removeTwo("30200",1));
    }

    public static String removeKDights(String nums,int k){
        //记录遍历删除数字的位置,下次再循环的时候，从删除数字的前一位开始
        int index = 0 ;
        for (int i =0;i<k;i++){
            boolean flag = false;
            //从左向右遍历，找到比自己右侧数字大的数字并删除
            for (int j = index;j<nums.length()-1;j++){
                if (nums.charAt(j) >nums.charAt(j+1)){
                    nums = nums.substring(0,j)+nums.substring(j+1,nums.length());
                    flag = true;
                    if (index >0){
                        index = j-1;
                    }
                    break;
                }
            }
            //如果没有找到要删除的数字，删除最后一个
            if (!flag){
                nums = nums.substring(0,nums.length()-1);
            }
            //移除左侧的0;
            nums = removeLeftZero(nums);
            //如果所有都被删除，直接返回0
            if (nums.length() == 0){
                return "0";
            }
        }
        return nums;
    }

    private static String removeLeftZero(String nums) {
        for (int i = 0;i<nums.length()-1;i++){
            if (nums.charAt(i) != 0){
                break;
            }
            nums = nums.substring(1,nums.length());
        }
        return nums;
    }


    public static String removeTwo(String nums,int k){
        //移除k个数字后，还剩下的长度
        int newlength = nums.length()-k;
        //创建一个栈，接收所有数字
        char[] stack = new char[nums.length()];
        int top = 0;
        for (int i = 0;i<nums.length();++i){
            //记录当前元素
            char index = nums.charAt(i);
            while (top>0 && stack[top-1] > index && k>0){
                top-=1;
                k-=1;
            }
            stack[top++] = nums.charAt(i);
        }
        //找到栈中第一个非零数字的位置，以此构建新的整数字符串
        int offset = 0;
        while (offset<newlength && stack[offset] == '0'){
            offset++;
        }
        return offset == newlength?"0":new String(stack,offset,newlength-offset);
    }
}
