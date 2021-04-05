/**
 * @author zr
 * @create 2021-04-05-21:59
 */

import org.junit.jupiter.api.Test;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 保证base和exponent不同时为0
 *
 * 输入
 * 2,3
 *
 * 返回值
 * 8.00000
 */
public class JZ12 {
    public double Power(double base, int exponent) {
        if(base==0.0)
            return 0.0;
        if(exponent==0)
            return 1.0;
        if(exponent==1)
            return base;

        boolean isNegative = false;
        if(exponent<0){
            exponent = -exponent;
            isNegative = true;
        }

        double result = Power(base, exponent >> 1);
        result *= result;

        if((exponent&1) ==1 )
            result *= base;

        return isNegative?1.0/result:result;
    }


    @Test
    public void test(){
        System.out.println(Power(2, -3));
    }
}
