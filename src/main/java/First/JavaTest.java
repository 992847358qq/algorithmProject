package First;

/**
 * @Author: wgl
 * @Date: 2020/05/14 10:46
 * @Description:
 */
public class JavaTest {
    public static void main(String[] args) {
        new JavaTest().test();
        new JavaTest().test1();
    }

    public void test(){
        long start = System.currentTimeMillis();
        int a = 0;
        for(int i=0;i<1000000000;i++){
            try {
                a++;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        long useTime = System.currentTimeMillis()-start;
        System.out.println("useTime:"+useTime);
    }
    public void test1(){
        long start = System.currentTimeMillis();
        int a = 0;
        try {
            for (int i=0;i<1000000000;i++){
                a++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        long useTime = System.currentTimeMillis()-start;
        System.out.println(useTime);
    }
}
