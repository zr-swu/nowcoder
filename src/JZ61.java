/**
 * @author zr
 * @create 2021-05-11-17:07
 */

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
 * 从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
 * 序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），
 * 以 ！ 表示一个结点值的结束（value!）。
 *
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 *
 * 例如，我们可以把一个只有根节点为1的二叉树序列化为"1,"，然后通过自己的函数来解析回这个二叉树
 * 示例1
 * 输入
 * {8,6,10,5,7,9,11}
 * 返回值
 * {8,6,10,5,7,9,11}
 */
public class JZ61 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    String Serialize(TreeNode root) {
        if(root==null)
            return "#,";

        String str = new String(root.val + ",");
        String left = Serialize(root.left);
        String right = Serialize(root.right);

        String resultString = new String(str+left+right);
        return resultString;
    }

    StringBuilder builder = null;

    TreeNode Deserialize(String str) {

        if(builder==null)
            builder = new StringBuilder(str);

        System.out.println(builder.toString());
        //空节点
        if(builder.charAt(0)=='#'){
            builder.deleteCharAt(0);//#
            builder.deleteCharAt(0);//,
            return null;
        }

        int num = 0;
        while (builder.charAt(0)!=','){
            num = num*10 + (builder.charAt(0)-'0');
            builder.deleteCharAt(0);
        }

        //退出时等于逗号
        builder.deleteCharAt(0);

        TreeNode root = new TreeNode(num);
        root.left = Deserialize("");
        root.right = Deserialize("");

        return root;
    }

    @Test
    public void test(){
        TreeNode _1 = new TreeNode(1);
        TreeNode _2 = new TreeNode(2);
        TreeNode _3 = new TreeNode(3);
        TreeNode _4 = new TreeNode(4);
        TreeNode _5 = new TreeNode(5);
        TreeNode _6 = new TreeNode(6);
        TreeNode _7 = new TreeNode(7);

        _1.left = _2;
        _1.right = _3;

        _2.left = _4;
        _2.right = _5;

        _3.left = _6;
        _3.right = _7;

        String serialize = Serialize(_1);
        System.out.println(serialize);

        TreeNode deserialize = Deserialize(serialize);

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(deserialize);

        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            System.out.println(poll.val + " ");

            if(poll.left!=null)
                queue.add(poll.left);
            if(poll.right!=null)
                queue.add(poll.right);
        }
    }
}
