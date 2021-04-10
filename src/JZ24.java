/**
 * @author zr
 * @create 2021-04-10-20:33
 */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 * 示例1
 * 输入
 * {10,5,12,4,7},22
 * 返回值
 * [[10,5,7],[10,12]]
 *
 * 示例2
 * 输入
 * {10,5,12,4,7},15
 * 返回值
 * []
 */
public class JZ24 {

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    ArrayList<Integer> tmp = new ArrayList<>();

    int tmpIndex = 0;

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if(root==null)
            return  result;

        search(root, target, 0);

        return result;
    }

    public void search(TreeNode root,int target,int cur){

        if(root.left==null&&root.right==null){//叶子
            if(cur+root.val == target){//等于就加入result;
                tmp.add(root.val);
                int index = tmpIndex++;
                result.add((ArrayList<Integer>) tmp.clone());
                tmp.remove(index);
                tmpIndex--;
                return;
            }else
                return;
        }

        if(cur+root.val<=target){//可以往下走

            if(root.left!=null){
                tmp.add(root.val);
                int index = tmpIndex++;
                search(root.left, target, cur+root.val);
                tmp.remove(index);
                tmpIndex--;
            }
            if(root.right!=null){
                tmp.add(root.val);
                int index = tmpIndex++;
                search(root.right, target, cur+root.val);
                tmp.remove(index);
                tmpIndex--;
            }
        }else {//没走到叶子就已经大于了
            return;
        }

    }

    @Test
    public void test(){
        TreeNode _10 = new TreeNode(10);
        TreeNode _5 = new TreeNode(5);
        TreeNode _12 = new TreeNode(12);
        TreeNode _4 = new TreeNode(4);
        TreeNode _7 = new TreeNode(7);

        _10.left = _5;
        _10.right = _12;
        _5.left = _4;
        _5.right = _7;

        ArrayList<ArrayList<Integer>> arrayLists = FindPath(_10, 22);

        arrayLists.stream().forEach(System.out::println);

    }
}
