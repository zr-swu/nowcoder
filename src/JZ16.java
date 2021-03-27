/**
 * @author zr
 * @create 2021-03-27-21:28
 */

import com.sun.scenario.effect.Merge;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class JZ16 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public static ListNode Merge(ListNode list1, ListNode list2) {
        ListNode curNode = new ListNode(0);
        ListNode head = curNode;
        while(list1!=null&&list2!=null){
            if(list1.val<= list2.val){
                curNode.next = list1;
                list1 = list1.next;
            }else {
                curNode.next = list2;
                list2 = list2.next;
            }
            curNode = curNode.next;
        }

        if(list1!=null)
            curNode.next = list1;

        if(list2!=null)
            curNode.next = list2;

        return head.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        ListNode merge = Merge(list1, list2);
        System.out.println("开始");


        while (merge!=null){
            System.out.println(merge.val);
            merge = merge.next;
        }
    }

}
