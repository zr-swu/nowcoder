/**
 * @author zr
 * @create 2021-05-03-15:33
 */

/**
 * 题目描述
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * 示例1
 * 输入
 * "123.45e+6"
 * 返回值
 * true
 * 示例2
 * 输入
 * "1.2.3"
 * 返回值
 * false
 */
public class JZ53 {
    public boolean isNumeric (String str) {
        // write code here
        String pattern = "^[+-]?\\d*\\.?\\d+([eE][+-]?\\d+)?$";
        return str.matches(pattern);
    }
}

