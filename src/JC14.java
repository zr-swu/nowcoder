/**
 * @author zr
 * @create 2021-03-25-20:36
 */

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 如果该链表长度小于k，请返回空。
 */
public class JC14 {

    public class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        ListNode first = pHead;
        ListNode second = pHead;

        /**
         * first先走k步
         * first剩下可以走的步数等于length-k
         *
         * second走length-k步也就可以到倒序的第k个
         */
        int i=0;
        for(i=0;i<k;i++){
            if(first==null)
                break;
            first = first.next;
        }

        if(i!=k)
            return null;

        while (first!=null){
            first =first.next;
            second = second.next;
        }

        return second;
    }
}
