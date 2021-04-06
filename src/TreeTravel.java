import java.util.Stack;

/**
 * @author zr
 * @create 2021-04-06-22:09
 */
public class TreeTravel {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /*public  void InOrderWithoutRecursion(TreeNode root){

        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();

        while (p!=null||!stack.empty()){
            while (p!=null){//沿着左节点一直入栈
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            System.out.println(p.val);

            if(p.right!=null){
                p = p.right;
            }else
                p = null;
        }

    }*/


    /**
     * 根入栈
     * 弹栈 输出 把右子树和左子树入栈（右在下 左在上）
     * 弹栈 输出 把右子树和左子树入栈（右在下 左在上）
     * @param root
     */
    /*public void preOrder(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        TreeNode p = null;
        while (!s.empty()) {
            p = s.pop();
            if (p != null) {
                System.out.print(p.val + " ");
                s.push(p.right);
                s.push(p.left);
            }
        }
    }*/


    /**
     * difficult
     * @param root
     */
    /*public void postOrder(TreeNode root) {

        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        while (p != null || !s.empty()) {
            while (p != null) {
                s.push(p);
                p = p.left;
            }
            p = s.pop();//左下侧的元素
            System.out.print(p.val + " ");
            //这里需要判断一下，当前p是否为栈顶的左子树，如果是的话那么还需要先访问右子树才能访问根节点
            //如果已经是不是左子树的话，那么说明左右子书都已经访问完毕，可以访问根节点了，所以讲p复制为NULL
            //取根节点
            if (!s.empty() && p == s.peek().left) {
                //是栈顶的左子树 还要访问右边
                p = s.peek().right;
            } else p = null;//不是栈顶的左子树 说明可以访问栈顶了
        }
    }*/
    public void postOrder(TreeNode root) {
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();

        while (p!=null || !stack.empty()){
            while (p!=null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            System.out.println(p.val);

            if(p == stack.peek().left){
                p = stack.peek().right;
            }else
                p = null;

        }
    }

    public void preOrder(TreeNode root){
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.empty()){
            p = stack.pop();
            if(p!=null){
                System.out.println(p.val);

                stack.push(p.right);
                stack.push(p.left);
            }

        }
    }

    public  void InOrderWithoutRecursion(TreeNode root){
        TreeNode p =root;
        Stack<TreeNode> stack = new Stack<>();

        while (p!=null || !stack.empty()){
            while (p!=null){
                stack.push(p);
                p=p.left;
            }
            p = stack.pop();
            System.out.println(p.val);

            if(p.right!=null)
                p = p.right;
            else
                p = null;
        }
    }


}
