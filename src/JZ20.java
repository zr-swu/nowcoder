/**
 * @author zr
 * @create 2021-04-08-21:11
 */

import java.util.Stack;

/**
 *定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class JZ20 {

    public  Stack<Integer> stack1 = new Stack<>();
    public  Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);

        /**
         * stack2中压入当前的最小值
         */
        if(stack2.size()==0||node<=stack2.peek().intValue()){
            stack2.push(node);
        }else
            stack2.push(stack2.peek());
    }

    public void pop() {
        /**
         * 元素个数相同 一同pop即可
         */
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
