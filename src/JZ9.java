/**
 * @author zr
 * @create 2021-04-03-21:11
 */

import org.junit.jupiter.api.Test;

/**
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 输入
 * 3
 *
 * 返回值
 *
 * 4
 *
 如果上一步跳 1 步到达第 n 个台阶，说明上一步在第 n-1 个台阶。已知跳到第n-1个台阶的方法数为f[n-1]

 如果上一步跳 2 步到达第 n 个台阶，说明上一步在第 n-2 个台阶。已知跳到第n-2个台阶的方法数为f[n-2]

 。。。

 如果上一步跳 n 步到达第 n 个台阶，说明上一步在第 0 个台阶。已知跳到 第0个台阶的方法数为f[0]

 f(n) = f(n-1) + f(n-2)+ ... f(1)
 f(n-1) = f(n-2) + ... + f(1)

 得
 f(n) = 2f(n-1)

 f(1) = 1
 */
public class JZ9 {
    public int jumpFloorII(int target) {

        return target<=0?0:1<<target-1;
    }

    @Test
    public void test(){
        System.out.println(jumpFloorII(3));
    }
}
