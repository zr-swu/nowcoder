import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author zr
 * @create 2021-03-15-21:47
 */
public class JZ5 {

    /**
     * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.size()==0){//出队栈无元素
            while (stack1.size()!=0){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
