/**
 * @author zr
 * @create 2021-04-22-20:23
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 *  题目描述
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 *
 * 示例1
 * 输入
 * {1,2,3,4,5,#,6,#,#,7}
 * 返回值
 * 4
 */
public class JZ38 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }



    /*public int TreeDepth(TreeNode root) {

        if(root==null)
            return 0;

        return Math.max(TreeDepth(root.left),TreeDepth(root.right))+1;
    }*/

    public int TreeDepth(TreeNode root){
        if (root==null)
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
