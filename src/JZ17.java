/**
 * @author zr
 * @create 2021-04-06-20:29
 */

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 *
 * 输入
 * {8,8,#,9,#,2,#,5},{8,9,#,2}
 *
 * 返回值
 * true
 */
public class JZ17 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }


    public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        if(root1==null || root2==null)
            return false;

        if(root1.val == root2.val){//根值相等 看是不是相同
            if(judge(root1, root2))
                return true;
        }

        return HasSubtree(root1.left, root2)||HasSubtree(root1.right, root2);
    }

    public boolean judge(TreeNode root1,TreeNode root2){
        if(root1==null && root2!=null)//
            return false;

        if(root2==null)
            return true;

        if(root1.val == root2.val){
            //往下比
            return judge(root1.left, root2.left)&&judge(root1.right, root2.right);
        }

        return false;
    }

    /*public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        if(root1==null||root2==null)
            return false;

        if(root1.val == root2.val){//根相等才判断
            if(judge(root1, root2))
                return true;
        }

        return HasSubtree(root1.left, root2)||HasSubtree(root1.right, root2);
    }

    public boolean judge(TreeNode root1,TreeNode root2){

        if(root1==null&&root2!=null)//大树找完了 小树还有
            return false;

        if(root2==null)//小树找完了
            return true;

        if(root1.val == root2.val)
            return judge(root1.left,root2.left)&&judge(root1.right, root2.right);

        return false;

    }*/
}
