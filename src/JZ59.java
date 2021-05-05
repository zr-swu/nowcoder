/**
 * @author zr
 * @create 2021-05-05-13:14
 */

import java.util.*;

/**
 * 题目描述
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * 示例1
 * 输入
 * 复制
 * {8,6,10,5,7,9,11}
 * 返回值
 * 复制
 * [[8],[10,6],[5,7,9,11]]
 */
public class JZ59 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if(pRoot==null)
            return result;

        int level = 1 ;//层数

        queue.add(pRoot);


        while (!queue.isEmpty()){

            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<>();

            while (size>0){
                TreeNode poll = queue.poll();
                tmp.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                size--;
            }

            if(level%2==0){
                Collections.reverse(tmp);
            }

            level++;
            result.add(tmp);

        }

        return result;
    }

    
    

}
