/**
 * @author zr
 * @create 2021-03-18-20:37
 */

import org.junit.jupiter.api.Test;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针random指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结点。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */

public class JZ26 {

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead==null)
            return null;

        RandomListNode cur= pHead;

        //1.复制next部分
        while (cur!=null){
            RandomListNode clone = new RandomListNode(cur.label);

            //新生成的接到cur后面
            clone.next = cur.next;
            cur.next = clone;

            cur= clone.next;//遍历
        }

        //2.复制random部分
        cur= pHead;
        while (cur!=null){
            cur.next.random =  cur.random==null?null:cur.random.next;
            cur = cur.next.next;
        }


        //3.拆分链
        cur = pHead;
        RandomListNode cloneHead = pHead.next;//克隆链的头

        while(cur!=null){//链表关系是本来就连接起来的  现在只需把他剪短重新连接
            RandomListNode node = cur.next;//node是偶数
            cur.next = node.next;//node.text可能是空的

            if(cur.next==null){//node后面没有节点了
                break;
            }

            node.next = cur.next.next;
            cur = cur.next;
        }


        return cloneHead;
    }

    @Test
    public void test() {

    }
}
