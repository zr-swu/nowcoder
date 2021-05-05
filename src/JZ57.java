/**
 * @author zr
 * @create 2021-05-05-12:00
 */

import org.junit.jupiter.api.Test;

/**
 * 题目描述
 * 给定一个二叉树其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的next指针。
 */
public class JZ57 {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    /**
     * 有右子树 下一节点是右子树的最左节点
     * 无右子树  是父节点的左节点  下一节点是父节点
     * 无右子树  是父节点的右节点  下一节点 ： 一直找父节点 直到某个节点是其父节点的左节点 他的父节点就是下一节点
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null)
            return null;

        //有右子树
        if(pNode.right!=null){
            TreeLinkNode right  = pNode.right;
            while (right.left!=null){
                right = right.left;
            }
            return right;
        }

        //无右子树  是父节点的左节点
        if(pNode.next!=null&&pNode.next.left==pNode){
            return pNode.next;
        }

        //无右子树  是父节点的右节点
        if(pNode.next!=null&&pNode.next.right==pNode){
            TreeLinkNode next = pNode.next;
            while (next.next!=null && next.next.right == next){
                //某个节点是父节点的左节点 退出
                next = next.next;
            }
            return next.next;
        }

        return null;

    }

    @Test
    public void test(){
//        {5,4,#,3,#,2},5

    }

}
