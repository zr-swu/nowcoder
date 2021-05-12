/**
 * @author zr
 * @create 2021-05-12-20:34
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目描述
 * 给定一棵二叉搜索树，请找出其中的第k小的TreeNode结点。
 *
 * 示例1
 * 输入
 * {5,3,7,2,4,6,8},3
 *
 * 返回值
 * {4}
 *
 * 说明
 * 按结点数值大小顺序第三小结点的值为4
 */
public class JZ62 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    TreeNode KthNode(TreeNode pRoot, int k) {

        ArrayList<TreeNode> inOrderList = new ArrayList<>();
        inOrder(pRoot,inOrderList,k);

        if(k>=1 && inOrderList.size()>=k){

            return inOrderList.get(k-1);
        }
        return null;
    }

    int index = 0;

    ArrayList<TreeNode> inOrder(TreeNode pRoot,ArrayList<TreeNode> a,int k){
        if(pRoot==null)
            return a;

        if(pRoot.left!=null)
            inOrder(pRoot.left,a,k);


        a.add(pRoot);

        if(index > k-1)
            return a;

        if(pRoot.right!=null)
            inOrder(pRoot.right,a,k);

        return a;
    }
}
