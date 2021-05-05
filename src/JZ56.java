/**
 * @author zr
 * @create 2021-05-04-12:22
 */

import org.junit.jupiter.api.Test;

/**
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * 示例1
 * 输入
 * {1,2,3,3,4,4,5}
 * 返回值
 * {1,2,5}
 */
public class JZ56 {

     public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {

        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = pHead;
        ListNode last = head;
        ListNode it = head.next;

         while (it!=null){
            if(it.next!=null && it.next.val == it.val){
               //将it移动到重复的末尾
                while (it.next != null && it.val == it.next.val) {
                    it = it.next;
                }
                it = it.next;

                last.next = it;
            } else {
                last = it;
                it = it.next;
            }
         }

         return head.next;
    }

    @Test
    public void test(){
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(5);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode head = deleteDuplication(listNode);

        ListNode it = head;
        while (it!=null){
            System.out.println(it.val);
            it = it.next;
        }
    }
}
