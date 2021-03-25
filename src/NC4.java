import java.util.List;

/**
 * @author zr
 * @create 2021-03-24-20:38
 */

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
        val = x;
        next = null;
    }
 }

public class NC4 {

    public boolean hasCycle(ListNode head) {

        if(head==null)
            return false;

        ListNode fast = head;//快指针
        ListNode slow = head;//慢指针

        while (fast!=null&&fast.next!=null&&slow!=null){
            fast = fast.next.next;//走两步
            slow = slow.next;//走一步

            if(fast==slow)
                return true;
        }

        return false;

    }
}
