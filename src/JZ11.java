/**
 * @author zr
 * @create 2021-04-05-21:08
 */

import org.junit.jupiter.api.Test;

/**
 *输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 * 
 * 输入
 * 10
 * 
 * 返回值
 * 2
 */
public class JZ11 {
    /*负数会死循环
    public int NumberOf1(int n) {
        int count = 0;
        while (n!=0){
            if((n&1) == 1)
                count++;

            n >>= 1;
        }
        return count;
    }*/

    /*解法一：
    public int NumberOf1(int n) {
        int flag = 1;

        int count = 0;

        while (flag!=0){

            if((n&flag)!=0){
                count++;
            }

            flag <<= 1;
        }

        return count;
    }*/

    public int NumberOf1(int n) {
        int count = 0;

        while(n!=0){
            count++;

            n = n &(n-1) ; //去掉最后一个1
        }

        return count;
    }

    @Test
    public void test(){
        System.out.println(NumberOf1(10));
    }
}
