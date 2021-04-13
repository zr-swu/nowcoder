/**
 * @author zr
 * @create 2021-04-13-21:54
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 *
 * 示例1
 * 输入
 * "ab"
 *
 * 返回值
 * ["ab","ba"]
 */
public class JZ27 {

    LinkedHashSet<String> set = new LinkedHashSet<>();

    public ArrayList<String> Permutation(String str) {
        StringBuilder builder = new StringBuilder(str);

        fun(builder,0);
        ArrayList<String> result = new ArrayList<>(set);

//        Iterator<String> iterator = set.iterator();
//
//        while (iterator.hasNext())
//            result.add(iterator.next());

        return result;
    }

    public void fun(StringBuilder builder,int pos){
        if(pos == builder.length()-1){
            set.add(builder.toString());
            return;
        }

        // for循环和swap的含义：对于“ABC”，
        // 第一次'A' 与 'A'交换，字符串为"ABC", pos为0， 相当于固定'A'
        // 第二次'A' 与 'B'交换，字符串为"BAC", pos为0， 相当于固定'B'
        // 第三次'A' 与 'C'交换，字符串为"CBA", pos为0， 相当于固定'C'
        for(int i=pos;i<builder.length();i++){
            char tmp = builder.charAt(i);
            builder.setCharAt(i, builder.charAt(pos));
            builder.setCharAt(pos, tmp);

            fun(builder, pos+1);

            tmp = builder.charAt(i);
            builder.setCharAt(i, builder.charAt(pos));
            builder.setCharAt(pos, tmp);
        }
    }



}
