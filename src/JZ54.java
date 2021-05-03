/**
 * @author zr
 * @create 2021-05-03-17:57
 */

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 后台会用以下方式调用Insert 和 FirstAppearingOnce 函数
 * string caseout = "";
 * 1.读入测试用例字符串casein
 * 2.如果对应语言有Init()函数的话，执行Init() 函数
 * 3.循环遍历字符串里的每一个字符ch {
 * Insert(ch);
 * caseout += FirstAppearingOnce()
 * }
 * 2. 输出caseout，进行比较。
 * 返回值描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class JZ54 {

    public HashMap<Character,Integer> map = new HashMap<>();

    public Queue<Character> queue = new LinkedList<>();

    //Insert one char from stringstream
    public void Insert(char ch){
        //第一次出现
        if(map.get(ch)==null){
            map.put(ch, 1);
            queue.add(ch);
        }else {
            map.put(ch, map.get(ch)+1);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce(){
        while (!queue.isEmpty()){
            Character peek = queue.peek();
            if(map.get(peek)!=null&&map.get(peek)==1){//第一次出现
                return peek;
            }else {//不是第一次出现
                //出队 永远不可能是第一个只出现一次的
                queue.poll();
            }
        }
        return '#';
    }

    @Test
    public void test(){

    }
}
