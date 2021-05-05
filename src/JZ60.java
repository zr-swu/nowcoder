/**
 * @author zr
 * @create 2021-05-05-15:33
 */

import sun.plugin.javascript.navig.Link;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 示例1
 * 输入
 * 复制
 * {8,6,10,5,7,9,11}
 * 返回值
 * 复制
 * [[8],[6,10],[5,7,9,11]]
 */
public class JZ60 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }


    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        if(pRoot==null)
            return result;

        queue.add(pRoot);

        while (!queue.isEmpty()){

            int size = queue.size();

            ArrayList<Integer> tmp = new ArrayList<>();

            while (size>0){
                TreeNode poll = queue.poll();
                tmp.add(poll.val);

                if(poll.left!=null)
                    queue.add(poll.left);

                if(poll.right!=null)
                    queue.add(poll.right);

                size--;
            }

            result.add(tmp);

        }

        return result;
    }


}
