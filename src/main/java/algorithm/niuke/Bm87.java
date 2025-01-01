package algorithm.niuke;

/**
 * @description: 合并两个有序的数组
 * @author: gaoliang.wang
 * @date: 2022/5/3 7:18 PM
 **/
public class Bm87 {
    public void merge(int A[], int m, int B[], int n) {
        int a = 0;
        int b = 0;
        while(a!=m-1 && b!=n-1){
            while(a!=m-1 && A[a]<B[b]){
                a++;
                continue;
            }
            while ( b!=n-1 && A[a]>B[b]){
                int temp = A[a];
                A[a] = B[b];
                B[b] = temp;
                b++;
            }
        }

    }
}
