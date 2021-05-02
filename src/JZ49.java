/**
 * @author zr
 * @create 2021-05-02-11:51
 */

import org.junit.jupiter.api.Test;

/**
 * 题目描述
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 *
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 返回值描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * 示例1
 * 输入
 * "+2147483647"
 * 返回值
 * 2147483647
 * 示例2
 * 输入
 * "1a33"
 * 返回值
 * 0
 */
public class JZ49 {
    public int StrToInt(String str) {
        int length = str.length();
        StringBuilder builder = new StringBuilder(str);

        int plusOrMinus = 0;//0正1负
        if(length==0 || builder.equals(""))
            return 0;

        int i =1;

        if(!isDigit(builder.charAt(0))&&builder.charAt(0)!='-'&&builder.charAt(0)!='+')
            return 0;
        else if(builder.charAt(0)=='-')
            plusOrMinus = 1;
        else if(isDigit(builder.charAt(0))){
            i=0;
        }

        long ans = 0L;

        while (i<length&&isDigit(builder.charAt(i))){
            ans = ans*10 + (builder.charAt(i)-'0');

            if(plusOrMinus==0&&ans>Integer.MAX_VALUE){
                ans = Integer.MAX_VALUE;
                break;
            }
            if(plusOrMinus==1&&ans>Integer.MAX_VALUE+1L){
                ans = 1L + Integer.MIN_VALUE;
                break;
            }
            i++;
        }

        if (i<length)
            return 0;

        return (int) (plusOrMinus==0?ans:-ans);

    }

    private boolean isDigit(char c){
        return c>='0'&&c<='9';
    }

    @Test
    public void test(){
        System.out.println(StrToInt("-123"));
    }
}
