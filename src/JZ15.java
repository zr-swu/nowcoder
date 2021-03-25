/**
 * @author zr
 * @create 2021-03-20-20:27
 */
public class JZ15 {

    /**
     * 输入一个链表，反转链表后，输出新链表的表头。
     */

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {

        if(head==null)
            return null;

        ListNode reverseHead = null;
        ListNode middle = head;
        ListNode pre = null;
        ListNode next = head.next;

        while (middle!=null){
            next = middle.next;//先把next保存下来  不然链会断

            if(next == null)
                reverseHead = middle;

            middle.next = pre;//反转

            //middle和pre都后移
            pre = middle;
            middle = next;
        }


        return reverseHead;
    }

}
