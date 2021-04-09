/**
 * @author zr
 * @create 2021-04-09-8:18
 */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * 输入
 * {5,4,#,3,#,2,#,1}
 *
 * 返回值
 * [5,4,3,2,1]
 */
public class JZ22 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        if(root==null)
            return list;

        TreeNode node = root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(node);

        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            list.add(poll.val);

            if(poll.left!=null)
                queue.add(poll.left);

            if(poll.right!=null)
                queue.add(poll.right);
        }

        return list;
    }
}
