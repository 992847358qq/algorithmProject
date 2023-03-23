package algorithm.niuke;

/**
 * @description: 验证IP地址
 * @author: gaoliang.wang
 * @date: 2022/5/3 12:17 AM
 **/
public class Bm85 {

    public static void main(String[] args) {
        Bm85 bm85 = new Bm85();
        String ip = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        System.out.println(bm85.solve(ip));
    }

    public String solve (String IP) {
        // write code here
        if(IP == null ){
            return "Neither";
        }
        if(IP.contains(".")){
            return ipv4Solve(IP);
        }
        if(IP.contains(":")){
            return ipv6Solve(IP);
        }
        return IP;
    }

    private String ipv6Solve(String ip) {
        String[] arrs = ip.split(":",-1);
        if (arrs.length!=8){
            return "Neither";
        }
        for (String str:arrs){
            //每组最大长度为4,且不能为空
            if (str.length()>4 || str.length() == 0){
                return "Neither";
            }
            //不能出现a-fA-F以外的大小写字符
            for(int j = 0; j < str.length(); j++){
                //不能出现a-fA-F以外的大小写字符
                char c = str.charAt(j);
                boolean expr = (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F') ;
                if(!expr){
                    return "Neither";
                }
            }

        }
        return "IPv6";
    }

    private String ipv4Solve(String ip) {
        String[] arrs = ip.split("\\.");
        //如果长度小于3，不合法
        if (arrs.length!=4){
            return "Neither";
        }
        for (String str:arrs){
            //如果数字多位，且零开头，不合法
            if (str.length() == 0){
                return "Neither";
            }
            if (str.length() >1 && str.startsWith("0")){
                return "Neither";
            }
            //判断是否都为数字
            for (int i = 0; i < str.length(); i++) {
                if (!Character.isDigit(str.charAt(i))){
                    return "Neither";
                }
            }
            Integer num = Integer.parseInt(str);
            if (num <0 || num>255){
                return "Neither";
            }
        }
        return "IPv4";
    }
}
