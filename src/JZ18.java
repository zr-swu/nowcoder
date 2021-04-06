/**
 * @author zr
 * @create 2021-04-06-21:13
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 比如：    源二叉树
 *             8
 *            /  \
 *           6   10
 *          / \  / \
 *         5  7 9 11
 *         镜像二叉树
 *             8
 *            /  \
 *           10   6
 *          / \  / \
 *         11 9 7  5
 */
public class JZ18 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param pRoot TreeNode类
     * @return TreeNode类
     */
    /*//递归
    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if(pRoot==null)
            return null;

        fun(pRoot);

        return pRoot;
    }*/

    public void fun(TreeNode root){
        if(root==null)
            return;

        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;

        if(root.left!=null)
            fun(root.left);
        if(root.right!=null)
            fun(root.right);
    }

    /*//BFS
    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if(pRoot==null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);

        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();

            TreeNode tmp = cur.right;
            cur.right = cur.left;
            cur.left = tmp;

            if(cur.left!=null)
                queue.add(cur.left);
            if(cur.right!=null)
                queue.add(cur.right);
        }

        return pRoot;
    }*/

    //DFS
    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if(pRoot==null)
            return null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(pRoot);

        while (!stack.empty()){
            TreeNode cur = stack.pop();

            TreeNode tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;

            if(cur.left!= null)
                stack.push(cur.left);
            if(cur.right!=null)
                stack.push(cur.right);
        }

        return pRoot;
    }

}
