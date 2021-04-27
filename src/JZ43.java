/**
 * @author zr
 * @create 2021-04-27-21:15
 */

/**
 * 题目描述
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
 * 要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 *
 * 示例1
 * 输入
 * "abcXYZdef",3
 * 返回值
 * "XYZdefabc"
 */
public class JZ43 {
    public String LeftRotateString(String str,int n) {

        if(str==null)
            return null;

        if(str.equals(""))
            return "";


        return str.substring(n)+str.substring(0,n);
    }
}
