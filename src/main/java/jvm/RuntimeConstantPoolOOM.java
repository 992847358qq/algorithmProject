package jvm;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2020/7/5 11:56
 **/
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        /*String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);*/

        String str2 = new StringBuilder("ja").append("va").toString();
        //System.out.println(str2.intern());
        //System.out.println(str2.intern() == str2);

        String str3 ="java";
        String str4 = "ja"+"va";
        System.out.println(str2 == str3);
    }
}
