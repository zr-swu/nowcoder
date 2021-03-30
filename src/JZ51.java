/**
 * @author zr
 * @create 2021-03-30-22:40
 */

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 * 对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
 */

/**
 * 输入
 * [1,2,3,4,5]
 *
 * 返回值
 * [120,60,40,30,24]
 */


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * left[i] = A[0]*...A[i-1]
 * right[i] = A[i+1]*...A[n-1]
 *
 * left[i+1] = A[0]*...A[i]
 * right[i+1] = A[i+2]*...A[n-1]
 *
 * left[i+1] = left[i] * A[i]
 * right[i] = right[i+1] * A[i+1]
 */
public class JZ51 {

    public int[] multiply(int[] A) {
        int B[] = new int[A.length];
        B[0] = 1;

        for(int i=1;i<A.length;i++){
            B[i] = B[i-1]*A[i-1];
        }

        int tmp =1 ;
        for(int j=A.length-2;j>=0;j--){
            tmp *= A[j+1];//前面的right比后面的right多乘一个i+1
            B[j] *= tmp;
        }

        return B;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(multiply(new int[]{1, 2, 3, 4, 5})));
    }
}
