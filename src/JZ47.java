/**
 * @author zr
 * @create 2021-05-02-11:40
 */

import org.junit.jupiter.api.Test;

/**
 * 题目描述
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 示例1
 * 输入
 * 复制
 * 5
 * 返回值
 * 复制
 * 15
 */
public class JZ47 {
    /**
     * 使用&&的短路特性
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {

        int sum = 0;
        sum += n;
        boolean b = n>0&&((sum+=Sum_Solution(n-1))>0);

        return sum;
    }

    @Test
    public void test(){
        System.out.println(Sum_Solution(100));
    }
}
