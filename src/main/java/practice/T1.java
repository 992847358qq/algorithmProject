package practice;

/**
 * @Author: wgl
 * @Date: 2020/06/23 21:13
 * @Description:
 */
public class T1 {
    public static void main(String[] args) {
        //System.out.println(Runtime.getRuntime().availableProcessors());
        long maxMemory = Runtime.getRuntime().maxMemory();//返回java虚拟机试图使用的最大内存量
        long totalMemory = Runtime.getRuntime().totalMemory();//返回java虚拟机中的内存总量
        System.out.println("-Xmx.MAX_MEMORY = " + maxMemory + "(字节)" +(maxMemory /(double)1024/1024)+"MB");
        System.out.println("-Xms.TOTAL_MEMORY = " + totalMemory + "(字节)" +(totalMemory /(double)1024/1024)+"MB");
    }
}
