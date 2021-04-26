/**
 * @author zr
 * @create 2021-04-23-20:21
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * 平衡二叉树（Balanced Binary Tree），具有以下性质：
 * 它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 *
 * 示例1
 * 输入
 * {1,2,3,4,5,6,7}
 *
 * 返回值
 * true
 */
public class JZ39 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }


    public boolean IsBalanced_Solution(TreeNode root) {

        if(root==null)
            return true;


        int leftDepth = GetDepth(root.left);
        int rightDepth = GetDepth(root.right);

        if(Math.abs(leftDepth-rightDepth)<=1)
            return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);

        return false;
    }

    /**
     * 求树的深度
     * @param root
     * @return
     */
    public int GetDepth(TreeNode root){

        if(root==null)
            return 0;

        int result = 0;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            while (size!=0){
                TreeNode poll = queue.poll();
                if(poll.left!=null)
                    queue.add(poll.left);
                if(poll.right!=null)
                    queue.add(poll.right);
                size--;
            }
            result++;
        }

        return result;
    }
}
