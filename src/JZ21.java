/**
 * @author zr
 * @create 2021-04-08-21:28
 */

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 题目描述
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 *
 * 示例1
 * 输入
 * [1,2,3,4,5],[4,3,5,1,2]
 *
 * 返回值
 * false
 */


public class JZ21 {
    /**
     * 思路：
     * 如果下一个要出栈的在栈顶 则可以弹出 否则一直压栈 直到压到要出栈这个数
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {

        if(pushA.length == 0 || popA.length == 0)
            return false;

        Stack<Integer> stack = new Stack<>();

        int pushFlag = 0;
        int popFlag = 0;

        for(int i=0;i<popA.length;i++){

            if(stack.empty()&&pushFlag<pushA.length)//栈空的时候直接压入一个
                stack.push(pushA[pushFlag++]);

            while (stack.peek() != popA[i]) {//一直压栈 直到压到要出栈这个数
                if (pushFlag < pushA.length)
                    stack.push(pushA[pushFlag++]);
            }

            if(stack.peek() == popA[i]){
                stack.pop();
                popFlag++;
            }

            if(pushFlag>=pushA.length)//全部入过栈了
                break;
        }

        if(popFlag==popA.length)//全都出栈成功了
           return true;

        return false;
    }

    @Test
    public void test(){
        int a[] = {1,2,3,4,5};
        int b[] = {3,2,5,1,4};

        System.out.println(IsPopOrder(a, b));
    }

}
