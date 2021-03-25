import org.junit.jupiter.api.Test;

/**
 * @author zr
 * @create 2021-03-24-20:47
 */



public class NC50 {

    class ListNode {
        int val;
        ListNode next = null;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }


    /**
     *
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        if(head==null)
            return null;

        ListNode iterator = head;
        ListNode next = null;
        ListNode pre = null;
        ListNode partHead = head;
        ListNode partTail = head;
        ListNode reverseHead = null;

        int count = 0;

        ListNode tmp = head;
        int length = 0;
        while (tmp!=null){
            tmp = tmp.next;
            length++;
        }

        ListNode lastTail =null;//用于段与段之间相连
        for(int i=0;i<length/k;i++){

            count = 0;
            if (i==0){
                iterator = head;
            }else {
                iterator = partTail.next;//从上次的结尾的下一个开始遍历
            }

            lastTail = partTail;

            while (iterator!=null){
                if(count==0)
                    partTail = iterator;//翻转后的尾部即为开头一个元素

                count++;//参与此次翻转的节点数

                if(count==k){
                    partHead = iterator;//翻转后的头部即为翻转前尾元素
                    partTail.next = partHead.next;//
                    partHead.next = pre;
                    break;
                }

                next = iterator.next;


                iterator.next = pre;
                pre = iterator;
                iterator = next;
            }

            if(i==0){
                reverseHead = partHead;
            }else {
                lastTail.next = partHead;
            }


        }

        return reverseHead;
    }


    @Test
    public void test1(){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode listNode = reverseKGroup(listNode1, 2);
        System.out.println();
        while (listNode!=null){
            System.out.println(listNode);
            listNode = listNode.next;
        }

    }
}
