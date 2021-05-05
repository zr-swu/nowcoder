/**
 * @author zr
 * @create 2021-05-05-12:45
 */

/**
 *题目描述
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * 示例1
 * 输入
 * {8,6,6,5,7,7,5}
 * 返回值
 * true
 *
 * 示例2
 * 输入
 * {8,6,9,5,7,7,5}
 * 返回值
 * false
 */


public class JZ58 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    boolean isSymmetrical(TreeNode pRoot) {
        return pRoot==null || isSame(pRoot, pRoot);
    }

    boolean isSame(TreeNode p1 ,TreeNode p2){
        if(p1==null&&p2==null){
            return true;
        }else if(p1==null||p2==null){
            return false;
        }

        return p1.val== p2.val&&isSame(p1.left,p2.right)&&isSame(p1.right, p2.left);
    }
}
