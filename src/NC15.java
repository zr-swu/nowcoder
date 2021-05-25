/**
 * @author zr
 * @create 2021-05-25-17:07
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 * 给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
 * 例如：
 * 给定的二叉树是{3,9,20,#,#,15,7},
 * <p>
 * 该二叉树层序遍历的结果是
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 示例1
 * 输入
 * 复制
 * {1,2}
 * 返回值
 * 复制
 * [[1],[2]]
 * 示例2
 * 输入
 * 复制
 * {1,2,3,4,#,#,5}
 * 返回值
 * 复制
 * [[1],[2,3],[4,5]]
 */
public class NC15 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    /**
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write code here

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        if(root==null)
            return result;

        queue.add(root);


        while (!queue.isEmpty()){

            int size = queue.size();

            ArrayList<Integer> list = new ArrayList<>();

            for(int i=0;i<size;i++){

                list.add(queue.peek().val);

                TreeNode poll = queue.poll();

                if(poll.left!=null)
                    queue.add(poll.left);

                if(poll.right!=null)
                    queue.add(poll.right);
            }

            result.add(list);
        }

        return result;
    }

}
