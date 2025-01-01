package algorithm.niuke;

/**
 * @description: 字符串变形
 * @author: gaoliang.wang
 * @date: 2022/5/2 11:06 PM
 **/
public class Bm83 {
    public static void main(String[] args) {
        String str = "This is a sample";
        System.out.println(trans1(str,16));
    }
    public static String trans(String s, int n) {
        // write code here
        String result = "";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n-1; i >=0 ; i--) {
            //判断是否是字母
            if (Character.isLetter(s.charAt(i))){
                //如果为小写转为大写
                if (Character.isLowerCase(s.charAt(i))){
                    stringBuilder.append(String.valueOf(s.charAt(i)).toUpperCase());
                //如果为大写转为小写
                }else {
                    stringBuilder.append(String.valueOf(s.charAt(i)).toLowerCase());
                }
             //为空格
            }else {
               result += stringBuilder.reverse() + " ";
               //清空stringbuilder;
                stringBuilder.delete(0,stringBuilder.length());
            }
        }
        if (stringBuilder.capacity()>0){
            result+=stringBuilder.reverse();
        }
        return result;
    }

    public static String trans1(String s, int n) {
        // write code here
        StringBuilder sb = new StringBuilder();
        String[] s1 = s.split(" ");
        for (int i = s1.length-1; i >=0 ; i--) {
            for (int j = 0; j < s1[i].length(); j++) {
                //如果为小写转为大写
                if (Character.isLowerCase(s1[i].charAt(j))){
                    sb.append(String.valueOf(s1[i].charAt(j)).toUpperCase());
                    //如果为大写转为小写
                }else {
                    sb.append(String.valueOf(s1[i].charAt(j)).toLowerCase());
                }
            }
            //拼接完一个字符串，拼接个空格
            sb.append(" ");
        }
        return sb.substring(0,sb.length()-1);
    }
}
