/**
 * @author zr
 * @create 2021-04-20-21:51
 */

import java.util.HashMap;

/**
 * 题目描述
 * 输入两个链表，找出它们的第一个公共结点。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class JZ36 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 由于公共节点之后next一直相同
     * 所以公共节点意味着公共尾部
     * @param pHead1
     * @param pHead2
     * @return
     */

    /*//使用辅助空间
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode result = null;

        HashMap<Integer, Integer> hashMap1 = new HashMap<>();

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while (p1!=null){
            if(hashMap1.get(p1.val) == null)
                hashMap1.put(p1.val, 1);
            else
                hashMap1.put(p1.val, hashMap1.get(p1.val)+1);

            p1 = p1.next;
        }

        while (p2!=null){
            if(hashMap1.get(p2.val)!=null){
                result = p2;
                break;
            }
            p2 = p2.next;
        }
        return result;
    }*/
}
