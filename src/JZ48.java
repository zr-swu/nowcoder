/**
 * @author zr
 * @create 2021-03-25-21:28
 */

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class JZ48 {

    public int Add(int num1,int num2) {

        while(num2!=0){//进位不为0
            int tmp = num1 ^ num2;//不进位的和
            num2 = (num1 & num2) << 1;//计算进位  两个1相加时才有进位 1&1 左移补0
            num1 = tmp;

            //下一次循环时把本次的 不进位的和+进位
        }

        return num1;
    }
}
