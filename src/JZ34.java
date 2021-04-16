/**
 * @author zr
 * @create 2021-04-16-21:18
 */

import java.util.HashMap;

/**
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 *
 * 示例1
 * 输入
 * "google"
 *
 * 返回值
 * 4
 */
public class JZ34 {
    public int FirstNotRepeatingChar(String str) {

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i<str.length();i++){
            if(map.get(str.charAt(i))==null)
                map.put(str.charAt(i), 1);
            else
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
        }

        for(int i=0;i<str.length();i++){
            if(map.get(str.charAt(i))==1)
                return i;
        }

        return -1;

    }
}
