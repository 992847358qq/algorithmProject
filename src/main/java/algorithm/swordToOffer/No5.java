package algorithm.swordToOffer;

/**
 * @author MR.Wang
 * @dept 请实现一个函数，把字符串中的每个空格替换成“%20”
 * @description TODO
 * @date 2021/1/22 23:31
 **/
public class No5 {
    public static void main(String[] args) {
        System.out.println(replaceStr1("hello good evening"));
    }
    public static String replaceStr(String str){
        if (str == null){
            return "字符串为空";
        }
        //记录出现了几个空格
        int count = 0;
        for (int i = 0;i<str.length();i++){
            if (str.charAt(i) == ' '){
                count++;
            }
        }
        //1个空格占一个字符，%20三个字符，所以在原来字符串长度的基础上，再扩大2*count个长度
        char[] len = new char[str.length()+2*count];
        int temp = len.length-1;
        int n = str.length()-1;
        while (n>=0){
            if (str.charAt(n) == ' '){
                len[temp] = '0';
                len[temp-1] = '2';
                len[temp-2] = '%';
                temp-=3;
            }else {
                len[temp] =str.charAt(n);
                temp--;
            }
            n--;
        }
        return new String(len);
    }

    public static String replaceStr1(String str){
        if (str == null){
            return "字符串为空";
        }
        //记录出现了几个空格
        int count = 0;
        for (int i = 0;i<str.length();i++){
            if (str.charAt(i) == ' '){
                count++;
            }
        }
        //1个空格占一个字符，%20三个字符，所以在原来字符串长度的基础上，再扩大2*count个长度
        char[] len = new char[str.length()+2*count];
        int temp = 0;
        int n = 0;
        while (n<str.length()){
            if (str.charAt(n) == ' '){
                len[temp] = '%';
                len[temp+1] = '2';
                len[temp+2] = '0';
                temp+=3;
            }else {
                len[temp] =str.charAt(n);
                temp++;
            }
            n++;
        }
        return new String(len);
    }
}
