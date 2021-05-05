/**
 * @author zr
 * @create 2021-05-04-12:10
 */

import java.util.HashMap;

/**
 * 题目描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class JZ55 {

    public HashMap<ListNode,Integer> map = new HashMap<>();

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode iterator = pHead;

        while (iterator!=null){
            //该节点没出现过
            if(map.get(iterator)==null){
                map.put(iterator, 1);
                iterator = iterator.next;
            }else {//该节点已出现过
                return iterator;
            }
        }

        return null;
    }
}
