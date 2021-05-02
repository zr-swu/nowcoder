/**
 * @author zr
 * @create 2021-05-02-17:26
 */

import org.junit.jupiter.api.Test;

/**
 * 题目描述
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，
 * 匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，
 * 但是与"aa.a"和"ab*a"均不匹配
 *
 * 示例1
 * 输入
 * "aaa","a*a"
 * 返回值
 * true
 */
public class JZ52 {
    public boolean match (String str, String pattern) {
        // write code here

        StringBuilder strBuilder = new StringBuilder(str);
        StringBuilder patternBuilder = new StringBuilder(pattern);


        return recursion(strBuilder, patternBuilder, 0, 0);
    }

    public boolean recursion(StringBuilder str,StringBuilder pattern,int strIndex,int patternIndex){
        //把模式遍历完了 字符串还没完
        if(patternIndex>=pattern.length())
            return strIndex>=str.length();

        //下一个模式是*
        if(patternIndex+1<=pattern.length()-1&&pattern.charAt(patternIndex+1)=='*'){
            //当前匹配成功
            if(strIndex<=str.length()-1
                    &&patternIndex<=pattern.length()-1&&((str.charAt(strIndex)==pattern.charAt(patternIndex))
                    ||pattern.charAt(patternIndex)=='.')){
                //要么是字符串后移一位 模式不变(用*)
                //要么是模式后移两位(跳过*) 字符串不变(不用* 直接匹配后面 0次)
                return recursion(str, pattern, strIndex+1, patternIndex) ||
                        recursion(str, pattern, strIndex, patternIndex+2);
            }else{//当前匹配不成功
                //模式后移两位(跳过*) 字符串不变(不用* 直接匹配后面 0次)
                return recursion(str, pattern, strIndex, patternIndex+2);
            }
        }else if(strIndex<=str.length()-1
                &&patternIndex<=pattern.length()-1
                &&((str.charAt(strIndex)==pattern.charAt(patternIndex))
                    ||(pattern.charAt(patternIndex)=='.'))){//下一个不是* 且当前匹配
            //往后面继续匹配
            return recursion(str, pattern, strIndex+1, patternIndex+1);
        }
        return false;
    }


    @Test
    public void test(){
        StringBuilder abc = new StringBuilder("abc");
        System.out.println(match("a", "a."));
        System.out.println(match("aaa","a*a"));
        System.out.println(match("abc","a*c"));
    }
}
