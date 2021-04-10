/**
 * @author zr
 * @create 2021-04-10-22:18
 */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class JZ25 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    TreeNode lastTail = null;

    public TreeNode Convert(TreeNode pRootOfTree) {


        doConvert(pRootOfTree);

        System.out.println(lastTail.val);
        while (lastTail!=null){
            if(lastTail.left!=null) {
                lastTail = lastTail.left;
            }else
                break;
        }

        return lastTail;
    }

    /**
     * 递归到叶子  根往左边连  右往根连  用lasttail变量记录已完成的尾节点
     *
     * //左子树转换
     * cur.left = lasttail;
     * lasttail.right = cur;
     * lasttail = cur;
     * //右子树转换
     *
     * @param pRoot
     */
    public void doConvert(TreeNode pRoot){

        if(pRoot == null)
            return ;

        if(pRoot.left!=null)
            doConvert(pRoot.left);

        pRoot.left = lastTail;//lastTail是左子树转换完的尾巴  连接left指针

        if(pRoot.left!=null)
            pRoot.left.right = pRoot;//连接right指针

        lastTail = pRoot;

        if(pRoot.right!=null)
            doConvert(pRoot.right);

    }

    @Test
    public void test(){
        TreeNode _10 = new TreeNode(10);
        TreeNode _6 = new TreeNode(6);
        TreeNode _14 = new TreeNode(14);
        TreeNode _4 = new TreeNode(4);
        TreeNode _8 = new TreeNode(8);
        TreeNode _12 = new TreeNode(12);
        TreeNode _16 = new TreeNode(16);

        _10.left = _6;
        _10.right = _14;
        _6.left = _4;
        _6.right = _8;
        _14.left = _12;
        _14.right = _16;

        TreeNode convert = Convert(_10);

        System.out.println(convert);

        while (convert!=null){
            System.out.println(convert.val+"->");
            convert = convert.right;
        }


    }

}
