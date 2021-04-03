/**
 * @author zr
 * @create 2021-04-03-21:38
 */

import org.junit.jupiter.api.Test;

/**
 *我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * n个的覆盖法：
 * n-1的所有情况下竖着再放一个
 * n-2的所有情况下横着放两个
 * f(n) = f(n-1) + f(n-2)
 *
 */
public class JZ10 {

    public int rectCover(int target) {

        if(target<3)
            return target;

        int p1 = 1;
        int p2 = 2;
        int p3 = 0;

        for(int i=3;i<=target;i++){
            p3 = p1 + p2;
            p1 = p2;
            p2 = p3;
        }

        return p3;
    }

    @Test
    public void test(){
        System.out.println(rectCover(4));
    }
}
